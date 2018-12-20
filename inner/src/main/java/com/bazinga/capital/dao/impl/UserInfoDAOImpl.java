package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.UserInfoDAO;
import com.bazinga.capital.model.UserInfo;
import com.bazinga.capital.query.UserInfoQuery;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.util.Assert;

 /**
  * 〈用户测试 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2018-12-20
  */
@Repository
public class UserInfoDAOImpl extends SqlSessionDaoSupport implements UserInfoDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.UserInfoDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(UserInfo record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<UserInfo> selectByCondition(UserInfoQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(UserInfoQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}