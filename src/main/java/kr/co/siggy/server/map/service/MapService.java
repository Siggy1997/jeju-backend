package kr.co.siggy.server.map.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.siggy.server.common.BaseController;
import kr.co.siggy.server.map.dao.MapDao;

@Service
public class MapService extends BaseController{
	
	@Autowired
	private MapDao mapDao;
	
	public List<Map<String, Object>> getMapList() {
		List<Map<String, Object>> mapList = mapDao.getMapList();
		
		return mapList;
	}
}
