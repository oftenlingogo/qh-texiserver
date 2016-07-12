package com.casic.texiserver.codec.texi.impl;

import java.io.UnsupportedEncodingException;
import com.casic.texiserver.codec.texi.ITexiBodyCodec;
import com.casic.texiserver.msg.texi.TexiBody0x01;
import com.casic.texiserver.utils.Constant;

public class TexiBody0x01CodecImpl implements ITexiBodyCodec {

	public byte[] encodeBody(Object data) {
		TexiBody0x01 body = (TexiBody0x01)data;
		return body.getMsg().getBytes();
	}

	public Object decodeBody(byte[] data) {
		// TODO Auto-generated method stub
		TexiBody0x01 body =  new TexiBody0x01();
		try {
			body.setMsg(new String(data, Constant.CHARSET));
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return body;
	}

}
