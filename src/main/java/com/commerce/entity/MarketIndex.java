package com.commerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "market_index")
//销售额	交易指数		真实UV	流量指数		
//真实搜素	搜素人气		真实转化率	支付转化指数		
//真实收藏数	收藏人气		真实加购	加购人气
public class MarketIndex implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double sale;//(销量)销售额

	@Column(name="sale_index")
	private Double saleIndex;//交易指数
	
	private Double flow;//(流量)真实UV
	
	@Column(name="flow_index")
	private Double flowIndex;//流量指数	
	
	private Double search;//真实搜素
	
	@Column(name="search_index")
	private Double searchIndex;//搜素人气
	
	private Double pay;
	
	@Column(name="pay_index")
	private Double payIndex;
	
	private Double collect;
	
	@Column(name="collect_index")
	private Double collectIndex;
	
	@Column(name="add_cart")
	private Double addCart;
	
	@Column(name="add_cart_index")
	private Double addCartIndex;
	
	public MarketIndex() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSale() {
		return sale;
	}

	public void setSale(Double sale) {
		this.sale = sale;
	}

	public Double getSaleIndex() {
		return saleIndex;
	}

	public void setSaleIndex(Double saleIndex) {
		this.saleIndex = saleIndex;
	}

	public Double getFlow() {
		return flow;
	}

	public void setFlow(Double flow) {
		this.flow = flow;
	}

	public Double getFlowIndex() {
		return flowIndex;
	}

	public void setFlowIndex(Double flowIndex) {
		this.flowIndex = flowIndex;
	}

	public Double getSearch() {
		return search;
	}

	public void setSearch(Double search) {
		this.search = search;
	}

	public Double getSearchIndex() {
		return searchIndex;
	}

	public void setSearchIndex(Double searchIndex) {
		this.searchIndex = searchIndex;
	}

	public Double getPay() {
		return pay;
	}

	public void setPay(Double pay) {
		this.pay = pay;
	}

	public Double getPayIndex() {
		return payIndex;
	}

	public void setPayIndex(Double payIndex) {
		this.payIndex = payIndex;
	}

	public Double getCollect() {
		return collect;
	}

	public void setCollect(Double collect) {
		this.collect = collect;
	}

	public Double getCollectIndex() {
		return collectIndex;
	}

	public void setCollectIndex(Double collectIndex) {
		this.collectIndex = collectIndex;
	}

	public Double getAddCart() {
		return addCart;
	}

	public void setAddCart(Double addCart) {
		this.addCart = addCart;
	}

	public Double getAddCartIndex() {
		return addCartIndex;
	}

	public void setAddCartIndex(Double addCartIndex) {
		this.addCartIndex = addCartIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addCart == null) ? 0 : addCart.hashCode());
		result = prime * result + ((addCartIndex == null) ? 0 : addCartIndex.hashCode());
		result = prime * result + ((collect == null) ? 0 : collect.hashCode());
		result = prime * result + ((collectIndex == null) ? 0 : collectIndex.hashCode());
		result = prime * result + ((flow == null) ? 0 : flow.hashCode());
		result = prime * result + ((flowIndex == null) ? 0 : flowIndex.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pay == null) ? 0 : pay.hashCode());
		result = prime * result + ((payIndex == null) ? 0 : payIndex.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
		result = prime * result + ((saleIndex == null) ? 0 : saleIndex.hashCode());
		result = prime * result + ((search == null) ? 0 : search.hashCode());
		result = prime * result + ((searchIndex == null) ? 0 : searchIndex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarketIndex other = (MarketIndex) obj;
		if (addCart == null) {
			if (other.addCart != null)
				return false;
		} else if (!addCart.equals(other.addCart))
			return false;
		if (addCartIndex == null) {
			if (other.addCartIndex != null)
				return false;
		} else if (!addCartIndex.equals(other.addCartIndex))
			return false;
		if (collect == null) {
			if (other.collect != null)
				return false;
		} else if (!collect.equals(other.collect))
			return false;
		if (collectIndex == null) {
			if (other.collectIndex != null)
				return false;
		} else if (!collectIndex.equals(other.collectIndex))
			return false;
		if (flow == null) {
			if (other.flow != null)
				return false;
		} else if (!flow.equals(other.flow))
			return false;
		if (flowIndex == null) {
			if (other.flowIndex != null)
				return false;
		} else if (!flowIndex.equals(other.flowIndex))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pay == null) {
			if (other.pay != null)
				return false;
		} else if (!pay.equals(other.pay))
			return false;
		if (payIndex == null) {
			if (other.payIndex != null)
				return false;
		} else if (!payIndex.equals(other.payIndex))
			return false;
		if (sale == null) {
			if (other.sale != null)
				return false;
		} else if (!sale.equals(other.sale))
			return false;
		if (saleIndex == null) {
			if (other.saleIndex != null)
				return false;
		} else if (!saleIndex.equals(other.saleIndex))
			return false;
		if (search == null) {
			if (other.search != null)
				return false;
		} else if (!search.equals(other.search))
			return false;
		if (searchIndex == null) {
			if (other.searchIndex != null)
				return false;
		} else if (!searchIndex.equals(other.searchIndex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MarketIndex [id=" + id + ", sale=" + sale + ", saleIndex=" + saleIndex + ", flow=" + flow
				+ ", flowIndex=" + flowIndex + ", search=" + search + ", searchIndex=" + searchIndex + ", pay=" + pay
				+ ", payIndex=" + payIndex + ", collect=" + collect + ", collectIndex=" + collectIndex + ", addCart="
				+ addCart + ", addCartIndex=" + addCartIndex + "]";
	}
	
	
}
