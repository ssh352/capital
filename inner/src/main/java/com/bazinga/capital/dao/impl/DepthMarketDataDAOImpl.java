package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.DepthMarketDataDAO;
import com.bazinga.capital.model.DepthMarketData;
import com.bazinga.capital.query.DepthMarketDataQuery;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.util.Assert;

 /**
  * 〈普通行情 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2018-12-21
  */
@Repository
public class DepthMarketDataDAOImpl extends SqlSessionDaoSupport implements DepthMarketDataDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.DepthMarketDataDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(DepthMarketData record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public DepthMarketData selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(DepthMarketData record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<DepthMarketData> selectByCondition(DepthMarketDataQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(DepthMarketDataQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}