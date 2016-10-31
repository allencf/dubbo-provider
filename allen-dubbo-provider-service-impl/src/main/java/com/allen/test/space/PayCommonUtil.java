package com.allen.test.space;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class PayCommonUtil {

	public static String getRequestXml(SortedMap<String, Object> parameters) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if ("detail".equalsIgnoreCase(k)) {
				sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
			} else {
				sb.append("<" + k + ">" + v + "</" + k + ">");
			}
		}
		sb.append("</xml>");
		return sb.toString();
	}

	public static String createSign(SortedMap<String, Object> parameters) {
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();// 所有参与传参的参数按照accsii排序（升序）
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=E3B2F04F8C61AB050853CB84DB5DBEB8");
		System.out.println(sb.toString());
		String sign = MD5(sb.toString());
		System.out.println(sign);
		return sign;
	}
	
	
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
	
	
	public static void test(){
		String nonceStr = "ZVHYFIF4TDTMEIL8N8Z988JWUHNNND5G";// RandomStringUtils.random(32, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"); // 8位随机数
		SortedMap<String, Object> params = new TreeMap<String, Object>();
		params.put("appid", "wx48f0fb12fc962c9b");	
		params.put("body", "店铺购买");	//商品描述。
		params.put("mch_id", "1246366001");
		params.put("nonce_str", nonceStr);
		params.put("notify_url", "http://localhost:8080/baojia/wx_pay_notify");
		params.put("product_id", "14"); 
		params.put("out_trade_no", "13313820160727150009"); //商户系统内部的订单号
		params.put("spbill_create_ip", "192.168.1.168"); // ip
		String timeStamp = "1469761612849" + "";
		params.put("time_stamp", timeStamp);
		params.put("total_fee", String.valueOf(1));	//订单总金额
		params.put("trade_type", "NATIVE"); //交易类型
		String paySign = PayCommonUtil.createSign(params);

	}
	
	public static void main(String[] args) {
		test();
		
		String str = "appid=wx48f0fb12fc962c9b&body=店铺购买&mch_id=1246366001&nonce_str=ZVHYFIF4TDTMEIL8N8Z988JWUHNNND5G&notify_url=http://localhost:8080/baojia/wx_pay_notify&out_trade_no=13313820160727150009&product_id=14&spbill_create_ip=192.168.1.168&time_stamp=1469761612849&total_fee=1&trade_type=NATIVE&key=E3B2F04F8C61AB050853CB84DB5DBEB8";
		
		System.out.println(str);
		System.out.println(MD5(str));
		
		//F7570D787A2E81EA7627C184CB216950
		//F7570D787A2E81EA7627C184CB216950
	}
	
}
