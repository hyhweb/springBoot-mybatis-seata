package com.springboot.storageservice.controller;

import com.springboot.storageservice.entity.Storage;
import com.springboot.storageservice.service.StorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Storage)表控制层
 *
 * @author hyhong
 * @since 2020-06-30 18:02:32
 */
@RestController
@RequestMapping("storage")
public class StorageController {
    /**
     * 服务对象
     */
    @Resource
    private StorageService storageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Storage selectOne(Long id) {
        return this.storageService.queryById(id);
    }

}