package member;

import java.util.HashMap;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao = new MemberDAO();
	
	@Override
	public boolean member_delete(String id) {
		
		return dao.member_delete(id);
	}
	
	@Override
	public boolean member_id_check(String id) {
		// TODO Auto-generated method stub
		return dao.member_id_check(id);
	}
	
	@Override
	public boolean member_join(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.member_join(vo);
	}
	
	@Override
	public MemberVO member_login(HashMap<String, String> map) {
		
		return dao.member_login(map);
	}
	
	@Override
	public boolean member_update(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.member_update(vo);
	}
	
	@Override
	public MemberVO member_select(String id) {
		
		return dao.member_select(id);
	}
	
}
