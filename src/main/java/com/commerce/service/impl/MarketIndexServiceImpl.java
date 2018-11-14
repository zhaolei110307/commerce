package com.commerce.service.impl;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	@Autowired
	EntityManager em;
	
	@Override
	public String importFile(MultipartFile file) {
		Integer num = 0;
		StringBuffer errMsg = new StringBuffer();
		try {
			List<String[]> infos = POIUtil.readExcel(file);
			if (infos == null || infos.size() < 1) {
				throw new RuntimeException("文件无数据");
			}
			MarketIndex index = null;
			int indexNum = 1;
			for (String[] strings : infos) {
				try {
					indexNum ++;
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
					
//					index.setAddCart(BigDecimalUtil.doubleValue(strings[15]));
//					index.setAddCartIndex(BigDecimalUtil.doubleValue(strings[16]));
					marketIndexDao.save(index);
					num ++;
				} catch (Exception e) {
					errMsg.append("第" + indexNum + "行数据导入出错: " + e.getMessage() + "; ");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "成功导入" + num + "条数据.   " + errMsg.toString();
	}

	@Override
	public Double findValueBySearchKey(String resultKey, String searchKey, String searchVal) {
		Double result = findEqualsValue(resultKey, searchKey, searchVal);
		if (result == null) {
			Double max = findCloseBig(resultKey, searchKey, searchVal);
			Double min = findCloseSmall(resultKey, searchKey, searchVal);
			if (max == null) {
				max = 0D;
			}
			if (min == null) {
				min = 0D;
			}
			return (max + min) / 2.0;
		}
		return result;
	}

	@Override
	public Double findMaxValue(String resultKey) {
		StringBuffer sb = new StringBuffer();
		sb.append("select max( ");
		sb.append(resultKey);
		sb.append(" ) from market_index ");
		Query query = em.createNativeQuery(sb.toString());
		Object obj = query.getSingleResult();
		return obj == null ? null : (Double)obj;
	}
	
	@SuppressWarnings("rawtypes")
	public Double findEqualsValue(String resultKey, String searchKey, String searchVal) {
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append(resultKey);
		sb.append(" from market_index where ");
		sb.append(searchKey);
		sb.append(" = ");
		sb.append(searchVal);
		Query query = em.createNativeQuery(sb.toString());
		List resultList = query.getResultList();
		Object obj = null;
		if (resultList != null && resultList.size() > 0) {
			obj = resultList.get(0);
		}
		return obj == null ? null : (Double)obj;
	}

	@Override
	public Double findMinValue(String resultKey) {
		StringBuffer sb = new StringBuffer();
		sb.append("select min(");
		sb.append(resultKey);
		sb.append(") from market_index");
		Query query = em.createNativeQuery(sb.toString());
		Object obj = query.getSingleResult();
		return obj == null ? null : (Double)obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Double findCloseBig(String resultKey, String searchKey, String searchVal) {
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append(resultKey);
		sb.append(" from market_index where ");
		sb.append(searchKey);
		sb.append(" > ");
		sb.append(searchVal);
		sb.append(" order by ");
		sb.append(searchKey);
		sb.append(" ASC");
		Query query = em.createNativeQuery(sb.toString());
		List resultList = query.getResultList();
		Object obj = null;
		if (resultList != null && resultList.size() > 0) {
			obj = resultList.get(0);
		}
		return obj == null ? null : (Double)obj;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Double findCloseSmall(String resultKey, String searchKey, String searchVal) {
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append(resultKey);
		sb.append(" from market_index where ");
		sb.append(searchKey);
		sb.append(" < ");
		sb.append(searchVal);
		sb.append(" order by ");
		sb.append(searchKey);
		sb.append(" DESC");
		Query query = em.createNativeQuery(sb.toString());
		List resultList = query.getResultList();
		Object obj = null;
		if (resultList != null && resultList.size() > 0) {
			obj = resultList.get(0);
		}
		return obj == null ? null : (Double)obj;
	}
}
