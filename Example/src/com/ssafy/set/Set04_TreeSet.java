package com.ssafy.set;

import java.util.Arrays;
import java.util.TreeSet;

public class Set04_TreeSet {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		//이진탐색트리(BST)
		set.add(10);
		set.add(20);
		set.add(150);
		set.add(50);
		set.add(25);
		set.add(10);
		set.add(30);
		
		System.out.println(set);//정렬된 채로 출력
		System.out.println(set.first());
		System.out.println(set.last());
		
		//근접 탐색
		System.out.println(set.lower(30));//30 미만이면서 가장 작은 값
		System.out.println(set.floor(30));//30 이하이면서 가장 작은 값
		System.out.println(set.ceiling(30));//30 이상이면서 가장 작은 값
		System.out.println(set.higher(30));//30포함 초과이면서 가장 작은 값
		
		System.out.println(set.descendingSet());//거꾸로 출력, set임
		System.out.println(Arrays.toString(set.toArray()));//배열임. set -> array
	}
		

}
