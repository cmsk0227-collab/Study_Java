package com.ssafy.set;

import java.util.HashSet;

public class Set01_HashSet {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		
		//추가
		set.add("A");
		set.add("C");
		set.add(null);
		set.add("B");
		set.add("B");
		set.add(null);
		set.add("안태리");
		set.add("최지원");
		set.add("최지원");
		
		System.out.println(set);
		
		System.out.println(set.contains("A"));
		set.remove("A");
		
		System.out.println("------------------------------");
		
		for(String s: set) {
			System.out.println(s);
		}
		
		System.out.println(set.size());
	}

}
