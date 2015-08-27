package kr.chickko.util;

import java.util.List;
import java.util.Map;

import com.google.gson.*;

public class JSON {
	final static Gson g = new Gson();
	public static String toJson(Object o){return g.toJson(o);};
	public static <E> String toJson(List<E> o){return g.toJson(o);};
	public static String toJson(Map<?, ?> o){return g.toJson(o);};
	public static <T> T fromJson(String json, Class<T> classOfT ){ return g.fromJson(json, classOfT); };
}