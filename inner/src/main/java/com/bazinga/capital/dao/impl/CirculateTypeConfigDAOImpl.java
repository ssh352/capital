package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.CirculateTypeConfigDAO;
import com.bazinga.capital.model.CirculateTypeConfig;
import com.bazinga.capital.query.CirculateTypeConfigQuery;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.util.Assert;

 /**
  * 〈股票类型配置信息 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2019-01-06
  */
@Repository
public class CirculateTypeConfigDAOImpl extends SqlSessionDaoSupport implements CirculateTypeConfigDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.CirculateTypeConfigDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(CirculateTypeConfig record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public CirculateTypeConfig selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(CirculateTypeConfig record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<CirculateTypeConfig> selectByCondition(CirculateTypeConfigQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(CirculateTypeConfigQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}