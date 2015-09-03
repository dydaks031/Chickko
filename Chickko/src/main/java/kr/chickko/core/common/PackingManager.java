package kr.chickko.core.common;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonObject;

import kr.chickko.collection.SexyMap;
import kr.chickko.util.JSON;

public class PackingManager {
	Map mHeader = null;
	String sResultCode = "200";
	
	public PackingManager(){};
	
	public Map<String,String> unpack(String json){
		SexyMap requestParam = new SexyMap(JSON.fromJson(json, SexyMap.class));
		SexyMap header = JSON.fromJson(requestParam.get("header"), SexyMap.class);
		System.out.println(header.getParmString("encYn"));
		System.out.println(header.getParmString("compYn"));
		SexyMap body = JSON.fromJson(requestParam.get("body"), SexyMap.class);
		System.out.println(body.getParmString("userId"));
		System.out.println(body.getParmString("userPwd"));
		
		return null;
	}
}
