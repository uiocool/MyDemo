package com.example.administrator.mydemo.entity;

import java.sql.Timestamp;
import java.util.Date;
/**
 * 
 * @author Administrator
 *          用途未知
 */
public class CoreDd {
	private String id;
	private String valueStr;         //value
	private String typeStr;          //类型
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
	public String getValueStr() {
		return valueStr;
	}
	public void setValueStr(String valueStr) {
		this.valueStr = valueStr;
	}
	public String getTypeStr() {
		return typeStr;
	}
	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
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
	public CoreDd(String id, String valueStr, String typeStr, String create_by, String update_by, Timestamp create_date,
			Date update_date) {
		super();
		this.id = id;
		this.valueStr = valueStr;
		this.typeStr = typeStr;
		this.create_by = create_by;
		this.update_by = update_by;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public CoreDd() {
		super();
	}
	@Override
	public String toString() {
		return "CoreDd [id=" + id + ", valueStr=" + valueStr + ", typeStr=" + typeStr + ", create_by=" + create_by
				+ ", update_by=" + update_by + ", create_date=" + create_date + ", update_date=" + update_date + "]";
	}
	
	
}
