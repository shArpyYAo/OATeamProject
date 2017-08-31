package z_tknight.oa.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import z_tknight.oa.commons.util.CodecUtil;
import z_tknight.oa.service.demo.TestDemoService;
import z_tknight.oa.web.annotation.LogInfo;

@Controller
public class TestDemo {
	
	/**
	 * slf4j日志配置
	 */
	private static final Logger _LOG = LoggerFactory.getLogger(TestDemo.class);
	
	@Autowired
	private TestDemoService service;
	
	@LogInfo("测试")
	@RequestMapping("/test/{id}")
	public ModelAndView testDemo(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", "hello springMVC");
		mv.setViewName("testDemo");
		return mv;
	}
	
	@LogInfo("测试Map")
	@RequestMapping("/test")
	@ResponseBody
	public Map<String, Object> testDemo() {
		Map<String, Object> attribute = new HashMap<String, Object>();
		attribute.put("data", "MapTest");
		return attribute;
	}
	
}
