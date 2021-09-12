package com.example.demo.dao;

import com.example.demo.model.Activity;
import com.example.demo.model.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @author Peter
 */
@Mapper
public interface StudentDao {
    /**
     * 搜索
     *
     * @param tableName 搜索表名
     * @param type       搜索类型
     * @param content   搜索值
     * @return 查询到结果的list
     */
    List<Map<String, Object>> search(String tableName, String type, String content);

    /**
     * 新增活动
     *
     * @param activity 实例化一个活动对象
     * @return activity对象
     */
    int insertActivity(Activity activity);

    /**
     * 新增人员
     *
     * @param people 实例化一个人员对象
     * @return people对象
     */
    int insertPeople(People people);

    /**
     * 删除
     *
     * @param uuid      用户的id
     * @param tableName 删除的表名
     * @return 用户id和删除表名
     */
    int delete(String uuid, String tableName);

    /**
     * 修改人员
     *
     * @param people 实例化一个人员对象
     * @return people对象
     */
    int updatePeople(People people);

    /**
     * 修改活动
     *
     * @param activity 实例化一个活动对象
     * @return activity对象
     */
    int updateActivity(Activity activity);

    /**
     * 查询
     *
     * @param tablesName 查询的表名
     * @return 查询到结果的list
     */
    List<Map<String, Object>> query(@Param(value = "tablesName") String tablesName);

    /**
     * 单个查询
     *
     * @param tableName 查询的表名
     * @param name      查询条件
     * @return 查询到结果的list
     */
    List<Map<String, Object>> stuQuery(String tableName, String name);
}
