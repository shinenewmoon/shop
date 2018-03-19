package com.atguigu.mapper;

import java.util.List;
import java.util.Map;

import com.atguigu.bean.MODEL_T_MALL_SKU;
import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.bean.T_MALL_SKU;

public interface SearchMapper {

	List<MODEL_T_MALL_SKU> select_sku_massage(Integer class_2_id);

	List<MODEL_T_MALL_SKU> select_sku_massage_attr(Map<Object, Object> map);


	List<T_MALL_SKU> select_sku_list(Integer spu_id);

}
