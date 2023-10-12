package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.VO.MemberVO;

/**
 * 실제 DB에 연결해서 SQL문을 수행하여 결과를 처리하는 DAO 인터페이스
 * @author PC-2
 *
 */
public interface IMemberService {
	
	/**
	 * 회원정보를 등록하기 위한 메서드
	 * @param mv 등록할 데이터를 담은 MemberVO객체
	 * @return 작업이 성공하면 1 이상의 값이 반환되고  실패하면 0을 반환한다.
	 */
	public int registerMember(MemberVO mv);
	
	/**
	 * 해당 회원이 존재하는지 체크하기 위한 메서드
	 * @param memId 존재 여부를 체크할 회원 ID
	 * @return 해당 회원이 존재하면 true, 존재하지 않으면 false를 반환한다.
	 */
	public boolean checkMember(String memId);
	
	/**
	 * MemberVO에 담겨진 데이터를 update하기 위한 메서드
	 * @param mv 수정할 데이터를 담은 MemberVO객체
	 * @return DB작업이 성공하면 1 이 반환되고  실패하면 0을 반환한다.
	 */
	public int modifyMember(MemberVO mv);

	/**
     * 회원정보를 삭제하기 위한 메서드	
	 * @param memId 회원정보를 삭제할 회원 ID
	 * @return DB작업이 성공하면 1 이 반환되고  실패하면 0을 반환한다.
	 */
	public int removeMember(String memId);
	
	/**
	 * 모든 회원정보를 가져오기 위한 메서드
	 * @return 회원정보를 담은 List 객체를 반환한다.
	 */
	public List<MemberVO> displayAllMember();
	
}
