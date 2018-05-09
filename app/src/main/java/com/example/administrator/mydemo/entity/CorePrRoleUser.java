package com.example.administrator.mydemo.entity;

import java.sql.Timestamp;
import java.util.Date;
/**
 * 
 * @author Administrator
 *        应该没什么用吧
 */
public class CorePrRoleUser {
	private String id;
	private String role_id;                    //角色
	private String user_id;                   //用户
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
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public CorePrRoleUser(String id, String role_id, String user_id, String create_by, String update_by,
			Timestamp create_date, Date update_date) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.user_id = user_id;
		this.create_by = create_by;
		this.update_by = update_by;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public CorePrRoleUser() {
		super();
	}
	@Override
	public String toString() {
		return "CorePrRoleUser [id=" + id + ", role_id=" + role_id + ", user_id=" + user_id + ", create_by=" + create_by
				+ ", update_by=" + update_by + ", create_date=" + create_date + ", update_date=" + update_date + "]";
	}
	
	
}
