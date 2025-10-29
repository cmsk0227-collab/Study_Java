import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//기능을 사용하기 위해서 import
//ctr+shif+ o -> 자동임포트

public class List01_Arraylist{
public static void main(String[] args) {
//	list : 순서 o 중복 o
	
//	ArrayList<String> names = new ArrayList<String>();
//	ArrayList<String> names = new ArrayList<>();
	List<String> names = new LinkedList<>();
	
	//원소추가
	names.add("유승준");
	names.add("윤정아");
	names.add("윤정아");
//	names.add(100, "kim"); 불가능. 인덱스 길이 초과.
	names.add(2, "kim"); //가능
	
	for(String name : names) {
		System.out.println(name);
	}
	
	System.out.println("---------------");
	
	for(int i = 0; i < names.size() ; i++) {
		System.out.println(names.get(i));
	}
		
	System.out.println(names);
	
	//전체를 비우는 방법 
	//1. 인스턴스를 새로 만든다
	//2. 전체를 반복 돌면서 하나씩 제거하기
	//3. clear()

	names.set(1, "양명균");
	
	System.out.println(names.contains("양명균"));
	System.out.println(names.indexOf("양명균"));
	
//	names.remove(1);
	names.remove("윤정아");
	System.out.println(names);
	
	
	names.clear();
	System.out.println(names.isEmpty());
}
}

