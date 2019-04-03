package com.yh.fxmall.service.impl;

import com.yh.fxmall.dao.IGoodsDAO;
import com.yh.fxmall.entity.WxbGood;
import com.yh.fxmall.service.IGoodsService;
import com.yh.fxmall.utils.SystemConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GoodsServiceImpl implements IGoodsService {


    @Autowired
    private IGoodsDAO goodsDAO ;




    @Override
    public List<WxbGood> selectGoodsByPage(Integer page) {
        if (page < 1){
            throw new IndexOutOfBoundsException("页码不能小于1");
        }
        //计算起始下标
        int index = (page-1)* SystemConstantsUtils.Page.PAGE_SIZE;
        List<WxbGood> goods = goodsDAO.selectGoodsByPage(page);
        return goods;
    }

    @Override
    public void insertGoods(WxbGood wxbGood) {

    }


}
