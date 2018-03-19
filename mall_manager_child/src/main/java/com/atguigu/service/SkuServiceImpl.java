package com.atguigu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.T_MALL_PRODUCTE;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.bean.T_MALL_SKU_ATTR_VALUE;
import com.atguigu.mapper.SkuMapper;

@Service
public class SkuServiceImpl implements SkuService {

	@Autowired
	private SkuMapper skuMapper;
	
	public List<T_MALL_PRODUCTE> select_spu_ppmc(Integer pp_id, Integer class_2_id) {
		List<T_MALL_PRODUCTE> list_ppmc = skuMapper.select_spu_ppmc(pp_id,class_2_id);
		return list_ppmc;
	}

	public void saveSkuValue(T_MALL_SKU sku, List<T_MALL_SKU_ATTR_VALUE> list_sku) {
		//插入sku表格，生成sku_id
		skuMapper.select_sku(sku);
		//插入value表格
		Map<Object,Object> hashMap = new HashMap<Object,Object>();
		hashMap.put("sku_id", sku.getId());
		hashMap.put("shp_id", sku.getShp_id());
		hashMap.put("list_sku", list_sku);
		skuMapper.select_sku_value(hashMap);
	}

}
