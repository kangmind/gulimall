package com.atguigu.gulimall.member.client;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("gulimall-coupon")
public interface CouponFeignClient {

    @GetMapping("/coupon/coupon/member/list")
    R listByMember();
}
