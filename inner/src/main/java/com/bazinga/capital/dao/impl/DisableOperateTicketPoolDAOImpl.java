package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.DisableOperateTicketPoolDAO;
import com.bazinga.capital.model.DisableOperateTicketPool;
import com.bazinga.capital.query.DisableOperateTicketPoolQuery;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

 /**
  * 〈禁止操作池 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2019-01-12
  */
@Repository
public class DisableOperateTicketPoolDAOImpl extends SqlSessionDaoSupport implements DisableOperateTicketPoolDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.DisableOperateTicketPoolDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(DisableOperateTicketPool record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public DisableOperateTicketPool selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

     @Override
     public DisableOperateTicketPool selectByTickerAndDay(Map<String, String> paramMap) {
         return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByTickerAndDay", paramMap);
     }

     @Override
     public int updateByTickerAndDay(DisableOperateTicketPool record) {
         return this.getSqlSession().update( MAPPER_NAME + ".updateByTickerAndDay", record);
     }

     @Override
    public int updateByPrimaryKeySelective(DisableOperateTicketPool record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<DisableOperateTicketPool> selectByCondition(DisableOperateTicketPoolQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(DisableOperateTicketPoolQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}