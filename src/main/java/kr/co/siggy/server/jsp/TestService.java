package kr.co.siggy.server.jsp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.siggy.server.common.BaseController;

@Service
public class TestService extends BaseController{
	
	@Autowired
	private TestDao testDao;


	public List<Map<String, Object>> getVocabListByDays(Map<String, List<String>> req) {
		List<Map<String, Object>> vocabList = testDao.getVocabListByDays(req);
		return vocabList;
	}

}
