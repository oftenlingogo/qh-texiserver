package com.casic.texiserver.codec.server;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.apache.mina.filter.codec.demux.MessageEncoder;

import com.casic.texiserver.codec.server.impl.STTexiBodyCodecFactoryImpl;
import com.casic.texiserver.codec.server.impl.STTexiHeaderCodecImpl;
import com.casic.texiserver.msg.server.STTexiHeader;
import com.casic.texiserver.msg.server.STTexiMsg;


public class STTexiMsgEncoder implements MessageEncoder<STTexiMsg> {
	
	private ISTTexiHeaderCodec sttexiReqHeaderCodec = new STTexiHeaderCodecImpl();
	private ISTTexiBodyCodecFactory sttexiReqBodyCodecFactory =  new STTexiBodyCodecFactoryImpl();
	
	
	@Override
	public void encode(IoSession session, STTexiMsg msg, ProtocolEncoderOutput out) throws Exception {
		 IoBuffer buf=IoBuffer.allocate(1024).setAutoExpand(true);
		 STTexiHeader header = msg.getHeader();
		 Object obj = msg.getBody();
		 ISTTexiBodyCodec msgBodyCode = sttexiReqBodyCodecFactory.getTexiReqBodyCodec(header.getMsgId());
		 byte[] data = msgBodyCode.encodeBody(obj);
		 header.setMsgLength((short)data.length);
		 sttexiReqHeaderCodec.encoder(header, buf);
		 buf.put(data);
		 buf.flip();
	     out.write(buf);
	}

}
