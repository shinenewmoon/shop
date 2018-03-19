package com.atguigu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.bean.T_MALL_VALUE;

public interface AttrMapper {

	List<OBJECT_T_MALL_ATTR> select_massage(Integer class_2_id);

	void saveValue(@Param("attr_id") Integer attr_id, @Param("list_value") List<T_MALL_VALUE> list_value);

	void saveAttr(@Param("class_2_id") Integer class_2_id, @Param("list_attr") OBJECT_T_MALL_ATTR list_attr);

	List<OBJECT_T_MALL_ATTR> select_attr(@Param("class_2_id") Integer class_2_id, @Param("class_2_name") String class_2_name);

	List<Integer> select_attr_value_id(int attr_id);

}
