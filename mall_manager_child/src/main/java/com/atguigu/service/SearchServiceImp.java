package com.atguigu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.MODEL_T_MALL_SKU;
import com.atguigu.bean.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.bean.T_MALL_SKU_ATTR_VALUE;
import com.atguigu.mapper.SearchMapper;

@Service
public class SearchServiceImp implements SearchService {

	@Autowired
	private SearchMapper searchMapper;

	public List<MODEL_T_MALL_SKU> select_sku_massagr_attr(String order, Integer class_2_id,
			List<T_MALL_SKU_ATTR_VALUE> list) {
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("class_2_id", class_2_id);
		if(StringUtils.isNotBlank(order)) {
			map.put("order", order);
		}
		
		if(list != null && list.size() != 0) {
			StringBuffer str = new StringBuffer();
			str.append("and sku.Id in (");
			str.append("select sku0.sku_id from ");
			for(int i = 0 ; i< list.size() ; i++) {
				str.append("(select sku_id from t_mall_sku_attr_value where shxm_id="+list.get(i).getShxm_id()+" and shxzh_id="+list.get(i).getShxzh_id()+") sku"+i+" ");
				if(list.size() > 1 && i < list.size() - 1) {
					str.append(" , ");
				}
			}
			
			if(list.size() > 1) {
				str.append("where ");
				for(int i = 0 ; i < list.size() ; i++) {
					if(i < list.size() - 1) {
					str.append("sku"+i+".sku_id = sku"+(i+1)+".sku_id");
					}
					if(i < list.size() - 2 && list.size() > 2) {
						str.append("and");
					}
				}
			}
			str.append(")");
			map.put("sql", str.toString());
		}
		List<MODEL_T_MALL_SKU> list_attr = searchMapper.select_sku_massage_attr(map);
		return list_attr;
	}


}
