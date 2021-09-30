package board;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.BoardVO;

public class BoardDAO implements BoardService{
	private static SqlSessionFactory sqlmapper;//연결 객체 |conn
	private static SqlSession sql; //전송과 결과를 담당하는 객체 |ps , rs
	static {
		String resource = "data/SqlMapConfig.xml";//Mybatis 설정이 있는 파일
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlmapper = new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("마이바티스 SqlSessionFactory 여기 에러");
		}
	}
	
	@Override
	public List<BoardVO> board_list() {
		sql = sqlmapper.openSession();
		List<BoardVO> list = sql.selectList("board.mapper.list");
		return list;
	}

	@Override
	public BoardPage board_list(BoardPage page) {
		sql= sqlmapper.openSession();
		page.setTotalList(sql.selectOne("board.mapper.totalList", page));
		page.setList(sql.selectList("board.mapper.list", page));
		return page;
	}

	@Override
	public BoardVO board_view(int id) {
		sql = sqlmapper.openSession();
		return sql.selectOne("board.mapper.select", id);
		
	}

	@Override
	public void board_insert(BoardVO vo) {
		sql=sqlmapper.openSession();
		sql.insert("board.mapper.insert", vo);
		sql.commit();
		
	}

	@Override
	public void board_update(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void board_dalete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borad_read(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardVO> board_list(HashMap<String, String> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void board_reply_insert(BoardVO vo) {
		// TODO Auto-generated method stub
		
	}

}
