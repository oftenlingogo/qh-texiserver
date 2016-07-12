package com.casic.texiserver.codec.texi;

public interface ITexiBodyCodec {
	public byte[] encodeBody(Object data);
	public Object decodeBody(byte[] data);
}