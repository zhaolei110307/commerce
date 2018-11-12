package com.commerce.service;

import org.springframework.web.multipart.MultipartFile;

public interface IMarketIndexService {
	
	//导入文件
	public String importFile(MultipartFile file);
	
	public Double findEqualsValue(String resultKey, String searchKey, String searchVal);
	//查询数据
	public Double findValueBySearchKey(String resultKey, String searchKey, String searchVal);
	//查询最大值
	public Double findMaxValue(String resultKey, String searchKey, String searchVal);
	//查询最小值
	public Double findMinValue(String resultKey, String searchKey, String searchVal);
	//查询最近最大
	public Double findCloseBig(String resultKey, String searchKey, String searchVal);
	//查询最近最小
	public Double findCloseSmall(String resultKey, String searchKey, String searchVal);
	
}