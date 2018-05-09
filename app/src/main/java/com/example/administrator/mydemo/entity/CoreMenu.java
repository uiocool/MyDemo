package com.example.administrator.mydemo.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * @author Administrator
 *       用途未知
 */
public class CoreMenu {
	private String id;
	private String name;                      //菜单名   不懂
	private String pr_menu_id;                  //上级菜单
	private String to_url;                  //跳转地址
	private String level;               //层级
	private String sort;                      //排序字段
	private String ioc;                             //图标
	private String create_by;
	private String update_by;
	private Timestamp create_date;
	private Date update_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPr_menu_id() {
		return pr_menu_id;
	}
	public void setPr_menu_id(String pr_menu_id) {
		this.pr_menu_id = pr_menu_id;
	}
	public String getTo_url() {
		return to_url;
	}
	public void setTo_url(String to_url) {
		this.to_url = to_url;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getIoc() {
		return ioc;
	}
	public void setIoc(String ioc) {
		this.ioc = ioc;
	}
	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	public String getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public CoreMenu(String id, String name, String pr_menu_id, String to_url, String level, String sort, String ioc,
			String create_by, String update_by, Timestamp create_date, Date update_date) {
		super();
		this.id = id;
		this.name = name;
		this.pr_menu_id = pr_menu_id;
		this.to_url = to_url;
		this.level = level;
		this.sort = sort;
		this.ioc = ioc;
		this.create_by = create_by;
		this.update_by = update_by;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public CoreMenu() {
		super();
	}
	@Override
	public String toString() {
		return "CoreMenu [id=" + id + ", name=" + name + ", pr_menu_id=" + pr_menu_id + ", to_url=" + to_url
				+ ", level=" + level + ", sort=" + sort + ", ioc=" + ioc + ", create_by=" + create_by + ", update_by="
				+ update_by + ", create_date=" + create_date + ", update_date=" + update_date + "]";
	}
	
	
}
