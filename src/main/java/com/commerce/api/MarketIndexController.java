package com.commerce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.commerce.dao.IMarketIndexDao;
import com.commerce.service.IMarketIndexService;

@RestController
@RequestMapping("marketIndex")
public class MarketIndexController {
	
	@Autowired
	IMarketIndexService marketIndexService;
	@Autowired
	IMarketIndexDao marketIndexDao;
	
	@PostMapping("/search")
	public JSONObject search(@RequestBody JSONObject params) {
//		Object findValue = marketIndexDao.findValue("sale", "sale_index", "65591");
//		Object findValue = marketIndexDao.findValue("sale_index", "65591");
		Object findValue = marketIndexService.findValueBySearchKey("sale", "sale_index", "65591");
		JSONObject result = new JSONObject();
		result.put("code", 1);
		result.put("content", findValue);
		return result;
	}
	
	@PostMapping("/upload")
	public JSONObject upload(@RequestParam MultipartFile file) {
		String fileId = marketIndexService.importFile(file);
		JSONObject result = new JSONObject();
		result.put("code", 1);
		result.put("content", fileId);
		return result;
	}
}
