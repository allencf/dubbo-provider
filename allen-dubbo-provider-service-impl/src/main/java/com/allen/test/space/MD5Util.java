package com.allen.test.space;

import java.security.MessageDigest;

public class MD5Util {
	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		String stringA="appid=wx48f0fb12fc962c9b&body=店铺购买&mch_id=1246366001&nonce_str=ZVHYFIF4TDTMEIL8N8Z988JWUHNNND5G&notify_url=http://localhost:8080/baojia/wx_pay_notify&out_trade_no=13313820160727150009&product_id=14&spbill_create_ip=192.168.1.168&time_stamp=1469760045933&total_fee=1&trade_type=NATIVE&key=E3B2F04F8C61AB050853CB84DB5DBEB8"; 
		
		String md5 = MD5(stringA);
		System.err.println(md5);
	}
}
