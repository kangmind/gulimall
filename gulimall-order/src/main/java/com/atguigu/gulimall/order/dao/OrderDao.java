package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author kangmind
 * @email com.atguigu
 * @date 2022-08-24 22:20:53
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
