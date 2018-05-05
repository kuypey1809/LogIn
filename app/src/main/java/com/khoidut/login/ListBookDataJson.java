package com.khoidut.login;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ListBookDataJson {
    private List<Book> data;
    private String first_page_url, last_page_url, prev_page_url, next_page_url, current_page, from, last_page, path, to, total;

    private Object links;

    private Object meta;

    public ListBookDataJson(String first_page_url, String last_page_url, String prev_page_url, String next_page_url, String current_page, String from, String last_page, String path, String to, String total) {
        this.first_page_url = first_page_url;
        this.last_page_url = last_page_url;
        this.prev_page_url = prev_page_url;
        this.next_page_url = next_page_url;
        this.current_page = current_page;
        this.from = from;
        this.last_page = last_page;
        this.path = path;
        this.to = to;
        this.total = total;
    }

    public String getFirst_page_url() {
        return first_page_url;
    }

    public void setFirst_page_url(String first_page_url) {
        this.first_page_url = first_page_url;
    }

    public String getLast_page_url() {
        return last_page_url;
    }

    public void setLast_page_url(String last_page_url) {
        this.last_page_url = last_page_url;
    }

    public String getPrev_page_url() {
        return prev_page_url;
    }

    public void setPrev_page_url(String prev_page_url) {
        this.prev_page_url = prev_page_url;
    }

    public String getNext_page_url() {
        return next_page_url;
    }

    public void setNext_page_url(String next_page_url) {
        this.next_page_url = next_page_url;
    }

    public String getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(String current_page) {
        this.current_page = current_page;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getLast_page() {
        return last_page;
    }

    public void setLast_page(String last_page) {
        this.last_page = last_page;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    //    public ListBookDataJson(List<Book> data) {
//        this.data = data;
//    }
//
//    public List<Book> getData() {
//        return data;
//    }
//
//    public void setData(Array data[]) {
//        System.out.println(data);
//
//        for (int i = 0; i <= data.length; i++) {
////            this.data.add(data[0][i]);
//            System.out.println(data[i]);
//        }
//
////        this.data = data;
//    }

    public List<Book> getData() {
        return this.data;
    }

    public void setData(List<Book> data) {
        this.data = data;
    }
};

