package com.wangyuena.test;

import org.junit.Test;

import com.wangyuena.utils.Md5Utils;





public class TestMd5 {
	
	@Test
	public void  testMd5() {
		String s = "wode mima";
		String m = Md5Utils.md5(s);
		System.out.println("密文是 " + m);
		
	}

}
