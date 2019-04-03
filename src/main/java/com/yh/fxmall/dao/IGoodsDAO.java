package com.yh.fxmall.dao;

import com.yh.fxmall.entity.WxbGood;

import java.util.List;

public interface IGoodsDAO {

    List<WxbGood> selectGoodsByPage(Integer page);

    void insertGoods(WxbGood wxbGood);
}
