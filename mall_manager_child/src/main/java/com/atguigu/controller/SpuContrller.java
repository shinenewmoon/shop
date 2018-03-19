package com.atguigu.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.bean.OBJECT_T_MALL_PRODUNCT;
import com.atguigu.bean.T_MALL_IMAGE;
import com.atguigu.bean.T_MALL_PRODUCTE;
import com.atguigu.service.SpuService;
import com.atguigu.utils.MyUploadUtils;

@Controller
public class SpuContrller {
	@Autowired
	private SpuService spuService;
	
	@RequestMapping("update_spu_massage")
	public String update_spu_massage(@RequestParam("url") MultipartFile[] files,OBJECT_T_MALL_PRODUNCT spu) {
		List<String> url = null;
		//上传图片
		url=MyUploadUtils.uploadimage(files);
		List<T_MALL_IMAGE> list_image = new ArrayList<T_MALL_IMAGE>();
		for (int i = 0; i < url.size(); i++) {
			T_MALL_IMAGE img = new T_MALL_IMAGE();
			img.setUrl(url.get(i));
			img.setId(spu.getId());
			list_image.add(img);
		}
		spu.setList_image(list_image);
		spu.setShp_tp(url.get(0));
		spuService.update_spu_massage(spu);
		return "redirect:/goto_list_spu.do";
	}
	
	@RequestMapping("update_spu")
	public String update_spu(Integer id,ModelMap map) {
		OBJECT_T_MALL_PRODUNCT spu = spuService.select_spu_by_id(id);
		map.put("spu", spu);
		return "update_spu";
	}
	
	@RequestMapping("goto_spu_delete")
	@ResponseBody
	public String goto_spu_delete(Integer id) {
		boolean b = spuService.delete_spu(id);
		if(b) {
			return "success";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("goto_list_spu")
	public String goto_update_spu(ModelMap map) {
		List<T_MALL_PRODUCTE> list_spu = spuService.select_all();
		map.put("list_spu", list_spu);
		return "spu_list";
	}
	
	@RequestMapping("goto_index")
	public String index() {
		return "manager_spu";
	}
	
	@RequestMapping("goto_spu_add")
	public String add() {
		return "manager_add";
	}
	
	@RequestMapping("save_spu")
	public String save_spu(T_MALL_PRODUCTE pro,@RequestParam("files") MultipartFile[] files) {
		List<String> list_image = null;
		//上传图片
		list_image=MyUploadUtils.uploadimage(files);
		//保存路径
		spuService.savePath(pro,list_image);
		return "redirect:goto_spu_add.do";
	}
}
