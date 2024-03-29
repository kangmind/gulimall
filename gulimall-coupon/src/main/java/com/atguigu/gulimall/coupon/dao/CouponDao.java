package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author kangmind
 * @email com.atguigu
 * @date 2022-08-24 22:13:13
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
