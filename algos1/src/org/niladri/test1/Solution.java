package org.niladri.test1;

import java.util.List;
import java.util.ArrayList;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{ 
    
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int totalScore(String[] blocks, int n)
	{
	    List<Integer> scores = new ArrayList<Integer>();
	    int res = 0;
	    
	    scores.add(0);
	    scores.add(0);
	    scores.add(0);
	    scores.add(0);
	    scores.add(0);
	    scores.add(0);
	    scores.add(0);
	    scores.add(0);
	    for(int i=0;i<n;i++){
	        int cur = 0;
	        if(isNumber(blocks[i])){
	            cur =  Integer.parseInt(blocks[i]);
	            scores.add(cur);
	            res = res + cur;
	        } else if("X".equals(blocks[i])){
	            cur = scores.get(scores.size()-1)*2;
	            scores.add(cur);
	            res = res + cur;
	        } else if("+".equals(blocks[i])){
	            cur = scores.get(scores.size()-1) + scores.get(scores.size()-2);
	            res = res + cur;
	            scores.add(cur);
	        } 
	        else if("Z".equals(blocks[i])){
	            cur = scores.get(scores.size()-1);
	            res = res - cur;
	            scores.remove(scores.size()-1);
	        } 
	    }
		
		return res;
		
	}
	// METHOD SIGNATURE ENDS
	
	private static boolean isNumber(String s){
	    boolean res = false;
	    try{
	        Integer.parseInt(s);
	        res = true;
	    } catch(Exception e) {
	        
	    }
	    return res;
	}
}