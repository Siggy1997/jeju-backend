package kr.co.siggy.server.food.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.siggy.server.common.BaseController;
import kr.co.siggy.server.food.service.FoodService;

@RestController
@RequestMapping(value = "/api")
public class FoodController extends BaseController {

	@Autowired
	private FoodService foodService;

	@PostMapping(value = "/food/list")
	public Map<String, Object> foodList(@RequestBody Map<String, Object> req) {
		Map<String, Object> resData = new HashMap<>();
		
		List<Map<String, Object>> foodList = foodService.getFoodList(req);
		logger.info("### foodList : {}", foodList);

		List<Integer> likeSeqList = foodService.getFoodLikeSeqList(req);
		logger.info("### likeSeqList : {}", likeSeqList);

		resData.put("foodList", foodList);
		resData.put("likeSeqList", likeSeqList);

		return resData;
	}
	@PostMapping(value = "/place/list")
	public Map<String, Object> placeList(@RequestBody Map<String, Object> req) {
		Map<String, Object> resData = new HashMap<>();
		
		List<Map<String, Object>> placeList = foodService.getPlaceList(req);
		logger.info("### placeList : {}", placeList);
		
		List<Integer> likeSeqList = foodService.getPlaceLikeSeqList(req);
		logger.info("### likeSeqList : {}", likeSeqList);
		
		resData.put("placeList", placeList);
		resData.put("likeSeqList", likeSeqList);
		
		return resData;
	}
	
}
