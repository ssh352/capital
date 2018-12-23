package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.TickByTickDAO;
import com.bazinga.capital.model.TickByTick;
import com.bazinga.capital.query.TickByTickQuery;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.util.Assert;

 /**
  * 〈逐笔委托 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2018-12-22
  */
@Repository
public class TickByTickDAOImpl extends SqlSessionDaoSupport implements TickByTickDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.TickByTickDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(TickByTick record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public TickByTick selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(TickByTick record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<TickByTick> selectByCondition(TickByTickQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(TickByTickQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}