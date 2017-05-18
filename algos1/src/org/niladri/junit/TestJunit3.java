package org.niladri.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestJunit3 {
	
	@Test
	public void testAdd() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine", str);
	}
	
}
