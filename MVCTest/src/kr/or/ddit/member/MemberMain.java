package kr.or.ddit.member;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.member.VO.MemberVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

/*
	회원정보를 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력	---> select
		5. 작업 끝.
	----------------------
	 
	   
// 회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128),    -- 주소
    reg_dt DATE DEFAULT sysdate, -- 등록일
    CONSTRAINT MYMEMBER_PK PRIMARY KEY (mem_id)
);

*/
public class MemberMain {
	private IMemberService memService;
	
	private Scanner scan;

	/**
	 * 메뉴를 출력하는 메서드
	 */
	
	public static void main(String[] args) {
		MemberMain memObj = new MemberMain();
		memObj.start();
	}
	
	public MemberMain() {
		memService = new MemberServiceImpl();
		
		scan = new Scanner(System.in);
	}
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  0. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice = 100;
		
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertMember();
				break;
			case 2: // 자료 삭제
				deleteMember();
				break;
			case 3: // 자료 수정
				updateMember();
				break;
			case 4: // 전체 자료 출력
				diplayAllMember();
				break;
			case 5: // 자료 검색 기능
				searchMember();
				break;
			case 0: // 작업 끝
				System.out.println("작업을 마칩니다.");
				System.exit(0);
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 0);
	}



	private void insertMember() {
		// 회원정보를 추가하기 위한 메서드
		boolean isExist = false;
		
		String memId = "";
		
		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			memId = scan.next();
			
			isExist = memService.checkMember(memId);
			
			if(isExist) {
				System.out.println(memId + "는 이미 존재하는 ID입니다.\n다시 입력해주세요." );
			}
			
		} while (isExist);
			
			System.out.print("회원 이름 >> ");
			String memName = scan.next();
			;
			
			System.out.print("회원 전화번호 >> ");
			String memTel = scan.next();
			
			scan.nextLine(); // 입력 버퍼 비우기
			
			System.out.print("회원 주소 >> ");
			String memAddr = scan.nextLine();
			
			MemberVO mv = new MemberVO(memId, memName, memTel, memAddr);
			
			int cnt = memService.registerMember(mv);
			
			if(cnt > 0) {
				System.out.println(memId + "님 회원가입 되었습니다.");
			}else {					
				System.out.println(memId + "님 회원가입 실패!!");
			}
	}
	/**
	 * 회원정보를 수정하기 위한 메서드
	 */
	private void updateMember() {
		
		boolean isExist = false;
		
		String memId = "";
		
		do {
			System.out.println();
			System.out.println("수정할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			memId = scan.next();
			
			isExist = memService.checkMember(memId);
			
			if(!isExist) {
				System.out.println(memId + "는 없는 ID입니다.\n다시 입력해주세요." );
			}
			
		} while (!isExist);
			
			System.out.print("회원 이름 >> ");
			String memName = scan.next();
			;
			
			System.out.print("회원 전화번호 >> ");
			String memTel = scan.next();
			
			scan.nextLine(); // 입력 버퍼 비우기
			
			System.out.print("회원 주소 >> ");
			String memAddr = scan.nextLine();
			
			MemberVO mv = new MemberVO(memId, memName, memTel, memAddr);
			
			int cnt = memService.modifyMember(mv);
			
			if(cnt > 0) {
				System.out.println(memId + "님 정보가 수정되었습니다.");
			}else {					
				System.out.println(memId + "님 정보 수정 실패!!");
			}
		
	}
		
	private void deleteMember() {
	
		boolean isExist = false;
		
		String memId = "";
		do {
			
			System.out.println();
			System.out.println("삭제할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			memId = scan.next();
			
			isExist = memService.checkMember(memId);
			
			if(!isExist) {
				System.out.println(memId + "는 없는 ID입니다.\n다시 입력해주세요." );
			}
			
		}while(!isExist);
			
			int cnt = memService.removeMember(memId);
			
			if(cnt > 0) {
				System.out.println("탈퇴되었습니다.");
			}else {					
				System.out.println(memId + "님 탈퇴 실패!!");
			}
		
	}

	/**
	 * 모든 회원정보 출력을 위한 메서드
	 */
	private void diplayAllMember() {
		System.out.println("\n----------------------------------------------------");
		System.out.println("  ID\t이름\t전화번호\t\t주소");
		System.out.println("----------------------------------------------------");
		
		List<MemberVO> memList = memService.displayAllMember();
		
		for(MemberVO mv : memList) {
			System.out.println(" " + mv.getMemId() + "\t" + mv.getMemName() + "\t" + mv.getMemTel()
							 + "\t" + mv.getMemAddr());
		}
		
		System.out.println("----------------------------------------------------");
	
		System.out.println("출력 완료");
	
	}
	
	/**
	 * 회원정보 검색을 위한 메서드
	 */
	
	private void searchMember() {
	/*
	 검색할 회원 id, 회원 이름, 전화번호, 주소 등을 입력하면 입력한 정보만 사용하여 검색하는 기능을 구현하시오.	
	
	주소는 입력한 값이 포함만 되어도 검색되도록 한다.
	
	입력을 하지 않을 데이터는 엔터키로 다음 입력으로 넘긴다.
	
	 */
	
		
		
	}
}
