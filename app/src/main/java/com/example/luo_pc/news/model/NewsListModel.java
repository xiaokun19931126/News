package com.example.luo_pc.news.model;

/**
 * Created by Luo_xiasuhuei321@163.com on 2016/9/6.
 */
public interface NewsListModel<T> {
    T getNews(int pageIndex, String type);
}
