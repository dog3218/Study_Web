package customer;

import java.util.List;

public interface CustomerService {
	//CRUD (create, read, update, delete)
	void customer_insert(CustomerVO vo);//create insert 신규 고객 정보 추가
	List<CustomerVO> customer_list(); // read select 고객 목록 조회
	CustomerVO customer_detail(int id);// Read select된 고객 목록 중에 선택된 정보를 상세보기
	void customer_update(CustomerVO vo); //update 고객정보 수정 저장
	void customer_delete(int id); //Delete고객정보 삭제
	
	//임시테시트용 메소드
	int customer_test();
}
