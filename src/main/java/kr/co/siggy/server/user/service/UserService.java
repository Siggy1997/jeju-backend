package kr.co.siggy.server.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.siggy.server.common.BaseController;
import kr.co.siggy.server.login.dao.LoginDao;
import kr.co.siggy.server.user.dao.UserDao;

@Service
public class UserService extends BaseController{

	@Autowired
	private UserDao userDao;
	
	public List<Map<String, Object>> getUserList() {
		List<Map<String, Object>> userList = userDao.getUserList();
		
		return userList;
	}

	public Map<String, Object> getBookmarkList(Map<String, Object> req) {
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> foodBookmark = userDao.getFoodBookmarkList(req);
		List<Map<String, Object>> placeBookmark = userDao.getPlaceBookmarkList(req);
		
		result.put("foodBookmark", foodBookmark);
		result.put("placeBookmark", placeBookmark);
		
		return result;
	}
	
	public void toggleLike(Map<String, Object> req) {
		Boolean isFav = (Boolean) req.get("isFav");
		if (isFav) {
			userDao.deleteLike(req);
		} else {
			userDao.insertLike(req);
		}
	}

	
	
}
