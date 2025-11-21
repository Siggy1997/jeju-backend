package kr.co.siggy.server.login.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.siggy.server.common.BaseController;
import kr.co.siggy.server.login.dao.LoginDao;

@Service
public class LoginService extends BaseController{

	@Autowired
	private LoginDao loginDao;
	
	public List<Map<String, Object>> getLoginList() {
		List<Map<String, Object>> loginList = loginDao.getLoginList();
		
		return loginList;
	}
	
	
}
