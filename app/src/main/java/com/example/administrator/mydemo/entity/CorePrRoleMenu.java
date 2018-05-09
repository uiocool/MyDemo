package com.example.administrator.mydemo.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * @author Administrator
 *        权限管理 。。。大概是吧
 */
public class CorePrRoleMenu {
	private String id;
	private String menu_id;               //菜单
	private String role_id;              //角色
	private String authority;             //权限
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
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
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
	public CorePrRoleMenu(String id, String menu_id, String role_id, String authority, String create_by,
			String update_by, Timestamp create_date, Date update_date) {
		super();
		this.id = id;
		this.menu_id = menu_id;
		this.role_id = role_id;
		this.authority = authority;
		this.create_by = create_by;
		this.update_by = update_by;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public CorePrRoleMenu() {
		super();
	}
	@Override
	public String toString() {
		return "CorePrRoleMenu [id=" + id + ", menu_id=" + menu_id + ", role_id=" + role_id + ", authority=" + authority
				+ ", create_by=" + create_by + ", update_by=" + update_by + ", create_date=" + create_date
				+ ", update_date=" + update_date + "]";
	}
	
	
}
