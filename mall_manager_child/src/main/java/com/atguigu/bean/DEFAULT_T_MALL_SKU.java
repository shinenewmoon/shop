package com.atguigu.bean;

import java.util.List;

public class DEFAULT_T_MALL_SKU extends T_MALL_SKU {
	private T_MALL_PRODUCTE spu;
	private List<T_MALL_IMAGE> image;
	private List<MODEL_T_MALL_ATTR_NAME> list_av_name;

	public T_MALL_PRODUCTE getSpu() {
		return spu;
	}

	public void setSpu(T_MALL_PRODUCTE spu) {
		this.spu = spu;
	}

	public List<T_MALL_IMAGE> getImage() {
		return image;
	}

	public void setImage(List<T_MALL_IMAGE> image) {
		this.image = image;
	}

	public List<MODEL_T_MALL_ATTR_NAME> getList_av_name() {
		return list_av_name;
	}

	public void setList_av_name(List<MODEL_T_MALL_ATTR_NAME> list_av_name) {
		this.list_av_name = list_av_name;
	}
	
	
	
	
	
	

}
