package com.atguigu.gulimall.product.service.impl;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listTree() {
        List<CategoryEntity> list = list();
        List<CategoryEntity> collect = list.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .sorted(Comparator.comparing(CategoryEntity::getSort))
                .map(categoryEntity -> {
                    categoryEntity.setChildren(buildChildren(list, categoryEntity));
                    return categoryEntity;
                })
                .collect(Collectors.toList());


        return collect;
    }

    private List<CategoryEntity> buildChildren(List<CategoryEntity> list, CategoryEntity current) {
        List<CategoryEntity> children = list.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid().compareTo(current.getCatId()) == 0)
                .map(entity -> {
                    entity.setChildren(buildChildren(list, entity));
                    return entity;
                })
                .sorted(Comparator.comparing(CategoryEntity::getSort))
                .collect(Collectors.toList());


        return children;
    }

}