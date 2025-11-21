package kr.co.siggy.server.login.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.siggy.server.common.BaseDao;

@Repository
public class LoginDao extends BaseDao{
	
	private String nameSpace = "Login";

	public List<Map<String, Object>> getLoginList() {
		return sqlSession.selectList(nameSpace + ".getLoginList");
	}

}
