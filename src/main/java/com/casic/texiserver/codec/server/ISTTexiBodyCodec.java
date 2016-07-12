package com.casic.texiserver.codec.server;

public interface ISTTexiBodyCodec {
	public byte[] encodeBody(Object data);
	public Object decodeBody(byte[] data);
}