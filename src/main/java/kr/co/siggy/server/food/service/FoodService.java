package kr.co.siggy.server.food.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.siggy.server.common.BaseController;
import kr.co.siggy.server.food.dao.FoodDao;

@Service
public class FoodService extends BaseController{
	
	@Autowired
	private FoodDao foodDao;
	
	public List<Map<String, Object>> getFoodList(Map<String, Object> req) {
		List<Map<String, Object>> foodList = foodDao.getFoodList(req);
		
		return foodList;
	}

	public List<Integer> getFoodLikeSeqList(Map<String, Object> req) {
		List<Integer> likeSeqList = foodDao.getFoodLikeSeqList(req);

		return likeSeqList;
	}

	public List<Map<String, Object>> getPlaceList(Map<String, Object> req) {
		List<Map<String, Object>> placeList = foodDao.getPlaceList(req);
		
		return placeList;
	}
	
	public List<Integer> getPlaceLikeSeqList(Map<String, Object> req) {
		List<Integer> likeSeqList = foodDao.getPlaceLikeSeqList(req);
		
		return likeSeqList;
	}
	
}
