package com.casic.texiserver.codec.server.impl;

import com.casic.texiserver.codec.server.ISTTexiBodyCodec;
import com.casic.texiserver.codec.server.ISTTexiBodyCodecFactory;

public class STTexiBodyCodecFactoryImpl implements ISTTexiBodyCodecFactory {
	
	private ISTTexiBodyCodec sTTexiBody0x06CodecImpl = new STTexiBody0x06CodecImpl();
	private ISTTexiBodyCodec sTTexiBody0x08CodecImpl = new STTexiBody0x08CodecImpl();

	public ISTTexiBodyCodec getTexiReqBodyCodec(short msgId) {
		switch (msgId){
			case  0x06:
				return sTTexiBody0x06CodecImpl;
			case 0x08:
				return sTTexiBody0x08CodecImpl;
			default:
				return null;
		}
			
	}

}
