package member;

import java.util.HashMap;

public interface MemberService {
	boolean member_join(MemberVO vo);//회원가입시 회원정보를 저장(insert)
	MemberVO member_login(HashMap<String, String> map);//회원 로그인 처리(select)
	boolean member_update(MemberVO vo);//회원정보의 번경(update)
	boolean member_delete(String id);//회원 탈퇴(delete)
	boolean member_id_check(String id);//회원가입 시 중복된 아이디의 회원 가입을 막음
									//select coumt(*) from jsp_member where id=?로 0건이면 회원가입 가능
	MemberVO member_select(String id); //회원정보 상세보기 : 마이페이지(보류)
}
