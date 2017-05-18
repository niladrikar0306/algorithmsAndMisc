package org.niladri.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import matrix.FindMaxApple;
import matrix.FindMaxAppleFlopWithDisjiktra;
import matrix.FindMaxAppleWithToken;

public class FindAppleWithTokenTest {
	
	@Test
	public void test1(){
		int[][] m = {{4,0,1},
				{1,0,0},
				{0,4,0}};
		int res = new FindMaxAppleWithToken().collectApplesWithTokens(m);
		assertEquals(11, res);
	}
	
	
	
	@Test
	public void test2(){
		int[][] m = {{4,0,1}};
		int res = new FindMaxAppleWithToken().collectApplesWithTokens(m);
		assertEquals(10, res);
	}
	
	@Test
	public void test3(){
		int[][] m = {{8}};
		int res = new FindMaxAppleWithToken().collectApplesWithTokens(m);
		assertEquals(16, res);
	}
	
	@Test
	public void test4(){
		int[][] m = null;
		int res = new FindMaxAppleWithToken().collectApplesWithTokens(m);
		assertEquals(0, res);
	}
	
	@Test
	public void test5(){
		int[][] m = new int[0][0];
		int res = new FindMaxAppleWithToken().collectApplesWithTokens(m);
		assertEquals(0, res);
	}

	
	@Test
	public void test6(){
		int[][] m = {{4,0,1,6},
				{1,0,0,8},
				{0,4,0,5}};
		int res = new FindMaxAppleWithToken().collectApplesWithTokens(m);
		assertEquals(37, res);
	}
	
	@Test
	public void test7(){
		int[][] m = {{25,0,1,6},
				{1,0,0,8},
				{0,4,0,5}};
		int res = new FindMaxAppleWithToken().collectApplesWithTokens(m);
		assertEquals(64, res);
	}
	
	@Test
	public void test8(){
		int[][] m = {{4,0,1,6},
				{1,0,0,8},
				{5,4,0,8}};
		int res = new FindMaxAppleWithToken().collectApplesWithTokens(m);
		assertEquals(47, res);
	}
	
	@Test
	public void test9(){
		int[][] m = {{25,0,1,6},
				{1,0,0,8},
				{6,4,0,5}};
		int res = new FindMaxAppleWithToken().collectApplesWithTokens(m);
		assertEquals(70, res);
	}
	
	

}
