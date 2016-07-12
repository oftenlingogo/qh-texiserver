package com.casic.texiserver.codec.texi;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageDecoderResult;

import com.casic.texiserver.codec.texi.impl.TexiBodyCodeFactoryImpl;
import com.casic.texiserver.codec.texi.impl.TexiHeaderCodecImpl;
import com.casic.texiserver.msg.texi.TexiHeader;
import com.casic.texiserver.msg.texi.TexiMsg;
/**
 * 解码器
 * @author ChenHui
 *
 */
public class TexiMsgDecoder implements MessageDecoder {

    private ITexiHeaderCodec texiHeaderCodec = new TexiHeaderCodecImpl();
	private ITexiBodyCodecFactory texiBodyCodecFactory = new TexiBodyCodeFactoryImpl();

    @Override
    public MessageDecoderResult decodable(IoSession session, IoBuffer in) {
        if (in.remaining() < 20) {
            return MessageDecoderResult.NEED_DATA;
        }
        short tag = in.getShort();
        if (tag == (short) 0x01) {
            System.out.println("请求标识符："+tag);
        }else{
            return MessageDecoderResult.NOT_OK;
        }
        return MessageDecoderResult.OK;
    }

    @Override
    public MessageDecoderResult decode(IoSession session, IoBuffer in,
            ProtocolDecoderOutput out) throws Exception {
        TexiMsg msg = new TexiMsg();
    	TexiHeader header = texiHeaderCodec.decoder(in);
    	ITexiBodyCodec texiReqBodyCodec = texiBodyCodecFactory.getTexiReqBodyCodec(header.getMsgId());
    	byte[] data = new byte[header.getMsgLength()];
    	in.get(data);
    	msg.setHeader(header);
    	msg.setBody(texiReqBodyCodec.decodeBody(data));
    	out.write(msg);
        return MessageDecoderResult.OK;
    }

    @Override
    public void finishDecode(IoSession session, ProtocolDecoderOutput out)
            throws Exception {
    }

}