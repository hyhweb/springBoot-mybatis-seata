package com.springboot.storageservice.dao;

import com.springboot.storageservice.entity.Storage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Storage)表数据库访问层
 *
 * @author hyhong
 * @since 2020-06-30 18:02:32
 */
public interface StorageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Storage queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Storage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param storage 实例对象
     * @return 对象列表
     */
    List<Storage> queryAll(Storage storage);

    /**
     * 新增数据
     *
     * @param storage 实例对象
     * @return 影响行数
     */
    int insert(Storage storage);

    /**
     * 修改数据
     *
     * @param storage 实例对象
     * @return 影响行数
     */
    int update(Storage storage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
