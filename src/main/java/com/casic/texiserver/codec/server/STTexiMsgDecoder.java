package com.casic.texiserver.codec.server;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;

import com.casic.texiserver.codec.server.impl.STTexiBodyCodecFactoryImpl;
import com.casic.texiserver.codec.server.impl.STTexiHeaderCodecImpl;
import com.casic.texiserver.msg.server.STTexiHeader;
import com.casic.texiserver.msg.server.STTexiMsg;
/**
 * 解码器
 * @author ChenHui
 *
 */
public class STTexiMsgDecoder implements MessageDecoder {

    
	private ISTTexiHeaderCodec sttexiReqHeaderCodec = new STTexiHeaderCodecImpl();
	private ISTTexiBodyCodecFactory sttexiReqBodyCodecFactory =  new STTexiBodyCodecFactoryImpl();

  

    @Override
    public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
        if (in.remaining() < 20) {
            return MessageDecoderResult.NEED_DATA;
        }
        return MessageDecoderResult.OK;
    }

    @Override
    public MessageDecoderResult decode(IoSession session, IoBuffer in,
            ProtocolDecoderOutput out) {
        STTexiMsg msg = new STTexiMsg();
    	STTexiHeader sTheader = sttexiReqHeaderCodec.decoder(in);
    	ISTTexiBodyCodec sTTexiReqBodyCodec = sttexiReqBodyCodecFactory.getTexiReqBodyCodec(sTheader.getMsgId());
    	byte[] data = new byte[ sTheader.getMsgLength()];
    	in.get(data);
    	msg.setHeader(sTheader);
    	msg.setBody(sTTexiReqBodyCodec.decodeBody(data));
    	out.write(msg);
        return MessageDecoderResult.OK;
    }

    @Override
    public void finishDecode(IoSession session, ProtocolDecoderOutput out)
            throws Exception {
    }

}