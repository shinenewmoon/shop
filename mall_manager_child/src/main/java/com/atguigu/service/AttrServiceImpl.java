package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.MODEL_OBJECT_T_MALL_ATTR;
import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.mapper.AttrMapper;

@Service
public class AttrServiceImpl implements AttrService {
	
	@Autowired
	private AttrMapper attrMapper;

	public List<OBJECT_T_MALL_ATTR> select_massage(Integer class_2_id) {
		List<OBJECT_T_MALL_ATTR> list_value = attrMapper.select_massage(class_2_id);
		return list_value;
	}

	public void save_attr(List<OBJECT_T_MALL_ATTR> list_attr,Integer class_2_id) {
		//主键返回只能一个一个的返回
		for (int i = 0; i < list_attr.size(); i++) {
			attrMapper.saveAttr(class_2_id,list_attr.get(i));
			attrMapper.saveValue(list_attr.get(i).getId(),list_attr.get(i).getList_value());
		}
	}

	public List<OBJECT_T_MALL_ATTR> select_attr(Integer class_2_id, String class_2_name) {
		return attrMapper.select_attr(class_2_id,class_2_name);
	}

	public List<Integer> select_attr_value_id(int attr_id) {
		return attrMapper.select_attr_value_id(attr_id);
	}

}
