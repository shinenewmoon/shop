package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.T_MALL_PRODUCTE;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.bean.T_MALL_SKU_ATTR_VALUE;

public interface SkuService {

	List<T_MALL_PRODUCTE> select_spu_ppmc(Integer pp_id, Integer class_2_id);

	void saveSkuValue(T_MALL_SKU sku, List<T_MALL_SKU_ATTR_VALUE> list_sku);

}
