package com.example.administrator.mydemo.entity;

import java.sql.Timestamp;
import java.util.Date;
/**
 *          版本管理 android另外建表
 * @author Administrator
 *
 */
public class TabVersion {
	private String id;
	private String version;        //版本号
	private String name;              //版本名称
	private String content;          //更新内容
	private String sf_qz;            //是否强制更新
	private Date end_time;          //更新截止时间
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	public String getSf_qz() {
		return sf_qz;
	}
	public void setSf_qz(String sf_qz) {
		this.sf_qz = sf_qz;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
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
	public TabVersion(String id, String version, String name, String content, String sf_qz, Date end_time,
			String create_by, String update_by, Timestamp create_date, Date update_date) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.content = content;
		this.sf_qz = sf_qz;
		this.end_time = end_time;
		this.create_by = create_by;
		this.update_by = update_by;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public TabVersion() {
		super();
	}
	@Override
	public String toString() {
		return "TabVersion [id=" + id + ", version=" + version + ", name=" + name + ", content=" + content + ", sf_qz="
				+ sf_qz + ", end_time=" + end_time + ", create_by=" + create_by + ", update_by=" + update_by
				+ ", create_date=" + create_date + ", update_date=" + update_date + "]";
	}
	
	
}
