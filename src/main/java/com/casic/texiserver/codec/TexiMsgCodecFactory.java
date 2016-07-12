package com.casic.texiserver.codec;

import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageEncoder;
import com.casic.texiserver.msg.texi.TexiMsg;

public class TexiMsgCodecFactory extends DemuxingProtocolCodecFactory {
	private MessageDecoder decoder;

	private MessageEncoder<TexiMsg> encoder;

	public TexiMsgCodecFactory(MessageDecoder decoder, MessageEncoder<TexiMsg> encoder) {
		this.decoder = decoder;
		this.encoder = encoder;
		addMessageDecoder(this.decoder);
		addMessageEncoder(TexiMsg.class, this.encoder);
	}
}