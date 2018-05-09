package com.example.administrator.mydemo.entity;

import java.sql.Timestamp;

/**
 * 
 * @author Administrator
 *
 */
public class AtVersion {
	private String id;
	private String version;
	private String name;
	private String developer;
	private Timestamp gx_date;
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
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public Timestamp getGx_date() {
		return gx_date;
	}
	public void setGx_date(Timestamp gx_date) {
		this.gx_date = gx_date;
	}
	public AtVersion(String id, String version, String name, String developer, Timestamp gx_date) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.developer = developer;
		this.gx_date = gx_date;
	}
	public AtVersion() {
		super();
	}
	@Override
	public String toString() {
		return "AtVersion [id=" + id + ", version=" + version + ", name=" + name + ", developer=" + developer
				+ ", gx_date=" + gx_date + ", getId()=" + getId() + ", getVersion()=" + getVersion() + ", getName()="
				+ getName() + ", getDeveloper()=" + getDeveloper() + ", getGx_date()=" + getGx_date() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
