package com.casic.texiserver.msg.server;

public class STTexiMsg {
	private STTexiHeader header;
	private Object body;

	public STTexiHeader getHeader() {
		return header;
	}
	public void setHeader(STTexiHeader header) {
		this.header = header;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}	
