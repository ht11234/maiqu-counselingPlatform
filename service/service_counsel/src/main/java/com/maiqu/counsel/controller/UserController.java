package com.maiqu.counsel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maiqu.commonutils.R;
import com.maiqu.counsel.entity.CounselUser;
import com.maiqu.counsel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/counsel/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    public R addUser(@RequestBody CounselUser counselUser) {
        boolean save = userService.save(counselUser);
        if (save) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    @DeleteMapping("{id}")
    public R removeUser(@PathVariable("id") String id) {
        boolean flag = userService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    @PostMapping("updateUser")
    public R updateUser(@RequestBody CounselUser counselUser) {
        boolean flag = userService.updateById(counselUser);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    // 根据id进行查询
    @GetMapping("getUser/{id}")
    public R getUser(@PathVariable("id") String id) {
        CounselUser user = userService.getById(id);
        return R.ok().data("user", user);
    }

    // 查询所有数据
    @GetMapping("findAll")
    public R findAll() {
        List<CounselUser> userList = userService.list(null);
        return R.ok().data("item", userList);
    }


    // 分页查询的方法
    @GetMapping("pageUser/{current}/{limit}")
    public R page(@PathVariable("current") long current, @PathVariable("limit") long limit) {
        Page<CounselUser> pageUser = new Page<>(current, limit);
        userService.page(pageUser, null);
        long total = pageUser.getTotal();
        List<CounselUser> records = pageUser.getRecords();
        Map map = new HashMap<>();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }

}
