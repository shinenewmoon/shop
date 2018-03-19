package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.OBJECT_T_MALL_ATTR;

public interface AttrService {

	List<OBJECT_T_MALL_ATTR> select_massage(Integer class_2_id);

	void save_attr(List<OBJECT_T_MALL_ATTR> list_attr,Integer class_2_id);

	List<OBJECT_T_MALL_ATTR> select_attr(Integer class_2_id, String class_2_name);

	List<Integer> select_attr_value_id(int attr_id);

}
