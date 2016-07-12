package com.casic.texiserver.codec.texi.impl;

import org.apache.mina.core.buffer.IoBuffer;

import com.casic.texiserver.codec.texi.ITexiHeaderCodec;
import com.casic.texiserver.msg.texi.TexiHeader;
import com.casic.texiserver.utils.BcdCodec;

public class TexiHeaderCodecImpl implements  ITexiHeaderCodec{

	/*
	 * 消息头编码
	 * @param header 消息头对象
	 * @param buf buffer对象
	 */
	public void encoder(TexiHeader header, IoBuffer buf) {
		buf.putShort(header.getMsgId());
        buf.putShort(header.getMsgLength());
        buf.put(header.getMsgStatus());
        buf.put(BcdCodec.str2Bcd(header.getTerminalId()));
        buf.put(header.getSoftwareId());
        buf.put(header.getParamsVersionId());
        buf.put(BcdCodec.str2Bcd(header.getTimestamp()));
        buf.putShort(header.getSeq());
	}
	/*
	 * 消息头解码
	 * @see com.casic.texiserver.codec.texi.ITexiHeaderCodec#decoder(org.apache.mina.core.buffer.IoBuffer)
	 */
	public TexiHeader decoder(IoBuffer buf){
		TexiHeader header = new TexiHeader();
		header.setMsgId(buf.getShort());
        header.setMsgLength(buf.getShort());
		header.setMsgStatus(buf.get());
		byte[] bterminalId = new byte[6];
		buf.get(bterminalId, 0, 6);
		header.setTerminalId(BcdCodec.bcd2Str(bterminalId));
		header.setSoftwareId(buf.get());
		header.setParamsVersionId(buf.get());
		byte[] btimestamp = new byte[6];
		buf.get(btimestamp, 0, 6);
		header.setTimestamp(BcdCodec.bcd2Str(btimestamp));
		header.setSeq(buf.getShort());
		return header;
	}
}
