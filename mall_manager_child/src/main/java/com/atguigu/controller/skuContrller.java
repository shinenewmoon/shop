package com.atguigu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.bean.T_MALL_PRODUCTE;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.service.AttrService;
import com.atguigu.service.SkuService;

@Controller
public class skuContrller {
	
	@Autowired
	private SkuService skuService;
	
	@Autowired
	private AttrService attrService;
	
	@RequestMapping("/save_sku")
	public String save_sku(T_MALL_SKU sku,MODEL_T_MALL_SKU_ATTR_VALUE list_sku) {
		skuService.saveSkuValue(sku,list_sku.getList_sku());
		return "redirect:/sku_add.do";
	}
	
	@RequestMapping("/get_sku_attr_list")
	public String get_sku_attr_list(Integer class_2_id,ModelMap map) {
		List<OBJECT_T_MALL_ATTR> list = attrService.select_massage(class_2_id);
		map.put("attr_sku_list", list);
		return "attr_sku_massage";
	}
	
	@RequestMapping("/goto_get_spu")
	@ResponseBody
	public List<T_MALL_PRODUCTE> goto_get_spu(Integer pp_id,Integer class_2_id) {
		System.out.println(pp_id);
		List<T_MALL_PRODUCTE> list_ppmc = new ArrayList<T_MALL_PRODUCTE>();
		//Êý¾Ý¿â²éÑ¯ppmc
		list_ppmc = skuService.select_spu_ppmc(pp_id,class_2_id);
		return list_ppmc;
	}
	
	@RequestMapping("sku_add")
	public String sku_add() {
		return "sku_add";
	}

	@RequestMapping("goto_sku_index")
	public String index() {
		return "manager_sku_index";
	}
}
