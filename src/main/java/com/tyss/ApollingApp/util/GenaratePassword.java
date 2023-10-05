package com.tyss.ApollingApp.util;

import org.springframework.stereotype.Component;

@Component
public class GenaratePassword {

	public String genarateString(String str1,String str2)
	{
		int l=str2.length();
		return str1.substring(0, 4)+str2.substring(l-4, l);
	}
}
