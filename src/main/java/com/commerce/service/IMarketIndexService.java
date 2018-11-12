package com.commerce.service;

import org.springframework.web.multipart.MultipartFile;

public interface IMarketIndexService {
	public String importFile(MultipartFile file);
}
