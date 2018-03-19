package com.atguigu.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.OBJECT_T_MALL_SKU_KEYWORDS;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;

@Controller
public class KeyWordsController {
	
	@RequestMapping("keywords/{keywords}")
	@ResponseBody
	public List<OBJECT_T_MALL_SKU_KEYWORDS> sku_keyWords(@PathVariable String keywords) {
		List<OBJECT_T_MALL_SKU_KEYWORDS> list = new ArrayList<OBJECT_T_MALL_SKU_KEYWORDS>();
		//练肌肉solr
		HttpSolrServer solr = new HttpSolrServer("http://localhost:8983/solr/sku");
		solr.setParser(new XMLResponseParser());
		
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("copy_item:" + keywords);
		//solrQuery.setQuery("*:*");
		//获取数据
		try {
			QueryResponse query = solr.query(solrQuery);
			list = query.getBeans(OBJECT_T_MALL_SKU_KEYWORDS.class);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
