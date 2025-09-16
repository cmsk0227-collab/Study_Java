package com.dijkstra;

public class Main {
	static class Node implements Comparable<Node>{
		int index;//인접한 정점번호
		int cost;// 가중치
		
		//정점번호, 가중치 저장
		 public Node(int index, int cost) {
			 this.index = index;
			 this.cost = cost;
		 }
		 
		//cost(=가중치)  중심으로 우선순위가 정해지기 때문에 compareTo 오버라이딩
		 @Override
		 public int compareTo(Node o) {
			 return Integer.compare(this.cost, o.cost);
		 }
		 
	}

}
