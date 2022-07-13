package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author kangmind
 * @email com.atguigu
 * @date 2022-07-14 02:09:15
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
