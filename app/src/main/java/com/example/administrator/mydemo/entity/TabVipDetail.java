package com.example.administrator.mydemo.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *    同TabVip一样 ，已取消
 * @author Administrator
 *
 */
public class TabVipDetail {
	private String id;
	private String vip_id;               //vip
	private String name;               //需求标题
	private String content;               //描述
	private String file;              //文件
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
	public String getVip_id() {
		return vip_id;
	}
	public void setVip_id(String vip_id) {
		this.vip_id = vip_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
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
	public TabVipDetail(String id, String vip_id, String name, String content, String file, String create_by,
			String update_by, Timestamp create_date, Date update_date) {
		super();
		this.id = id;
		this.vip_id = vip_id;
		this.name = name;
		this.content = content;
		this.file = file;
		this.create_by = create_by;
		this.update_by = update_by;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public TabVipDetail() {
		super();
	}
	@Override
	public String toString() {
		return "TabVipDetail [id=" + id + ", vip_id=" + vip_id + ", name=" + name + ", content=" + content + ", file="
				+ file + ", create_by=" + create_by + ", update_by=" + update_by + ", create_date=" + create_date
				+ ", update_date=" + update_date + "]";
	}
	
	
}
