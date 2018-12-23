package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.TickByTickEntrustDAO;
import com.bazinga.capital.model.TickByTickEntrust;
import com.bazinga.capital.query.TickByTickEntrustQuery;

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
public class TickByTickEntrustDAOImpl extends SqlSessionDaoSupport implements TickByTickEntrustDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.TickByTickEntrustDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(TickByTickEntrust record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public TickByTickEntrust selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(TickByTickEntrust record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<TickByTickEntrust> selectByCondition(TickByTickEntrustQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(TickByTickEntrustQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}