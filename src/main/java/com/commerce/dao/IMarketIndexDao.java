package com.commerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.commerce.entity.MarketIndex;

public interface IMarketIndexDao extends JpaRepository<MarketIndex, Long> {

//	@Query(value = "select ?1 from market_index where ?2 = ?3", nativeQuery = true)
//	Object findValue(String resultKey, String searchKey, String searchVal);
	
//	@Query(value = "select :resultKey from market_index where :searchKey = :searchVal", nativeQuery = true)
//	Object findValue(@Param("resultKey")String resultKey, @Param("searchKey")String searchKey, @Param("searchVal")String searchVal);
	
	@Query(value = "select * from market_index where ?1 = ?2 limit 1", nativeQuery = true)
	Object findValue(String searchKey, String searchVal);
}
