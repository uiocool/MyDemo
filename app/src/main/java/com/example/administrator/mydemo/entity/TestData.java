package com.example.administrator.mydemo.entity;

public class TestData {
    private int id;
    private String title;
    private String customer;

    public TestData(int id, String title, String customer) {
        this.id = id;
        this.title = title;
        this.customer = customer;
    }

    public TestData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}
