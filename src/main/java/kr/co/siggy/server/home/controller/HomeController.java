package kr.co.siggy.server.home.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.siggy.server.common.BaseController;

@RestController
public class HomeController extends BaseController{

	@GetMapping(value = "/", name = "홈")
	public String index() {
		logger.info("###INDEX");
		
		return "HELLO";
	}
	@PostMapping("/login/list")
	public Map<String, Object> boardList() {
		Map<String, Object> resData = new HashMap<>();
		resData.put("result", "hello");
		logger.info("map list");
		
		return resData;
	}
}
