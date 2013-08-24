package com.phoenix.vo;

import javax.crypto.KeyGenerator;

import org.junit.Test;


public class KeyTest {

	
	
	@Test
	public void test() throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(256); // 192 and 256 bits may not be available
		StringBuffer key = new StringBuffer();
		
		
		key.append(Utils.toHex(kgen.generateKey().getEncoded()));
		
		
		System.out.println("key length:"+kgen.generateKey().getEncoded().length);
		System.out.println("key:"+key);
	}
}

class Utils
{
    private static String digits = "0123456789abcdef";
    
    /**
     * Return length many bytes of the passed in byte array as a hex string.
     * 
     * @param data the bytes to be converted.
     * @param length the number of bytes in the data block to be converted.
     * @return a hex representation of length bytes of data.
     */
    public static String toHex(byte[] data, int length)
    {
        StringBuffer  buf = new StringBuffer();
        
        for (int i = 0; i != length; i++)
        {
            int v = data[i] & 0xff;
            
            buf.append(digits.charAt(v >> 4));
            buf.append(digits.charAt(v & 0xf));
        }
        
        return buf.toString();
    }
    
    /**
     * Return the passed in byte array as a hex string.
     * 
     * @param data the bytes to be converted.
     * @return a hex representation of data.
     */
    public static String toHex(byte[] data)
    {
        return toHex(data, data.length);
    }
}
