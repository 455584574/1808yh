package com.yh.fxmall.dao.impl;

import com.yh.fxmall.dao.IGoodsDAO;
import com.yh.fxmall.entity.WxbGood;
import com.yh.fxmall.mapper.GoodsMapper;
import com.yh.fxmall.utils.MyBatisSessionFactoryUtils;
import com.yh.fxmall.utils.SystemConstantsUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GoodsDAOImpl implements IGoodsDAO {


    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<WxbGood> selectGoodsByPage(Integer page) {
        GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
        List<WxbGood> goodList = goodsMapper.selectGoodsByPage((page-1)*SystemConstantsUtils.Page.PAGE_SIZE,
                SystemConstantsUtils.Page.PAGE_SIZE);
        return goodList;
    }

    @Override
    public void insertGoods(WxbGood wxbGood) {
        GoodsMapper goodsMapper = MyBatisSessionFactoryUtils.getSession().getMapper(GoodsMapper.class);
        goodsMapper.insertGoods(wxbGood);
    }


}
