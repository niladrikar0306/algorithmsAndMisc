package org.niladri.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import findarray2.FindArray;
import findarray2.MyFindArray;

public class MyFindArrayTest {
	
	@Test
	public void test1() {
		FindArray fa = new MyFindArray();
		int[] a = {1, 2, 3};
		int[] b = {};
		assertEquals(-1, fa.findArray(a, b));
	}
	
	@Test
	public void test2() {
		FindArray fa = new MyFindArray();
		int[] a = {1, 2, 3};
		int[] b = {3};
		assertEquals(2, fa.findArray(a, b));
	}
	
	@Test
	public void test3() {
		FindArray fa = new MyFindArray();
		int[] a = {1, 2, 3};
		int[] b = {1,2,3};
		assertEquals(0, fa.findArray(a, b));
	}
	
	@Test
	public void test4() {
		FindArray fa = new MyFindArray();
		int[] a = {1, 2, 3};
		int[] b = {3, 1};
		assertEquals(-1, fa.findArray(a, b));
	}
	
	@Test
	public void test6() {
		FindArray fa = new MyFindArray();
		int[] a = {4,9,3,7,8};
		int[] b = {3,7};
		assertEquals(2, fa.findArray(a, b));
	}
	
	@Test
	public void test7() {
		FindArray fa = new MyFindArray();
		int[] a = {1,3,5};
		int[] b = {1};
		assertEquals(0, fa.findArray(a, b));
	}
	
	@Test
	public void test5() {
		FindArray fa = new MyFindArray();
		int[] a = {7,8,9};
		int[] b = {8,9,10};
		assertEquals(-1, fa.findArray(a, b));
	}
	
	@Test
	public void test8() {
		FindArray fa = new MyFindArray();
		int[] a = {4,9,3,7,8,3,7,1};
		int[] b = {3,7};
		assertEquals(5, fa.findArray(a, b));
	}
	
	
	


	
	
	
}
