package com.atguigu.bean;

import java.sql.Timestamp;

public class T_MALL_PRODUCTE {
	private Integer id;
	private String shp_mch;
	private String shp_tp;
	private Integer flbh1;
	private Integer flbh2;
	private Integer pp_id;
	private Timestamp chjshj;
	private String shp_msh;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShp_mch() {
		return shp_mch;
	}

	public void setShp_mch(String shp_mch) {
		this.shp_mch = shp_mch;
	}

	public String getShp_tp() {
		return shp_tp;
	}

	public void setShp_tp(String shp_tp) {
		this.shp_tp = shp_tp;
	}

	public Integer getFlbh1() {
		return flbh1;
	}

	public void setFlbh1(Integer flbh1) {
		this.flbh1 = flbh1;
	}

	public Integer getFlbh2() {
		return flbh2;
	}

	public void setFlbh2(Integer flbh2) {
		this.flbh2 = flbh2;
	}

	public Integer getPp_id() {
		return pp_id;
	}

	public void setPp_id(Integer pp_id) {
		this.pp_id = pp_id;
	}

	public Timestamp getChjshj() {
		return chjshj;
	}

	public void setChjshj(Timestamp chjshj) {
		this.chjshj = chjshj;
	}

	public String getShp_msh() {
		return shp_msh;
	}

	public void setShp_msh(String shp_msh) {
		this.shp_msh = shp_msh;
	}

	@Override
	public String toString() {
		return "T_MALL_PRODUCTE [id=" + id + ", shp_mch=" + shp_mch + ", shp_tp=" + shp_tp + ", flbh1=" + flbh1
				+ ", flbh2=" + flbh2 + ", pp_id=" + pp_id + ", chjshj=" + chjshj + ", shp_msh=" + shp_msh + "]";
	}

}
