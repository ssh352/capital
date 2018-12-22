package com.bazinga.capital.api;

import com.bazinga.capital.model.UserInfo;
import com.bazinga.capital.query.UserInfoQuery;

import java.util.List;

/**
 * 〈用户测试 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-20
 */
public interface UserInfoService {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    UserInfo save(UserInfo record);

    /**
     * 根据ID查询
     *
     * @param id 数据库ID
     */
    UserInfo getById(Integer id);

    /**
     * 根据id更新一条数据
     *
     * @param record 更新参数
     */
    int updateById(UserInfo record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<UserInfo> listByCondition(UserInfoQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    int countByCondition(UserInfoQuery query);
}