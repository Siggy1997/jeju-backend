package kr.co.siggy.server.food.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.siggy.server.common.BaseDao;

@Repository
public class FoodDao extends BaseDao{

	private String nameSpace = "Food";


	public List<Map<String, Object>> getFoodList(Map<String, Object> req) {
		return sqlSession.selectList(nameSpace + ".getFoodList", req);
	}


	public List<Integer> getFoodLikeSeqList(Map<String, Object> req) {
		return sqlSession.selectList(nameSpace + ".getFoodLikeSeqList", req);
	} 
	
	public List<Map<String, Object>> getPlaceList(Map<String, Object> req) {
		return sqlSession.selectList(nameSpace + ".getPlaceList", req);
	}
	
	
	public List<Integer> getPlaceLikeSeqList(Map<String, Object> req) {
		return sqlSession.selectList(nameSpace + ".getPlaceLikeSeqList", req);
	} 

}
