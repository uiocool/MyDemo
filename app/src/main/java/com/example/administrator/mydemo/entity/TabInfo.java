package com.example.administrator.mydemo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
/**
 * 
 * @author Administrator
 *        似乎跟我想的不一样
 */
public class TabInfo {
	private String id;
	private String type_id;           //类别
	private String obj_id;             //对象
	private String addrs_id;            //地区
	private String fw;                   //范围
	private BigDecimal price;             //价格
	private Date times;             //推送时间
	private Date end_times;          //结束时间
	private int number;                 //推送数量
	private String content;           //同下一个字段一样不知所谓
	private String file;
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
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getObj_id() {
		return obj_id;
	}
	public void setObj_id(String obj_id) {
		this.obj_id = obj_id;
	}
	public String getAddrs_id() {
		return addrs_id;
	}
	public void setAddrs_id(String addrs_id) {
		this.addrs_id = addrs_id;
	}
	public String getFw() {
		return fw;
	}
	public void setFw(String fw) {
		this.fw = fw;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
	}
	public Date getEnd_times() {
		return end_times;
	}
	public void setEnd_times(Date end_times) {
		this.end_times = end_times;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	public TabInfo(String id, String type_id, String obj_id, String addrs_id, String fw, BigDecimal price, Date times,
			Date end_times, int number, String content, String file, String create_by, String update_by,
			Timestamp create_date, Date update_date) {
		super();
		this.id = id;
		this.type_id = type_id;
		this.obj_id = obj_id;
		this.addrs_id = addrs_id;
		this.fw = fw;
		this.price = price;
		this.times = times;
		this.end_times = end_times;
		this.number = number;
		this.content = content;
		this.file = file;
		this.create_by = create_by;
		this.update_by = update_by;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public TabInfo() {
		super();
	}
	@Override
	public String toString() {
		return "TabInfo [id=" + id + ", type_id=" + type_id + ", obj_id=" + obj_id + ", addrs_id=" + addrs_id + ", fw="
				+ fw + ", price=" + price + ", times=" + times + ", end_times=" + end_times + ", number=" + number
				+ ", content=" + content + ", file=" + file + ", create_by=" + create_by + ", update_by=" + update_by
				+ ", create_date=" + create_date + ", update_date=" + update_date + "]";
	}
	
	
}
