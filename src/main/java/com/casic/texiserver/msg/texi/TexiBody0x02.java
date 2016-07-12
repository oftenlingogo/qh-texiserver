package com.casic.texiserver.msg.texi;

public class TexiBody0x02 {
	private byte[] name;
	private short age;
	public byte[] getName() {
		return name;
	}
	public void setName(byte[] name) {
		this.name = name;
	}
	public short getAge() {
		return age;
	}
	public void setAge(short age) {
		this.age = age;
	}
	
}
