package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.DisableInsertTicketDAO;
import com.bazinga.capital.model.DisableInsertTicket;
import com.bazinga.capital.query.DisableInsertTicketQuery;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
  * 〈DisableInsertTicket DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2019-01-09
  */
@Repository
public class DisableInsertTicketDAOImpl extends SqlSessionDaoSupport implements DisableInsertTicketDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.DisableInsertTicketDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(DisableInsertTicket record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public DisableInsertTicket selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(DisableInsertTicket record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<DisableInsertTicket> selectByCondition(DisableInsertTicketQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(DisableInsertTicketQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }

    @Override
    public DisableInsertTicket selectByTickerAndDay(Map<String,String> paramMap) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByTickerAndDay", paramMap);
    }

    @Override
    public int updateByTickerAndDay(DisableInsertTicket record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByTickerAndDay", record);
    }
}