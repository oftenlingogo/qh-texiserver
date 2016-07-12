package com.casic.texiserver.msg.texi;

public class TexiHeader {
	
	private short msgId;
	private short msgLength;
	private byte msgStatus;
	private String terminalId;
	private byte softwareId;
	private byte paramsVersionId;
	private String timestamp;
	private short seq;
	
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
	public byte getMsgStatus() {
		return msgStatus;
	}
	public void setMsgStatus(byte msgStatus) {
		this.msgStatus = msgStatus;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public byte getSoftwareId() {
		return softwareId;
	}
	public void setSoftwareId(byte softwareId) {
		this.softwareId = softwareId;
	}
	public byte getParamsVersionId() {
		return paramsVersionId;
	}
	public void setParamsVersionId(byte paramsVersionId) {
		this.paramsVersionId = paramsVersionId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public short getSeq() {
		return seq;
	}
	public void setSeq(short seq) {
		this.seq = seq;
	}
	
	
}
