package com.casic.texiserver.codec;

import org.apache.mina.filter.codec.demux.DemuxingProtocolCodecFactory;
import org.apache.mina.filter.codec.demux.MessageDecoder;
import org.apache.mina.filter.codec.demux.MessageEncoder;
import com.casic.texiserver.msg.server.STTexiMsg;

public class STTexiMsgCodecFactory extends DemuxingProtocolCodecFactory {
	private MessageDecoder decoder;

	private MessageEncoder<STTexiMsg> encoder;

	public STTexiMsgCodecFactory(MessageDecoder decoder, MessageEncoder<STTexiMsg> encoder) {
		this.decoder = decoder;
		this.encoder = encoder;
		addMessageDecoder(this.decoder);
		addMessageEncoder(STTexiMsg.class, this.encoder);
	}
}