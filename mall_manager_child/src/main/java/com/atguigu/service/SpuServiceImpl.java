package com.atguigu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.OBJECT_T_MALL_PRODUNCT;
import com.atguigu.bean.T_MALL_PRODUCTE;
import com.atguigu.mapper.SpuMapper;

@Service
public class SpuServiceImpl implements SpuService {
	
	@Autowired
	private SpuMapper spuMapper;

	public void savePath(T_MALL_PRODUCTE pro, List<String> list_image) {
		//保存基本信息
		pro.setShp_tp(list_image.get(0));
		spuMapper.saveProduct(pro);
		
		//保存图片信息
		Map<Object,Object> hashMap = new HashMap<Object,Object>();
		hashMap.put("spu", pro);
		hashMap.put("list_image", list_image);
		spuMapper.saveImage(hashMap);
	}

	public List<T_MALL_PRODUCTE> select_all() {
		return spuMapper.select_all();
	}

	public boolean delete_spu(Integer id) {
		return spuMapper.delete_spu(id);
	}

	public OBJECT_T_MALL_PRODUNCT select_spu_by_id(Integer id) {
		return spuMapper.select_spu_by_id(id);
	}

	public void update_spu_massage(OBJECT_T_MALL_PRODUNCT spu) {
		spuMapper.update_spu_iamge(spu.getId(),spu.getList_image());
		T_MALL_PRODUCTE spu_massage = new T_MALL_PRODUCTE();
		spu_massage.setId(spu.getId());
		spu_massage.setShp_mch(spu.getShp_mch());
		spu_massage.setShp_msh(spu.getShp_msh());
		spu_massage.setShp_tp(spu.getShp_tp());
		spuMapper.update_spu_massage(spu_massage);
	}

}
