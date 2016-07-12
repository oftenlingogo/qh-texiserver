package com.casic.texiserver.msg.server;

public class STTexiHeader {
	
	private short msgId;
	private short msgLength;
	private String terminalId;
	private String timestamp;
	
	
	public short getMsgId() {
		return msgId;
	}
	public void setMsgId(short msgId) {
		this.msgId = msgId;
	}
	public short getMsgLength() {
		return msgLength;
	}
	public void setMsgLength(short msgLength) {
		this.msgLength = msgLength;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
}
