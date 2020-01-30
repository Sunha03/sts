package dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//DAO의 메소드를 호출하는 함수
@Service("deptService")
public class DeptServiceImpl {
	@Autowired
	deptDAOImpl dao;
	public int count() {
		return dao.count();
	}
	
	public int insert(String deptno, String deptname) {
		return dao.insert(deptno, deptname);
	}
	
	public int update(String deptno, String deptname) {
		return dao.update(deptname, deptno);
	}
	
	public List<DeptDTO> selectAll() {
		return dao.selectAll();
	}
}
