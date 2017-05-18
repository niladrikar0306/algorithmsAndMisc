package mapdecoder;

import java.util.HashMap;
import java.util.Map;

public class MyMapDecoder implements MapDecoder
{
    @Override
    public Map<String, String> decode(String s)
    {
    	Map<String, String> m = new HashMap<>();
    	if(s==null){
    		return null;
    	}
    	String s1 = s.trim();
    	if(s1.length()==0){
    		return m;
    	}
    	
    	String[] pairs = s1.split("&");
    	if(pairs==null || s1.startsWith("&") || s1.endsWith("&")){
    		throw new IllegalArgumentException();
    	}
    	for(String p : pairs){
    		p=p.trim();
    		String[] elems = p.split("=");
    		if(elems == null || elems.length==0 || elems.length > 2 || !p.contains("=")){
    			throw new IllegalArgumentException();
    		}
    		if(p.indexOf("=")==0){
    			if(elems[0].trim().length() == 0 && elems.length>1)
    				m.put(null, elems[1]);
    			else
    				m.put(null, elems[0]);
    				
    		} else if (p.indexOf("=")==p.length()-1) {
    			m.put(elems[0].trim(), null);
    		} else {
    			m.put(elems[0].trim(), elems[1].trim());
    		}
    	}
    	
        return m;
    }
}
