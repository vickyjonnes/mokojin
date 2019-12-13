package edu.problem.general;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class LFUCacheDemo {

	public static void main(String[] args) {
		LFUCache<String, String> map=new LFUCache(3);
		map.put("fa", "faizan");
		map.put("f", "fazil");
		map.put("fi", "faiz");
		System.out.println(map.size());
		map.put("fy", "firoz");
		System.out.println(map.size());
		map.entrySet().stream().map(e->e.getValue()).forEach(System.out::print);
		map.get("f");
		System.out.println();
		map.entrySet().stream().map(e->e.getValue()).forEach(System.out::print);
		
	}

}




class LFUCache<K,V>{

	private class CacheValue<V>{
		private int freq;
		private V data;
		private CacheValue(V data) {
			this.data=data;
			freq=1;
		}
		
		public V getData() {
			return this.data;
		}
		
		public int getFreq() {
			return this.freq;
		}
		
		public void freqUp() {
			this.freq=this.freq+1;
		}
	}
	
	private int capacity;
	private LinkedHashMap<K, CacheValue<V>> cache;
	
	public LFUCache(int capacity) {
		this.capacity=capacity;
		cache=new LinkedHashMap<>(capacity,0.75f,true);
	}
	
	public void put(K k, V v) {
		if(!isFull()) {
			CacheValue<V> value=new CacheValue<>(v);
			cache.put(k, value);
		}else {
			K key=getLFUKey();
			cache.remove(key);
			CacheValue<V> value=new CacheValue<>(v);
			cache.put(k, value);
		}
	}
	
	public V get(K k) {
		CacheValue<V> value=cache.get(k);
		value.freqUp();
		System.out.println(value.getFreq());
		return value.getData();
	}
	
	private K getLFUKey() {
		int min=Integer.MAX_VALUE;
		K key=null;
		for(java.util.Map.Entry<K, CacheValue<V>> c: cache.entrySet()) {
			if(min>c.getValue().getFreq()) {
				min=c.getValue().getFreq();
				key=c.getKey();
			}
		}
		return key;
	}
	
	private boolean isFull() {
		return cache.size()>=capacity;
	}
	
	public int size() {
		return cache.size();
	}
	
	public Set<V> valueSet(){
		return cache.values().stream()
				.sorted((a,b)->Integer.compare(a.getFreq(), b.getFreq()))
				.map(t->t.getData()).collect(Collectors.toSet());
	}
	
	public Set<K> keySet(){
		return cache.keySet();
	}
	
	public Set<java.util.Map.Entry<K,V>> entrySet(){
		return cache.entrySet().stream().sorted((a,b)->Integer.compare(a.getValue().getFreq(), b.getValue().getFreq()))
				.map(e->new java.util.Map.Entry<K, V>() {

			@Override
			public K getKey() {
				return e.getKey();
			}

			@Override
			public V getValue() {
				return e.getValue().getData();
			}

			@Override
			public V setValue(V arg0) {
				return null;
			}
		}).collect(Collectors.toSet());
	}
	
	
}
