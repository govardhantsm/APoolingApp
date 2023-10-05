package com.tyss.ApollingApp.util;

public class GenaratePassword {

	public String genarateStyring(String str1,String str2)
	{
		int l=str2.length()-1;
		return str1.substring(0, 3)+str2.substring(l-4, l);
	}
}
