package com.commerce.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.commerce.dao.IMarketIndexDao;
import com.commerce.entity.MarketIndex;
import com.commerce.service.IMarketIndexService;
import com.commerce.util.BigDecimalUtil;
import com.commerce.util.POIUtil;


@Service
@Component
public class MarketIndexServiceImpl implements IMarketIndexService {

	@Autowired
	IMarketIndexDao marketIndexDao;
	
	@Override
	public String importFile(MultipartFile file) {//.xls
		Integer num = 0;
		StringBuffer errMsg = new StringBuffer();
		try {
			List<String[]> infos = POIUtil.readExcel(file);
			if (infos == null || infos.size() < 1) {
				throw new RuntimeException("文件无数据");
			}
			MarketIndex index = null;
			for (String[] strings : infos) {
				index = new MarketIndex();
				index.setSale(BigDecimalUtil.doubleValue(strings[0]));
				index.setSaleIndex(BigDecimalUtil.doubleValue(strings[1]));

				index.setFlow(BigDecimalUtil.doubleValue(strings[3]));
				index.setFlowIndex(BigDecimalUtil.doubleValue(strings[4]));

				index.setSearch(BigDecimalUtil.doubleValue(strings[6]));
				index.setSearchIndex(BigDecimalUtil.doubleValue(strings[7]));

				index.setPay(BigDecimalUtil.doubleValue(strings[9]));
				index.setPayIndex(BigDecimalUtil.doubleValue(strings[10]));
				
				index.setCollect(BigDecimalUtil.doubleValue(strings[12]));
				index.setCollectIndex(BigDecimalUtil.doubleValue(strings[13]));
				
//				index.setAddCart(strings[15]);
//				index.setAddCartIndex(strings[16]);
				marketIndexDao.save(index);
				num ++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "成功导入" + num + "条数据.   " + errMsg.toString();
	}
}
