package com.atguigu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.bean.OBJECT_T_MALL_PRODUNCT;
import com.atguigu.bean.T_MALL_IMAGE;
import com.atguigu.bean.T_MALL_PRODUCTE;

public interface SpuMapper {

	void saveProduct(T_MALL_PRODUCTE pro);
	
	void saveImage(Map<Object,Object> hashMap);

	List<T_MALL_PRODUCTE> select_all();

	boolean delete_spu(Integer id);

	OBJECT_T_MALL_PRODUNCT select_spu_by_id(Integer id);

	void update_spu_massage(T_MALL_PRODUCTE spu_massage);

	void update_spu_iamge(@Param("id") Integer id, @Param("list_image") List<T_MALL_IMAGE> list_image);

}
