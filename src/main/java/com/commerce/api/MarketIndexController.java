package com.commerce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.commerce.service.IMarketIndexService;

@RestController
@RequestMapping("marketIndex")
public class MarketIndexController {
	
	@Autowired
	IMarketIndexService marketIndexService;
	
	@PostMapping("/search")
	public JSONObject search(@RequestBody JSONObject params) {
		JSONObject result = new JSONObject();
		result.put("code", 1);
		return result;
	}
	
	@PostMapping("/upload")
	public JSONObject upload(@RequestParam MultipartFile file) {
		String fileId = marketIndexService.importFile(file);
		return null;
	}
}
