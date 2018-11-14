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
import com.commerce.entity.MarketIndexType;
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
		int type = params.getIntValue("type");
		String resultCol = MarketIndexType.getColumnByType(type);
		if (resultCol == null) {
			throw new RuntimeException("未知查询类型");
		}
		String searchVal = MarketIndexType.getSearchColumnByType(type);
		if (searchVal == null) {
			throw new RuntimeException("未知查询类型");
		}
		Object findValue = marketIndexService
			.findValueBySearchKey(resultCol, searchVal, params.getString("value"));
		JSONObject result = new JSONObject();
		result.put("code", 1);
		result.put("content", findValue);
		return result;
	}
	
	@PostMapping("/getLimit")
	public JSONObject getLimit(@RequestBody JSONObject params) {
		int type = params.getIntValue("type");
		String searchVal = MarketIndexType.getSearchColumnByType(type);
		if (searchVal == null) {
			throw new RuntimeException("未知查询类型");
		}
		Object maxVal = marketIndexService
			.findMaxValue(searchVal);
		Object minVal = marketIndexService
				.findMinValue(searchVal);
		JSONObject content = new JSONObject();
		content.put("maxVal", maxVal);
		content.put("minVal", minVal);
		JSONObject result = new JSONObject();
		result.put("code", 1);
		result.put("content", content);
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
