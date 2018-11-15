package com.commerce.entity;

//销售额	交易指数		真实UV	流量指数		
//真实搜素	搜素人气		真实转化率	支付转化指数		
//真实收藏数	收藏人气		真实加购	加购人气
public class MarketIndexType {

	public static final int SALE = 1;//销量
	public static final int FLOW = 2;//流量
	public static final int SEARCH = 3;//搜索
	public static final int PAY = 4;//支付转化
	public static final int COLLECT = 5;//收藏
	public static final int ADD = 6;//加购

	public static String getColumnByType(int type) {
		if (type == SALE) {
			return "sale";
		}
		if (type == FLOW) {
			return "flow";
		}
		if (type == SEARCH) {
			return "search";
		}
		if (type == PAY) {
			return "pay";
		}
		if (type == COLLECT) {
			return "collect";
		}
		if (type == ADD) {
			return "add_cart";
		}
		return null;
	}

	public static String getSearchColumnByType(int type) {
		if (type == SALE) {
			return "sale_index";
		}
		if (type == FLOW) {
			return "flow_index";
		}
		if (type == SEARCH) {
			return "search_index";
		}
		if (type == PAY) {
			return "pay_index";
		}
		if (type == COLLECT) {
			return "collect_index";
		}
		if (type == ADD) {
			return "add_cart_index";
		}
		return null;
	}
}
