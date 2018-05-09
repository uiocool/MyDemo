package com.example.administrator.mydemo.entity;

import java.sql.Timestamp;
import java.util.Date;
/**
 *    应该是vip，  android已取消该功能
 * @author Administrator
 *
 */
public class TabVip {
	private String id;
	private String name;            //姓名
	private String sex;
	private int age;
	private String company_name;       //所属公司
	private String title;             //职位
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public TabVip(String id, String name, String sex, int age, String company_name, String title, String create_by,
			String update_by, Timestamp create_date, Date update_date) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.company_name = company_name;
		this.title = title;
		this.create_by = create_by;
		this.update_by = update_by;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public TabVip() {
		super();
	}
	@Override
	public String toString() {
		return "TabVip [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", company_name="
				+ company_name + ", title=" + title + ", create_by=" + create_by + ", update_by=" + update_by
				+ ", create_date=" + create_date + ", update_date=" + update_date + "]";
	}
	
	
}
