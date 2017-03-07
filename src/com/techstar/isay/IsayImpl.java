package com.techstar.isay;

public class IsayImpl implements Isay {

	@Override
	public String sayHello(String str1, String str2) {
		return "Hello Hessian:"+str1+" "+str2;
	}

}
