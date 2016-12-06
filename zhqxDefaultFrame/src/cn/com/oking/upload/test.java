package cn.com.oking.upload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class test {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();  
		map.put("ele1", "小樱");  
		map.put("ele2", "若曦");  
		map.put("ele3", "晴川");  
		Set<String> set = map.keySet();  
		  
		//Set转List,方法一 ： ArrayList(Collection<?> c)   
		List<String> list1 = new ArrayList<String>(set);  
		for(int i = 0; i < list1.size(); i++){  
		    System.out.println("list1(" + i + ") --> " + list1.get(i));  
		}  
		  
		//Set转List,方法二：List实现类（ArrayList/LinkedList）的方法  -- addAll(Collection<?> c)   
		List<String> list2 = new ArrayList<String> ();  
		list2.addAll(set);  
		for(String elem : list2){  
		    System.out.println(elem);  
		}  
	}
}
