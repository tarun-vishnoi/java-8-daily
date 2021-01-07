package com.streamArchives;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HahMap2TreeMap {

	public static void main(String[] args) {

		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("A", "Alex");
		hashMap.put("D", "Dany");
		hashMap.put("B", "Bob");
		hashMap.put("C", "Chad");

		System.out.println(hashMap);

		Map<String, String> treeMap = hashMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
				Map.Entry::getValue, (oldValue, newValue) -> newValue, TreeMap::new));

		System.out.println(treeMap);

		Map<String, String> treeMap2 = new TreeMap<String, String>();
		treeMap2.putAll(hashMap);

		System.out.println(treeMap2);

	}

}
