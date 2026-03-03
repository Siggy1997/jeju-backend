package kr.co.siggy.server.jsp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.siggy.server.common.BaseController;

@Controller
public class TestController extends BaseController{
	
	@Autowired
	private TestService testService;
	
	
	@GetMapping(value = "/testForm", name = "홈")
	public String dd() {
		System.out.println("!!!");
		
		return "";
	}
	
    @PostMapping("/testForm/submitDays")
    @ResponseBody
    public Map<String, Object> submitDaysAjax(@RequestBody Map<String, List<String>> req) {
        Map<String, Object> res = new HashMap<>();
        logger.info("선택된 DAY: " + req);
        List<Map<String, Object>> vocabList = testService.getVocabListByDays(req);
        logger.info("### RESULT {}", vocabList);
        res.put("result", vocabList);
        // 필요한 로직 처리 후 JSON 응답
        return res;
    }

    @PostMapping("/testForm/submitDays2")
    @ResponseBody
    public Map<String, Object> submitDays2Ajax(@RequestBody Map<String, List<String>> req) {
    	Map<String, Object> res = new HashMap<>();
    	logger.info("선택된 DAY: " + req);
    	List<Map<String, Object>> vocabList = testService.getVocabListByDays2(req);
    	logger.info("### RESULT {}", vocabList);
    	res.put("result", vocabList);
    	// 필요한 로직 처리 후 JSON 응답
    	return res;
    }

}
