package DAO;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BookVO;
import dto.MemberVo;

public class MybatisDAO {
	//기존의 JDBC lib Connection(연결객체)를 먼저 만들었지만
	//Mybatis의 경우에는 SqlSessionFactory를 이용해서 session을 오픈해서사용한다.
	//Connection conn = SqlSessionFactory sqlMapper;
	private static SqlSessionFactory sqlMapper;
	static {
		String resource = "data/SqlMapConfig.xml";//user, url, driver => resource
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
			//SqlMapper(SqlSessionFactory 초기화)
		} catch (Exception e) {
			// TODO: handle exception
		}
	}//static(초기화블럭)
	
	public void selectOne() {
		//SqlSessionFactory를 이용하여 SEssion이라는 객체를 Open시키고 Session객체를 이용하여
		//sql문을 실행한다(실행할 sql문은 mapper에 정의되있어야 한다.)
		SqlSession session = sqlMapper.openSession();
		//nameSpace + id
		int result = session.selectOne("test.selectone");
		String param="감사합니다";
		session.selectOne("test.selectone2", param);
		System.out.println("result : " + result);
		System.out.println("param : " + param);
		
		HashMap<String, String> dto = new HashMap<>();
		dto.put("a", "aaabb");
		dto.put("b","bbbcc");
		dto.put("c", "cccdd");
		
		String sql = session.selectOne("test.selectone3", dto);
		System.out.println(sql);
	}
		public void selectList() {
			//전송 /결과 객체             //연결객체
			SqlSession session = sqlMapper.openSession();
			List<BookVO> list =session.selectList("test.selectlist");
			for(BookVO bookVo : list) {
				System.out.print(bookVo.getNAME()+", ");
				System.out.print(bookVo.getTITLE()+", ");
				System.out.print(bookVo.getISBN()+", ");
				System.out.print(bookVo.getCOMPANY()+", ");
				System.out.print(bookVo.getCOST()+", ");
				System.out.print(bookVo.getQTY()+", ");
				System.out.println(bookVo.getPRICE()+"\n");
			}
			
		}
		public void selectMember() {
			SqlSession session = sqlMapper.openSession();
			List<MemberVo> list = session.selectList("test.selectmember");
			for(MemberVo memberVo : list) {
				System.out.println(memberVo.getNAME()+", ");
				System.out.println(memberVo.getID()+", ");
				System.out.println(memberVo.getPW()+", ");
				System.out.println(memberVo.getAGE()+", ");
				System.out.println(memberVo.getADDR()+", ");
				System.out.println(memberVo.getTEL()+"\n");
			}
			
		}
		
		
		
}
