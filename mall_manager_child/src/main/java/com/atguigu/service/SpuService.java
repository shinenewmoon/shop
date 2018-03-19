package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.OBJECT_T_MALL_PRODUNCT;
import com.atguigu.bean.T_MALL_PRODUCTE;

public interface SpuService {

	void savePath(T_MALL_PRODUCTE pro, List<String> list_image);

	List<T_MALL_PRODUCTE> select_all();

	boolean delete_spu(Integer id);

	OBJECT_T_MALL_PRODUNCT select_spu_by_id(Integer id);

	void update_spu_massage(OBJECT_T_MALL_PRODUNCT spu);


}
