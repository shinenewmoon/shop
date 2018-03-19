package com.atguigu.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;

import com.atguigu.bean.OBJECT_T_MALL_SKU_KEYWORDS;
import com.atguigu.json.CreateSqlSessionFactoryBean;
import com.atguigu.mapper.SkuMapper;

public class TestJson {
	public static void main(String[] args) throws Exception {
		 SqlSessionFactory sessionFactory = CreateSqlSessionFactoryBean.getSessionFactory();
	     SqlSession session = sessionFactory.openSession();
	     SkuMapper mapper = session.getMapper(SkuMapper.class);
	     
	     //查询所有的数据
	     List<OBJECT_T_MALL_SKU_KEYWORDS> list = mapper.select_sku_class2(28);
	     //连接solr
	     HttpSolrServer solr = new HttpSolrServer("http://localhost:8983/solr/sku");
	     //设置solr的字符集转换
	     solr.setParser(new XMLResponseParser());
	     
	     //将数据放入solr
	     solr.addBeans(list);
	     solr.commit();
	     
	}
}
