package com.casic.texiserver.codec.server;

import org.apache.mina.core.buffer.IoBuffer;

import com.casic.texiserver.msg.server.STTexiHeader;

public interface ISTTexiHeaderCodec {
	void encoder(STTexiHeader header,IoBuffer buf);
	STTexiHeader decoder(IoBuffer buf);
}
