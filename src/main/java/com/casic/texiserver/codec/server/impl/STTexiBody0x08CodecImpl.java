package com.casic.texiserver.codec.server.impl;

import java.io.UnsupportedEncodingException;

import com.casic.texiserver.codec.server.ISTTexiBodyCodec;
import com.casic.texiserver.msg.server.STTexiBody0x08;
import com.casic.texiserver.utils.ByteUtils;
import com.casic.texiserver.utils.Constant;

public class STTexiBody0x08CodecImpl implements ISTTexiBodyCodec {

	@Override
	public byte[] encodeBody(Object data) {
		STTexiBody0x08 body = (STTexiBody0x08) data;
		byte[] bSoftWare = ByteUtils.shortToByte(body.getSoftwareVersionId());
		byte[] bUrl = new byte[100];
		for (int i = 0; i < 100; i++)
			bUrl[i] = '\0';
		byte[] urls = body.getUrl().getBytes();
		System.arraycopy(urls, 0, bUrl, 0, urls.length);
		return ByteUtils.byteMerger(bSoftWare, bUrl);
	}

	@Override
	public Object decodeBody(byte[] data) {
		STTexiBody0x08 body = new STTexiBody0x08();

		body.setSoftwareVersionId(ByteUtils.byteToShort(ByteUtils.subBytes(data, 0, 2)));

		byte[] bUrls = ByteUtils.subBytes(data, 2, data.length - 2);

		try {
			String url = new String(bUrls, Constant.CHARSET);
			body.setUrl(url);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return body;
	}

}
