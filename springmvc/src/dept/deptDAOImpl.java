package dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//사용자 정의 DAO 클래스
@Repository
public class deptDAOImpl {
	@Autowired
	JdbcTemplate mytemplate;
	
	public int count() {
		return mytemplate.queryForObject("select count(*) from dept", Integer.class);
	}
	
	public int insert(String deptno, String deptname) {
		String sql = "INSERT INTO dept (deptno, deptname) VALUES(?, ?)";
		int result = mytemplate.update(sql, deptno, deptname);
		
		return result;
	}
	
	public int update(String deptno, String deptname) {
		String sql = "UPDATE dept SET deptname=? WHERE deptno=?";
		int result = mytemplate.update(sql, deptname, deptno);
		
		return result;
	}
	
	public List<DeptDTO> selectAll() {
		return mytemplate.query("SELECT deptno, deptname FROM dept", new MyDeptRowMapper());
	}
}
