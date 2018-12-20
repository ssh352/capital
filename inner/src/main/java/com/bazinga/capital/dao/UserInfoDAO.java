package com.bazinga.capital.dao;

import com.bazinga.capital.model.UserInfo;
import com.bazinga.capital.query.UserInfoQuery;

import java.util.List;

/**
 * 〈用户测试 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-20
 */
public interface UserInfoDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(UserInfo record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    UserInfo selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<UserInfo> selectByCondition(UserInfoQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(UserInfoQuery query);

}