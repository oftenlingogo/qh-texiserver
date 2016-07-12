package com.casic.texiserver.codec.texi.impl;

import com.casic.texiserver.codec.texi.ITexiBodyCodec;
import com.casic.texiserver.codec.texi.ITexiBodyCodecFactory;

public class TexiBodyCodeFactoryImpl implements ITexiBodyCodecFactory {
	
	private ITexiBodyCodec texiReqBody0x01CodecImpl = new TexiBody0x01CodecImpl();
	private ITexiBodyCodec texiReqBody0x02CodecImpl = new TexiBody0x02CodecImpl();
	
	/*
	 * 根据不同的消息ID,返回对应的消息编解码器
	 * @see com.casic.texiserver.codec.texi.ITexiBodyCodecFactory#getTexiReqBodyCodec(short)
	 */
	public ITexiBodyCodec getTexiReqBodyCodec(short msgId) {
		switch (msgId){
			case  0x01:
				return texiReqBody0x01CodecImpl;
			case 0x02:
				return texiReqBody0x02CodecImpl;
			default:
				return null;
		}
			
	}

}
