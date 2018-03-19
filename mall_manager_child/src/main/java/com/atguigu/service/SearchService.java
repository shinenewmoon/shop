package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.MODEL_T_MALL_SKU;
import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.bean.T_MALL_SKU_ATTR_VALUE;

public interface SearchService {


	List<MODEL_T_MALL_SKU> select_sku_massagr_attr(String order, Integer class_2_id,
			List<T_MALL_SKU_ATTR_VALUE> list);

}
