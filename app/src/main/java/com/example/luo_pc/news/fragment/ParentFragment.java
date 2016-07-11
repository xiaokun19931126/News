package com.example.luo_pc.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.luo_pc.news.R;
import com.example.luo_pc.news.adapter.mPagerAdapter;
import com.example.luo_pc.news.bean.NewsBean;
import com.example.luo_pc.news.utils.Urls;

import java.util.ArrayList;

/**
 * Created by luo-pc on 2016/5/15.
 */
public class ParentFragment extends Fragment {

    public static final int NEWS_TYPE_TOP = 0;
    public static final int NEWS_TYPE_SPORT = 1;
    public static final int NEWS_TYPE_GAME = 2;
    public static final int NEWS_TYPE_JOKES = 3;

    private ViewPager vp_content;
    private TabLayout tab_title;
    private ArrayList<String> titleList;
    private ArrayList<NewsBean> allnews = new ArrayList<>();
    private ArrayList<Fragment> fragmentList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, null);

        initView(view);
        initData();
        vp_content.setOffscreenPageLimit(3);
        vp_content.setAdapter(new mPagerAdapter(getChildFragmentManager(), fragmentList, titleList));
        tab_title.setupWithViewPager(vp_content);

        return view;
    }

    private void initData() {
        titleList = new ArrayList<>();
        titleList.add("头条");
        titleList.add("NBA");
        titleList.add("汽车");
        titleList.add("笑话");

        NewsListFragment hotNewsList = new NewsListFragment(Urls.TOP_ID);
        NewsListFragment sportNewsList = new NewsListFragment(Urls.NBA_ID);
        NewsListFragment carNewsList = new NewsListFragment(Urls.CAR_ID);
        NewsListFragment jokeNewsList = new NewsListFragment(Urls.JOKE_ID);

        fragmentList.add(hotNewsList);
        fragmentList.add(sportNewsList);
        fragmentList.add(carNewsList);
        fragmentList.add(jokeNewsList);

    }

    private void initView(View view) {
        tab_title = (TabLayout) view.findViewById(R.id.tab_title);
        vp_content = (ViewPager) view.findViewById(R.id.vp_content);
    }





}