package cn.com.oking.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {

	public static List<Map<String, Object>> listKeyMaps(String jsonString) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString,
                    new TypeToken<List<Map<String,Object>>>(){}.getType());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
    }
	
	public static Map<String, Object> listKeyMap(String jsonString) {
        Map<String, Object> list = new HashMap<String, Object>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString,
                    new TypeToken<Map<String, Object>>(){}.getType());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
    }
	
	
	public static List<Object> list(String jsonString) {
		List<Object> list = new ArrayList<Object>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString,
                    new TypeToken<List<Object>>(){}.getType());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
    }
	
	public static List<List<Object>> listKeyList(String jsonString) {
		List<List<Object>> list = new ArrayList<List<Object>>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString,
                    new TypeToken<List<List<Object>>>(){}.getType());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
    }
	
	
	public static List<Object[]> listKeyObjectz(String jsonString) {
		List<Object[]> list = new ArrayList<Object[]>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString,
                    new TypeToken<List<Object[]>>(){}.getType());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
    }
	
	public static Map<String, Map<String, Object>> listKeyMap2(String jsonString) {
        Map<String, Map<String, Object>> list = new HashMap<String, Map<String, Object>>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString,
                    new TypeToken<Map<String, Map<String, Object>>>(){}.getType());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
    }
	
	public static Map<String, List<Map<String, Object>>> listKeyMap3(String jsonString) {
		Map<String, List<Map<String, Object>>> list = new HashMap<String, List<Map<String, Object>>>();
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString,
                    new TypeToken<Map<String, List<Map<String, Object>>>>(){}.getType());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
    }
	
}
