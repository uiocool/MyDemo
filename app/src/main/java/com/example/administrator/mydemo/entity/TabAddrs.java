package com.example.administrator.mydemo.entity;

import java.sql.Timestamp;
import java.util.Date;
/**
 * 
 * @author Administrator
 *             终于有用了-v-
 */
public class TabAddrs {
	private String id;
	private String name;           //地区
	private String create_by;
	private String update_by;
	private Timestamp create_date;
	private Date update_date;
	public TabAddrs(String id, String name, String create_by, String update_by, Timestamp create_date,
			Date update_date) {
		super();
		this.id = id;
		this.name = name;
		this.create_by = create_by;
		this.update_by = update_by;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public TabAddrs() {
		super();
	}
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
	@Override
	public String toString() {
		return "TabAddrs [id=" + id + ", name=" + name + ", create_by=" + create_by + ", update_by=" + update_by
				+ ", create_date=" + create_date + ", update_date=" + update_date + "]";
	}
	
	
}
