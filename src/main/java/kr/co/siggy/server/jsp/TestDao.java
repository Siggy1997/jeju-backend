package kr.co.siggy.server.jsp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.co.siggy.server.common.BaseDao;

@Repository
public class TestDao extends BaseDao{

	private String nameSpace = "Test";


	public List<Map<String, Object>> getVocabListByDays(Map<String, List<String>> req) {
		return sqlSession.selectList(nameSpace + ".getVocabListByDays", req);
	}

}
