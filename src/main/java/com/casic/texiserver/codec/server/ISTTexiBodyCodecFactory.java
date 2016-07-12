package com.casic.texiserver.codec.server;

public interface ISTTexiBodyCodecFactory {
	public ISTTexiBodyCodec getTexiReqBodyCodec(short msgId);
}
