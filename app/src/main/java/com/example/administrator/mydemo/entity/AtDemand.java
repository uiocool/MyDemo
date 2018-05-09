package com.example.administrator.mydemo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * 
 * @author Administrator
 *
 */
public class AtDemand {
	private String id;
	private String kind;
	private String title;
	private String content;
	private BigDecimal price;
	private String area;
	private Timestamp create_date;
	private String img;
	private String con_people;
	private String con_phone;
	private int demand;
	private String userId;
	private String login_name;
	private String userName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCon_people() {
		return con_people;
	}
	public void setCon_people(String con_people) {
		this.con_people = con_people;
	}
	public String getCon_phone() {
		return con_phone;
	}
	public void setCon_phone(String con_phone) {
		this.con_phone = con_phone;
	}
	public int getDemand() {
		return demand;
	}
	public void setDemand(int demand) {
		this.demand = demand;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public AtDemand(String id, String kind, String title, String content, BigDecimal price, String area,
			Timestamp create_date, String img, String con_people, String con_phone, int demand, String userId,
			String login_name, String userName) {
		super();
		this.id = id;
		this.kind = kind;
		this.title = title;
		this.content = content;
		this.price = price;
		this.area = area;
		this.create_date = create_date;
		this.img = img;
		this.con_people = con_people;
		this.con_phone = con_phone;
		this.demand = demand;
		this.userId = userId;
		this.login_name = login_name;
		this.userName = userName;
	}
	public AtDemand() {
		super();
	}
	@Override
	public String toString() {
		return "AtDemand [id=" + id + ", kind=" + kind + ", title=" + title + ", content=" + content + ", price="
				+ price + ", area=" + area + ", create_date=" + create_date + ", img=" + img + ", con_people="
				+ con_people + ", con_phone=" + con_phone + ", demand=" + demand + ", userId=" + userId
				+ ", login_name=" + login_name + ", userName=" + userName + "]";
	}
	
	
}
