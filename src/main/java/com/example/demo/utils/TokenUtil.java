package com.example.demo.utils;

import java.security.MessageDigest;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;

public class TokenUtil {
	final Base64.Decoder decoder = Base64.getDecoder();
	final static Base64.Encoder encoder = Base64.getEncoder();
	
	public String tokenHendle(String text) throws Exception {
		if(StringUtils.isBlank(text)) throw new Exception("token value is empty");
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		sha.update(text.getBytes("utf8"));   
		return encoder.encodeToString(sha.digest());
	}
	
	//System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
}

