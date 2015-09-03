package kr.chickko.util;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.*;

public class JSON {
	final static Gson g = new Gson();
	public static String toJson(Object o){return g.toJson(o);};
	public static <E> String toJson(List<E> o){return g.toJson(o);};
	public static String toJson(Map<?, ?> o){return g.toJson(o);};
	public static <T> T fromJson(String json, Class<T> classOfT ){ return g.fromJson(json, classOfT); };
	public static <T> T fromJson(String json, Type TypeOfT){ return g.fromJson(json, TypeOfT); };
	public static <T> T fromJson(Object json, Class<T> classOfT ){ return g.fromJson(json.toString(), classOfT); };
	public static <T> T fromJson(Object json, Type TypeOfT){ return g.fromJson(json.toString(), TypeOfT); };
	
}