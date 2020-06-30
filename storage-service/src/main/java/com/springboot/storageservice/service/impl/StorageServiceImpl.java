package com.springboot.storageservice.service.impl;

import com.springboot.storageservice.entity.Storage;
import com.springboot.storageservice.dao.StorageDao;
import com.springboot.storageservice.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Storage)表服务实现类
 *
 * @author hyhong
 * @since 2020-06-30 18:02:32
 */
@Service("storageService")
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Storage queryById(Long id) {
        return this.storageDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Storage> queryAllByLimit(int offset, int limit) {
        return this.storageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param storage 实例对象
     * @return 实例对象
     */
    @Override
    public Storage insert(Storage storage) {
        this.storageDao.insert(storage);
        return storage;
    }

    /**
     * 修改数据
     *
     * @param storage 实例对象
     * @return 实例对象
     */
    @Override
    public Storage update(Storage storage) {
        this.storageDao.update(storage);
        return this.queryById(storage.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.storageDao.deleteById(id) > 0;
    }
}