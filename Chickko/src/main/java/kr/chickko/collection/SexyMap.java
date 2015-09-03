package kr.chickko.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import kr.chickko.util.JSON;

public class SexyMap extends java.util.HashMap {
	
	public SexyMap(){}
	public SexyMap(Map m){
		this.putAll(m);
	}
	
	public SexyMap(Map<?,?> header, Map<?,?> body){
		
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		Set set = this.entrySet();
		Iterator iter = set.iterator();
		
//		sb.append("--------------------------------\n");
		while( iter.hasNext() ){
			Map.Entry e =  (java.util.Map.Entry) iter.next();
			sb.append("KEY = " + e.getKey() + " :: VAL = " + e.getValue() + "  ");
		}
//		sb.append("--------------------------------");
		
		sb.deleteCharAt( sb.length() - 1 );
		return sb.toString();
	}
	
	   public String getParmString(String key){                         
	      return getParmString(key, "");
	   }
	   
	   public String getParmString(String key, String defaultValue){
	      String s = MapUtils.getString(this, key, defaultValue);
	      if(StringUtils.isEmpty(s))
	         s = defaultValue;
	      return s;
	   }
	   
	public SexyMap getHeader(){
		return JSON.fromJson(this.get("header"), SexyMap.class);
	}
	public SexyMap getBody(){
		return JSON.fromJson(this.get("body"), SexyMap.class);
	}
}
