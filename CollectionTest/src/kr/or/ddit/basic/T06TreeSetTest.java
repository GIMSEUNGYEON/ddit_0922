package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class T06TreeSetTest {
	public static void main(String[] args) {

		// TreeSet은 자동정렬 기능이 들어가 있다.
		TreeSet<String> ts = new TreeSet<String>();
		List<String> abcList = new ArrayList<String>();

		// 영어 대문자를 문자열로 반환하여 List에 저장하기
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			String temp = String.valueOf(ch);
			abcList.add(temp);
		}
		Collections.shuffle(abcList);

		// 섞은 후의 list 데이터
		System.out.println("abcList 데이터 : " + abcList);

		for (String str : abcList)
			ts.add(str);

		System.out.println("TreeSet 데이터 : " + ts);
		System.out.println();

		// TreeSet에 저장된 데이터 중 특정한 데이터보다 작은 데이터를 찾아서 SortedSet으로
		// 반환하는 메서드가 있다.
		// headSet(기준값) => 기본적으로 기준값은 포함시키지 않는다.
		// headSet(기준값, 논리값) => 논리값이 true면 기준값을 포함시킨다.
		SortedSet<String> ss1 = ts.headSet("K");
		System.out.println("K 이전 데이터 : " + ss1);
		System.out.println("K 이전 데이터(K 포함) : " + ts.headSet("K", true));
		// '기준값'보다 큰 데이터를 찾아 .SortedSet으로 반환하는 메서드 
		// tailSet(기준값) => 기본적으로 '기준값'을 포함시킨다.
		// tailSet(기준값, 논리값) => 논리값이 false이면 기준값을 포함시키지 않는다.
		
		SortedSet<String> ss2 = ts.tailSet("K");
		System.out.println("K 이후 데이터 : " + ss2);
		System.out.println("K 이후 데이터(K 미포함) : " + ts.tailSet("K", false));
		
		//subSet(기준값1, 기준값2) => 기준값1 ~ 기준값2 사이의 값을 가져온다. 1 포함, 2 미포함
		//subSet(기준값1, 논리값1, 기준값2, 논리값2) => 각 기준값 포함 여부를 결정한다.
		System.out.println("K(포함) ~ N(미포함) : " + ts.subSet("K", "N"));
		System.out.println("K(포함) ~ N(포함) : " + ts.subSet("K", true, "N", true));
		System.out.println("K(미포함) ~ N(미포함) : " + ts.subSet("K", false, "N", false));
		System.out.println("K(미포함) ~ N(포함) : " + ts.subSet("K", false, "N", true));
		
	}
}
