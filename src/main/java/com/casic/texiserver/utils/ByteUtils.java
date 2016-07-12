package com.casic.texiserver.utils;

public class ByteUtils {

	public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
		byte[] byte_3 = new byte[byte_1.length + byte_2.length];
		System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
		System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
		return byte_3;
	}

	/**
	 * 注释：short到字节数组的转换！
	 * 
	 * @param s
	 * @return
	 */
	public static byte[] shortToByte(short number) {
		int temp = number;
		byte[] b = new byte[2];
		for (int i = 0; i < b.length; i++) {
			b[i] = new Integer(temp & 0xff).byteValue();//将最低位保存在最低位 
			temp = temp >> 8; // 向右移8位
		}
		return b;
	}

	/**
	 * 注释：字节数组到short的转换！
	 * 
	 * @param b
	 * @return
	 */
	public static short byteToShort(byte[] b) {
		short s = 0;
		short s0 = (short) (b[0] & 0xff);// 最低位
		short s1 = (short) (b[1] & 0xff);
		s1 <<= 8;
		s = (short) (s0 | s1);
		return s;
	}

	public static byte[] subBytes(byte[] src, int begin, int count) {
		byte[] bs = new byte[count];
		for (int i = begin; i < begin + count; i++)
			bs[i - begin] = src[i];
		return bs;
	}

	public static void main(String[] args) {
		byte[] d = shortToByte((short) 0x05);
		System.out.println(byteToShort(d));
	}
}
