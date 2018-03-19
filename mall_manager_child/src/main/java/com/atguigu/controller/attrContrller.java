package com.atguigu.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.MODEL_OBJECT_T_MALL_ATTR;
import com.atguigu.bean.MODEL_T_MALL_SKU;
import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.bean.T_MALL_SKU_ATTR_VALUE;
import com.atguigu.service.AttrService;
import com.atguigu.service.SearchService;
import com.atguigu.utils.MySearchUtil;

@Controller
public class attrContrller {
	
	@Autowired
	private AttrService attrService;
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping("refresh_attr_search")
	@ResponseBody
	public String refresh_attr_search(Integer class_2_id,@RequestParam("list_attr[]") int[] list_attr) {
		int count = 0;
		for (int i = 0; i < list_attr.length; i++) {
			int attr_id = list_attr[i];
			List<Integer> list = attrService.select_attr_value_id(attr_id);
			for (int j = 0; j < list.size(); j++) {
				Integer value_id = list.get(j);
				List<T_MALL_SKU_ATTR_VALUE> attr_value = new ArrayList<T_MALL_SKU_ATTR_VALUE>();
				T_MALL_SKU_ATTR_VALUE t_MALL_SKU_ATTR_VALUE = new T_MALL_SKU_ATTR_VALUE();
				t_MALL_SKU_ATTR_VALUE.setShxm_id(attr_id);
				t_MALL_SKU_ATTR_VALUE.setShxzh_id(value_id);
				List<MODEL_T_MALL_SKU> select_sku_massagr_attr = searchService.select_sku_massagr_attr("", class_2_id, attr_value);
				
				String key = "attr_" + attr_id + "_value_" + value_id;
				
				MySearchUtil.setRedis(key, select_sku_massagr_attr);
			}
		}
		return count + "";
	}
	
	@RequestMapping("get_attr_list_json")
	@ResponseBody
	public List<OBJECT_T_MALL_ATTR> get_attr_list_json(Integer class_2_id,String class_2_name){
		
		return attrService.select_attr(class_2_id,class_2_name);
	}
	
	@RequestMapping("goto_search")
	public String goto_search() {
		return "manager_search_redis";
	}
	
	@RequestMapping("save_attr")
	public ModelAndView save_attr(MODEL_OBJECT_T_MALL_ATTR list_attr,Integer class_2_id,String class_2_name) {
		attrService.save_attr(list_attr.getList_attr(),class_2_id);
		//System.out.println(class_2_id);
		ModelAndView mv = new ModelAndView("redirect:/index.do");
		//重定向时携带的参数
		mv.addObject("title", "添加属性");
		mv.addObject("url", "attr_massage_add.do?class_2_id" + class_2_id + "&class_2_name=" + class_2_name);
		return mv;
	}
	
	@RequestMapping("attr_massage_add")
	public String attr_massage_add(Integer class_2_id,String class_2_name,ModelMap map) {
		map.put("class_2_id", class_2_id);
		//System.out.println(class_2_id);
		map.put("class_2_name", class_2_name);
		return "attr_massage_add";
	}

	@RequestMapping("attr_massage")
	public String attr_massage(Integer class_2_id,ModelMap map) {
		
		List<OBJECT_T_MALL_ATTR> list_attr = new ArrayList<OBJECT_T_MALL_ATTR>();
		
		//查询对应的属性信息
		list_attr = attrService.select_massage(class_2_id);
		
		map.put("list_attr", list_attr);
		
		return "attr_massage";
	}
	
	@RequestMapping("attr_massage_json")
	@ResponseBody
	public List<OBJECT_T_MALL_ATTR> attr_massage_json(Integer class_2_id,ModelMap map) {
		
		List<OBJECT_T_MALL_ATTR> list_attr = new ArrayList<OBJECT_T_MALL_ATTR>();
		
		//查询对应的属性信息
		list_attr = attrService.select_massage(class_2_id);
		
		map.put("list_attr", list_attr);
		
		return list_attr;
	}
	
	@RequestMapping("goto_attr_index")
	public String index() {
		return "manager_attr_index";
	}
	
}
