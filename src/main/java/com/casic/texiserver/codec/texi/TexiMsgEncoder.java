package com.casic.texiserver.codec.texi;


import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;
import com.casic.texiserver.codec.texi.impl.TexiBodyCodeFactoryImpl;
import com.casic.texiserver.codec.texi.impl.TexiHeaderCodecImpl;
import com.casic.texiserver.msg.texi.TexiHeader;
import com.casic.texiserver.msg.texi.TexiMsg;


public class TexiMsgEncoder implements MessageEncoder<TexiMsg> {
	
	private ITexiHeaderCodec texiReqHeaderCodec = new TexiHeaderCodecImpl() ;
	private ITexiBodyCodecFactory texiReqBodyCodecFactory = new TexiBodyCodeFactoryImpl();



	@Override
	public void encode(IoSession session, TexiMsg msg, ProtocolEncoderOutput out) {
		// TODO Auto-generated method stub
		 IoBuffer buf=IoBuffer.allocate(1024).setAutoExpand(true);
		 TexiHeader header = msg.getHeader();
		 Object obj = msg.getBody();
		 ITexiBodyCodec msgBodyCode = texiReqBodyCodecFactory.getTexiReqBodyCodec(header.getMsgId());
		 byte[] data = msgBodyCode.encodeBody(obj);
		 header.setMsgLength((short)data.length);
		 texiReqHeaderCodec.encoder(header, buf);
		 buf.put(data);
		 buf.flip();
	     out.write(buf);
	}

}
