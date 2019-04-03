package com.yh.fxmall.mapper;

import com.yh.fxmall.entity.WxbGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List<WxbGood> selectGoodsByPage(@Param("index") Integer index, @Param("size") Integer size);

    void insertGoods(@Param("wxbGood") WxbGood wxbGood);
}
