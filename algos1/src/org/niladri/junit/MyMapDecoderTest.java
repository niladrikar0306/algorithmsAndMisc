package org.niladri.junit;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

import mapdecoder.MapDecoder;

public class MyMapDecoderTest {
	
	@Test
	public void testAdd() {
		MapDecoder md = new mapdecoder.MyMapDecoder();
		String s = "key1=value1%&key2=value&=value3&=value4";
		Map<String, String> m = md.decode(s);
		System.out.println(m);
		assertEquals("Junit is working fine", "");
	}
	
	@Test
	public void test1() {
		MapDecoder md = new mapdecoder.MyMapDecoder();
		String s = "    ";
		Map<String, String> m = md.decode(s);
		System.out.println(m);
		assertEquals("Junit is working fine", "");
	}
	@Test
	public void test3() {
		MapDecoder md = new mapdecoder.MyMapDecoder();
		String s = "key=";
		Map<String, String> m = md.decode(s);
		System.out.println(m);
		assertEquals("Junit is working fine", "");
	}
	
	@Test
	public void test4() {
		MapDecoder md = new mapdecoder.MyMapDecoder();
		String s = "=value";
		Map<String, String> m = md.decode(s);
		System.out.println(m);
		assertEquals("Junit is working fine", "");
	}
}
