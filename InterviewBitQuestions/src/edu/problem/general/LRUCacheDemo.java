package edu.problem.general;

import java.util.LinkedHashMap;

public class LRUCacheDemo {

	public static void main(String[] args) {
		LRUCache<String, String> cache=new LRUCache<String, String>(5);
		cache.put("fa", "faizan");
		cache.put("f", "fazil");
		cache.put("v", "varun");
		cache.put("u", "uday");
		cache.put("a", "anam");
		System.out.println(cache.size());
		cache.put("r", "rahul");
		System.out.println(cache.size());
		cache.entrySet().stream().forEach(a->System.out.print(a.getValue()+" "));
		cache.get("a");
		System.out.println();
		cache.entrySet().stream().forEach(a->System.out.print(a.getValue()+" "));
	}

}

class LRUCache<K,V> extends LinkedHashMap<K, V>{
	
	private static final long serialVersionUID = 1L;
	private int capacity;
	
	public LRUCache(int capacity) {
		super(capacity,0.75f,true);
		this.capacity=capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> entry) {
		return size()>this.capacity;
	}
}
