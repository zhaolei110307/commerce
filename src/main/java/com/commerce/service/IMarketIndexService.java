package com.commerce.service;

import org.springframework.web.multipart.MultipartFile;

public interface IMarketIndexService {
	public String importFile(MultipartFile file);
	
	public Object findValueBySearchKey(String resultKey, String searchKey, String searchVal);
}
