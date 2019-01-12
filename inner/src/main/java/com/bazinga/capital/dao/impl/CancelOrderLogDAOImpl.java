package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.CancelOrderLogDAO;
import com.bazinga.capital.model.CancelOrderLog;
import com.bazinga.capital.query.CancelOrderLogQuery;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.util.Assert;

 /**
  * 〈撤单日志 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2019-01-12
  */
@Repository
public class CancelOrderLogDAOImpl extends SqlSessionDaoSupport implements CancelOrderLogDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.CancelOrderLogDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(CancelOrderLog record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public CancelOrderLog selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(CancelOrderLog record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<CancelOrderLog> selectByCondition(CancelOrderLogQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(CancelOrderLogQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}