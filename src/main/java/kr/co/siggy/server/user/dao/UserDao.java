package kr.co.siggy.server.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.siggy.server.common.BaseDao;

@Repository
public class UserDao extends BaseDao{
	
	private String nameSpace = "User";

	public List<Map<String, Object>> getUserList() {
		return sqlSession.selectList(nameSpace + ".getUserList");
	}


	public List<Map<String, Object>> getFoodBookmarkList(Map<String, Object> req) {
		return sqlSession.selectList(nameSpace + ".getFoodBookmarkList", req);
	}
	
	public List<Map<String, Object>> getPlaceBookmarkList(Map<String, Object> req) {
		return sqlSession.selectList(nameSpace + ".getPlaceBookmarkList", req);
	}
	
	public void insertLike(Map<String, Object> req) {
		sqlSession.insert(nameSpace + ".insertLike", req);
	}

	public void deleteLike(Map<String, Object> req) {
		sqlSession.insert(nameSpace + ".deleteLike", req);
	}


}
