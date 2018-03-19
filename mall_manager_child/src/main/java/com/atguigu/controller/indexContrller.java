package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexContrller {

	@RequestMapping("/index")
	public String index(String title,String url,ModelMap map) {
		map.put("title", title);
		map.put("url", url);
		return "manager_index";
	}
}
