package com.commerce.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("marketIndex")
public class MarketIndexController {
	
	@GetMapping("/search")
	public JSONObject search(@RequestBody JSONObject params) {
		JSONObject result = new JSONObject();
		result.put("code", 1);
		return result;
	}
}
