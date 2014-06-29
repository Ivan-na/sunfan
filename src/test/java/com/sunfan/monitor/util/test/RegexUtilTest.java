package com.sunfan.monitor.util.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sunfan.monitor.util.RegexUtil;

public class RegexUtilTest {
	RegexUtil util = new RegexUtil();

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		String text = "aaabbbcccdddeee+\r\naaabbbcccdddeee";
		String regex = "a.*c";
		List lis = util.matchRegex(text, regex);
		System.out.println(lis);
	}

}
