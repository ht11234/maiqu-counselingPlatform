package com.maiqu.counsel.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maiqu.commonutils.R;
import com.maiqu.counsel.entity.Psychologist;
import com.maiqu.counsel.service.PsyChologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/counsel/psychologist")
@CrossOrigin
public class PsychologistController {
    @Autowired
    private PsyChologistService psyChologistService;

    @PostMapping("addPsychologist")
    public R addUser(@RequestBody Psychologist psychologist) {
        boolean save = psyChologistService.save(psychologist);
        if (save) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    @DeleteMapping("{id}")
    public R removeUser(@PathVariable("id") String id) {
        boolean flag = psyChologistService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    @PostMapping("updatePsychologist")
    public R updateUser(@RequestBody Psychologist psychologist) {
        boolean flag = psyChologistService.updateById(psychologist);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    // 根据id进行查询
    @GetMapping("getPsychologist/{id}")
    public R getUser(@PathVariable("id") String id) {
        Psychologist psychologist = psyChologistService.getById(id);
        return R.ok().data("psychologist", psychologist);
    }

    // 查询所有数据
    @GetMapping("findAll")
    public R findAll() {
        List<Psychologist> psychologistList = psyChologistService.list(null);
        return R.ok().data("item", psychologistList);
    }


    // 分页查询的方法
    @GetMapping("pagePsychologist/{current}/{limit}")
    public R page(@PathVariable("current") long current, @PathVariable("limit") long limit) {
        Page<Psychologist> pagePsychologist = new Page<>(current, limit);
        psyChologistService.page(pagePsychologist, null);
        long total = pagePsychologist.getTotal();
        List<Psychologist> records = pagePsychologist.getRecords();
        Map map = new HashMap<>();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }

}
