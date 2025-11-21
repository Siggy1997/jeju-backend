package kr.co.siggy.server.map.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.siggy.server.common.BaseDao;

@Repository
public class MapDao extends BaseDao{

	private String nameSpace = "Map";


	public List<Map<String, Object>> getMapList() {
		return sqlSession.selectList(nameSpace + ".getMapList");
	}
}
