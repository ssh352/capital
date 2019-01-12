package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.CheckCancelOrderPoolDAO;
import com.bazinga.capital.model.CheckCancelOrderPool;
import com.bazinga.capital.query.CheckCancelOrderPoolQuery;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.util.Assert;

 /**
  * 〈撤单判断池 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2019-01-12
  */
@Repository
public class CheckCancelOrderPoolDAOImpl extends SqlSessionDaoSupport implements CheckCancelOrderPoolDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.CheckCancelOrderPoolDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(CheckCancelOrderPool record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public CheckCancelOrderPool selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(CheckCancelOrderPool record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<CheckCancelOrderPool> selectByCondition(CheckCancelOrderPoolQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(CheckCancelOrderPoolQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}