package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.AssetDAO;
import com.bazinga.capital.model.Asset;
import com.bazinga.capital.query.AssetQuery;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.util.Assert;

 /**
  * 〈资产 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2018-12-22
  */
@Repository
public class AssetDAOImpl extends SqlSessionDaoSupport implements AssetDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.AssetDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(Asset record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public Asset selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(Asset record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<Asset> selectByCondition(AssetQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(AssetQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}