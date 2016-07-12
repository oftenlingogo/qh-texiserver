package com.casic.texiserver;

import java.net.InetSocketAddress;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import com.casic.texiserver.codec.TexiMsgCodecFactory;
import com.casic.texiserver.codec.server.STTexiMsgDecoder;
import com.casic.texiserver.codec.texi.TexiMsgEncoder;
import com.casic.texiserver.handler.ClientHandler;
import com.casic.texiserver.msg.texi.TexiBody0x01;
import com.casic.texiserver.msg.texi.TexiHeader;
import com.casic.texiserver.msg.texi.TexiMsg;
/**
 *
 */
public class TexiClientApp 
{
	private static String HOST = "127.0.0.1";

	private static int PORT = 8090;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// 创建一个非阻塞的客户端程序
		IoConnector connector = new NioSocketConnector();
		// 设置链接超时时间
		connector.setConnectTimeout(30000);
		// 添加过滤器
		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TexiMsgCodecFactory(new STTexiMsgDecoder(),new TexiMsgEncoder()
		)));
		// 添加业务逻辑处理器类
		connector.setHandler(new ClientHandler());
		IoSession session = null;
		try {
			ConnectFuture future = connector.connect(new InetSocketAddress(HOST, PORT));// 创建连接
			future.awaitUninterruptibly();// 等待连接创建完成
			session = future.getSession();// 获得session
			TexiHeader header = new TexiHeader();
			header.setMsgId((short)0x01);
			header.setMsgStatus((byte)1);
			header.setParamsVersionId((byte)2);
			header.setSoftwareId((byte)2);
			header.setTerminalId("123456654321");
			header.setTimestamp("160706102212");
			header.setSeq((short)100);
			
			TexiBody0x01 body = new TexiBody0x01();
			body.setMsg("dddd");
			TexiMsg msg = new TexiMsg();
			msg.setHeader(header);
			msg.setBody(body);
			session.write(msg);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("客户端链接异常...");
		}

		session.getCloseFuture().awaitUninterruptibly();// 等待连接断开
		connector.dispose();
	}
}
