package com.casic.texiserver.codec.texi;

public interface ITexiBodyCodecFactory {
	public ITexiBodyCodec getTexiReqBodyCodec(short msgId);
}
