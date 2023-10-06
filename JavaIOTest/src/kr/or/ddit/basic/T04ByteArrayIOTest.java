package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T04ByteArrayIOTest {
	public static void main(String[] args) throws IOException {
		
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[4]; //buffer 역할을 할 4바이트 공간을 가진 배열
		
		//stream클래스를 이용하는 방법
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	
		int readBytes = 0;
		
		// read() 메서드 => byte단위로 데이터를 읽어와 int 형으로 반환한다.
		// 				  더 이상 읽을 데이터가 없으면 -1을 반환한다.
		
		while((readBytes = bais.read(temp)) != -1) { //4바이트 공간을 가진 buffer을 이용함으로써 4바이트씩 읽음
			//readBytes에는 read 메서드가 실행되어 읽어온 데이터 개수를 반환해줌
			System.out.println(readBytes);
			baos.write(temp, 0, readBytes);
			System.out.println("temp => " + Arrays.toString(temp));
		}
		// 출력된 스트림 데이터를 배열로 변환해서 반환하는 메서드
		outSrc = baos.toByteArray();
		
		System.out.println("inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
		
		
	}
}
