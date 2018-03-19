package com.atguigu.bean;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class T_MALL_SKU {

	@Field("id")
	private Integer id;
	@Field("shp_id")
	private Integer shp_id;
	@Field("kc")
	private Integer kc;
	@Field("jg")
	private double jg;
	@Field("chjshj")
	private Date chjshj;
	@Field("sku_mch")
	private String sku_mch;
	@Field("sku_xl")
	private Long sku_xl;
	@Field("kcdz")
	private String kcdz;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShp_id() {
		return shp_id;
	}

	public void setShp_id(Integer shp_id) {
		this.shp_id = shp_id;
	}

	public Integer getKc() {
		return kc;
	}

	public void setKc(Integer kc) {
		this.kc = kc;
	}

	public double getJg() {
		return jg;
	}

	public void setJg(double jg) {
		this.jg = jg;
	}

	public Date getChjshj() {
		return chjshj;
	}

	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}

	public String getSku_mch() {
		return sku_mch;
	}

	public void setSku_mch(String sku_mch) {
		this.sku_mch = sku_mch;
	}

	public Long getSku_xl() {
		return sku_xl;
	}

	public void setSku_xl(Long sku_xl) {
		this.sku_xl = sku_xl;
	}

	public String getKcdz() {
		return kcdz;
	}

	public void setKcdz(String kcdz) {
		this.kcdz = kcdz;
	}

}
