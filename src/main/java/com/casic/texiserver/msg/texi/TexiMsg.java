package com.casic.texiserver.msg.texi;

public class TexiMsg {
	private TexiHeader header;
	private Object body;
	public TexiHeader getHeader() {
		return header;
	}
	public void setHeader(TexiHeader header) {
		this.header = header;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}	
