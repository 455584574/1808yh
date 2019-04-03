package com.yh.fxmall.service;

import com.yh.fxmall.entity.WxbGood;

import java.util.List;

public interface IGoodsService {

    List<WxbGood> selectGoodsByPage(Integer page);

    void insertGoods(WxbGood wxbGood);
}
