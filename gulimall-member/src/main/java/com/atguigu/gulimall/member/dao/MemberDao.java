package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author kangmind
 * @email com.atguigu
 * @date 2022-08-24 22:25:40
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}