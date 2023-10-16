package ko.or.ddit.basic;

public class MySingleton {
	/*
	 싱글턴 패턴이란 ? 객체(인스턴스)를 한 개만 만들어지게 하는 프로그래밍 방법
	 
	 - Singleton Class를 구성하는 방법
	   1. 자기 자신 class의 참조변수를 멤버변수로 선언한다.
	  	(이 변수는 private static으로 지정한다.)
	   2. 생성자를 private으로 한다.
	   	(외부에서 생성자에 접근을 못하게 하기 위해서, 즉 외부에서 new 명령을 사용하지 못하도록 제한한다.)
	   3. 객체(인스턴스)는 내부에서 생성해서 이 생성된 객체를 반환하는 메서드를 만든다.
	   	(이 메서드는 static으로 선언하고 이름은 보통 getInstance()로 지정한다.)
	 */
	//자기 자신의 타입 객체를 참조하기 위한 멤버변수 선언
	private static MySingleton single;
	
	//생성자를 private으로 지정한다.
	private MySingleton() {
		System.out.println("생성자가 호출되었습니다.");
	}
	//객체가 만들어지지 않은 경우에만 생성하고 객체가 이미 있는 경우엔  만들어진 객체를 리턴하는 메서드
	//외부에선 객체 생성을 못하므로 싱글턴 클래스에서 객체를 생성해야함. 외부에서는 접근만 가능
	public static MySingleton getInstance() {
		if(single == null) {
			single = new MySingleton();
		}
		return single;
	}
	
	public void diplayText() {
		System.out.println("안녕하세요 싱글턴 객체입니다.");
	}
	
}
