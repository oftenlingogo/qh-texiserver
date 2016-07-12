package com.casic.texiserver.codec.server.impl;

import org.apache.mina.core.buffer.IoBuffer;
import com.casic.texiserver.codec.server.ISTTexiHeaderCodec;
import com.casic.texiserver.msg.server.STTexiHeader;
import com.casic.texiserver.utils.BcdCodec;

public class STTexiHeaderCodecImpl implements  ISTTexiHeaderCodec{

	public void encoder(STTexiHeader header, IoBuffer buf) {
		buf.putShort(header.getMsgId());
        buf.putShort(header.getMsgLength());
        buf.put(BcdCodec.str2Bcd(header.getTerminalId()));
        buf.put(BcdCodec.str2Bcd(header.getTimestamp()));
	}
	
	public STTexiHeader decoder(IoBuffer buf){
		STTexiHeader header = new STTexiHeader();
		header.setMsgId(buf.getShort());
        header.setMsgLength(buf.getShort());
		byte[] bterminalId = new byte[6];
		buf.get(bterminalId, 0, 6);
		header.setTerminalId(BcdCodec.bcd2Str(bterminalId));
		byte[] btimestamp = new byte[6];
		buf.get(btimestamp, 0, 6);
		header.setTimestamp(BcdCodec.bcd2Str(btimestamp));
		return header;
	}
}
