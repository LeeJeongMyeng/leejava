package a11_collection;

import java.util.HashSet;
import java.util.Set;

public class A02_Set {

	public static void main(String[] args) {
		/*
		 # Set컬렉션
		 	1. 특징
		 		수학의 집합에 비유
		 		저장 순서가 유지되지 않음
		 		객체를 중복 저장 불가
		 		하나의 null만 저장 가능
		 	2. 구현클래스
		 		HashSet, LinkedHashSet, TreeSet
		 	3. 주요 메서드
		 		.add()
		 		.contains()
		 		.isEmpty()
		 		Interator<E> inerator()
		 		.size()
		 		.clear()
		 		.remove(Object ob)
		 		
		 		#전체 객체 대상으로 한번씩 반복해서 가져오는 반복자
		 		반복자(Iterator)제고
		 		- 인덱스로 객체를 검색해서 가져오는 메소드 없음
		 	4. HashSet
		 		1) Set<E> set = new HashSet<E>();
		 		2) 특징
		 			동일 객체 및 동등 객체는 중복 저장하지 않음
		 			동등 객체 판단 hashCode ==> equals
		 */
		Set<String> set = new HashSet<String>();
		set.add("사과");
		set.add("수박");
		set.add("사과");
		set.add("바나나");
		set.add("딸기");
		set.add("딸기");
		set.add("망고");
		set.add("딸기");
		set.remove("사과");
		System.out.println("#저장된 set#");
		for(String fruit:set) {
			System.out.println(fruit);
		}
		
		//ex)주머니 속 구슬 빨강2 파랑3 노랑2개 Set할당 for문을 통해 출려갷서 
		//들어가있는 모든 구슬의 갯수 출력
		Set<String> Colorball = new HashSet<String>();
		Colorball.add("빨");
		Colorball.add("빨");
		Colorball.add("파");
		Colorball.add("파");
		Colorball.add("파");
		Colorball.add("노");
		Colorball.add("노");
		for(String getball:Colorball) {
			System.out.println(getball);
		}
		System.out.println(Colorball.size());
	}

}
