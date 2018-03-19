package com.atguigu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.bean.T_MALL_PRODUCTE;
import com.atguigu.bean.T_MALL_SKU;

public interface SkuMapper {

	List<T_MALL_PRODUCTE> select_spu_ppmc(@Param("pp_id") Integer pp_id,@Param("class_2_id") Integer class_2_id);

	void select_sku(T_MALL_SKU sku);

	void select_sku_value(Map<Object, Object> hashMap);

}
