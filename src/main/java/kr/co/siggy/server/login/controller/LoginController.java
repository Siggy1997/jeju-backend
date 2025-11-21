package kr.co.siggy.server.login.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.siggy.server.common.BaseController;
import kr.co.siggy.server.login.service.LoginService;

@RestController
@RequestMapping(value = "/api/login")
public class LoginController extends BaseController{
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping(value = "/list")
	public Map<String, Object> loginList(){
		Map<String, Object> resData = new HashMap<>();
		List<Map<String, Object>> loginList = loginService.getLoginList();
		
		logger.info("### LOGIN LIST : {}", loginList);
		resData.put("result", loginList);
		return resData;
	}
}
