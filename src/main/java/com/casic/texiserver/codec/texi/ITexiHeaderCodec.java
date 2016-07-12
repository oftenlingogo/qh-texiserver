package com.casic.texiserver.codec.texi;

import org.apache.mina.core.buffer.IoBuffer;

import com.casic.texiserver.msg.texi.TexiHeader;

public interface ITexiHeaderCodec {
	void encoder(TexiHeader header,IoBuffer buf);
	TexiHeader decoder(IoBuffer buf);
}
