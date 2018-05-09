package com.example.administrator.mydemo.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * @author Administrator
 *         用户信息表
 *
 */
public class TabAccount {
	private String id;                               //自动生成
	private String login_name;                       //登录账号
	private String userName; 
	private String imgPath;                          //图片地址
	private String password;
	private String sex;
	private int age;
	private String likes;                            //喜好
	private String city;                             
	private String content;                          //个人介绍
	private String type;                //不明白
	private String create_by;             //创建人， 不懂
	private String update_by;             //修改人，  大概是管理员操作用的，与我无关
	private Timestamp create_date;            //创建时间，也许是自己
	private Date update_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public TabAccount(String id, String login_name, String userName, String imgPath, String password, String sex,
			int age, String likes, String city, String content, String type, String create_by, String update_by,
			Timestamp create_date, Date update_date) {
		super();
		this.id = id;
		this.login_name = login_name;
		this.userName = userName;
		this.imgPath = imgPath;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.likes = likes;
		this.city = city;
		this.content = content;
		this.type = type;
		this.create_by = create_by;
		this.update_by = update_by;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public TabAccount() {
		super();
	}
	@Override
	public String toString() {
		return "TabAccount [id=" + id + ", login_name=" + login_name + ", userName=" + userName + ", imgPath=" + imgPath
				+ ", password=" + password + ", sex=" + sex + ", age=" + age + ", likes=" + likes + ", city=" + city
				+ ", content=" + content + ", type=" + type + ", create_by=" + create_by + ", update_by=" + update_by
				+ ", create_date=" + create_date + ", update_date=" + update_date + "]";
	}
}
