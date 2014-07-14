package com.pekall.test.mdmui.util;

public class Unicode {
	public static String getUnicode(String source){
		System.out.println("source: "+source);
		 String uniCodeTemp=null;
		 StringBuffer sb = new StringBuffer();
		 for(int i=0;i<source.length();i++){
		  uniCodeTemp = "\\u"+Integer.toHexString((int)source.charAt(i));
		  sb.append(uniCodeTemp);
		 }
		 System.out.println(sb.toString());
		  return sb.toString();
	} 
}
