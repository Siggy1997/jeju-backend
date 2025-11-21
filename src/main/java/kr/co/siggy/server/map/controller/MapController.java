package kr.co.siggy.server.map.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.siggy.server.common.BaseController;
import kr.co.siggy.server.map.service.MapService;

@RestController
@RequestMapping(value = "/api/map")
public class MapController extends BaseController{
	
	@Autowired
	private MapService mapService;
	
	@PostMapping(value = "/list")
	public Map<String, Object> loginList(){
		Map<String, Object> resData = new HashMap<>();
		
		List<Map<String, Object>> mapList = mapService.getMapList();
		logger.info("### MAPLIST : {}", mapList);
		resData.put("result", mapList);
		return resData;
	}
}
