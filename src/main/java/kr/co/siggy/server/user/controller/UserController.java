package kr.co.siggy.server.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.siggy.server.common.BaseController;
import kr.co.siggy.server.user.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/list")
	public Map<String, Object> userList(){
		Map<String, Object> resData = new HashMap<>();
		List<Map<String, Object>> userList = userService.getUserList();
		
		logger.info("### USER LIST : {}", userList);
		resData.put("result", userList); 
		return resData;
	}
	
	@PostMapping(value = "/bookmark")
	public Map<String, Object> getUserBookmark(@RequestBody Map<String, Object> req){
		logger.info(req.toString());
		Map<String, Object> resData = new HashMap<>();

		Map<String, Object> result =  userService.getBookmarkList(req);
		resData.putAll(result);
		logger.info(resData.toString());
		return resData;
	}
	
	@PostMapping(value = "/toggleLike")
	public Map<String, Object> insertLikeFood(@RequestBody Map<String, Object> req){
		logger.info(req.toString());
		Map<String, Object> resData = new HashMap<>();
		userService.toggleLike(req);
		
		return resData;
	}
}
