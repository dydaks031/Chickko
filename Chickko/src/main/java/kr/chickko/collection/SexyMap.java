package kr.chickko.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SexyMap extends java.util.HashMap {
	
	public SexyMap(){}
	public SexyMap(Map m){
		this.putAll(m);
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		Set set = this.entrySet();
		Iterator iter = set.iterator();
		
//		sb.append("--------------------------------\n");
		while( iter.hasNext() ){
			Map.Entry e =  (java.util.Map.Entry) iter.next();
			sb.append(e.getKey() + " :: " + e.getValue() + "  ");
		}
//		sb.append("--------------------------------");
		
		sb.deleteCharAt( sb.length() - 1 );
		return sb.toString();
	}
}
