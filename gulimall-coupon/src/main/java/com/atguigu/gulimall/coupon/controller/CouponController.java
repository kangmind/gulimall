package com.atguigu.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.atguigu.gulimall.coupon.service.CouponService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;


/**
 * 优惠券信息
 *
 * @author kangmind
 * @email com.atguigu
 * @date 2022-08-24 22:13:13
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {


    @Autowired
    private CouponService couponService;


    @Value("${coupon.user.name}")
    private String username;

    @Value("${coupon.user.age}")
    private Integer userAge;

    @GetMapping("/test")
    public R test() {
        return R.ok().put("username", username)
                .put("userAge", userAge);
    }


    /**
     * 模拟返回某会员的优惠券
     *
     * @return
     */
    @RequestMapping("/member/list")
    public R listByMember() {
        CouponEntity couponEntity = CouponEntity.builder().couponName("满十减一").build();
        List<CouponEntity> couponEntities = Arrays.asList(couponEntity);
        return R.ok().put("coupons", couponEntities);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public R info(@PathVariable("id") Long id) {
        CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon) {
        couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon) {
        couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("coupon:coupon:delete")
    public R delete(@RequestBody Long[] ids) {
        couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
