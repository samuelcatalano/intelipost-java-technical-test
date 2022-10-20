package com.br.intelipost.intelipost.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Samuel Catalano
 */
public class IntelipostApplicationUtils{
	
	/**
	 * Get password using MD5
	 * @param password the password
	 * @return password using MD5
	 * @throws NoSuchAlgorithmException
	 */
	public static String getMD5Password(final String password) throws NoSuchAlgorithmException{
		final MessageDigest md = MessageDigest.getInstance("MD5");
		final byte[] messageDigest = md.digest(password.getBytes());
		final BigInteger number = new BigInteger(1, messageDigest);
		return number.toString(16);
	}
}