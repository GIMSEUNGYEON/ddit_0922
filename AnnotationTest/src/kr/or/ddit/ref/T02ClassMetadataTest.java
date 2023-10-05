package kr.or.ddit.ref;

import java.lang.reflect.Modifier;

public class T02ClassMetadataTest {
	public static void main(String[] args) {
		//클래스 오브젝트 생성하기
		Class<?> clazz = SampleVO.class;
		
		System.out.println("심플클래스명 : " + clazz.getSimpleName()); //클래스 생성할 때 지정한 이름
		System.out.println("클래스명 : " + clazz.getName());		   //패키지 이름까지 포함된 이름
		System.out.println("상위클래스명 : " + clazz.getSuperclass().getName()); //상위클래스 이름(object)
		
		//패키지 정보 가져오기
		Package pkg = clazz.getPackage();
		System.out.println("패키지 정보 : " + pkg.getName());
		System.out.println("패키지 정보 : " + clazz.getPackage().getName());
		
		//해당 클래스에서 구현하고 있는 인터페이스 목록 가져오기
		Class<?>[] interfaces = clazz.getInterfaces(); //implements한 인터페이스
		
		System.out.println("인터페이스 목록 >> ");
		
		for(Class<?> inf : interfaces) {
			System.out.println(inf.getName() + " | ");
		}
		System.out.println();
		
		//클래스의 접근제어자 정보 가져오기
		int modFlag = clazz.getModifiers();
		System.out.println("접근제어자 : " + Modifier.toString(modFlag));
		System.out.println("접근제어자 : " + Modifier.toString(clazz.getModifiers()));
		
	}
}
