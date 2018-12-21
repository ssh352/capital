package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.TicketInfoDAO;
import com.bazinga.capital.model.TicketInfo;
import com.bazinga.capital.query.TicketInfoQuery;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.util.Assert;

 /**
  * 〈股票信息 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2018-12-21
  */
@Repository
public class TicketInfoDAOImpl extends SqlSessionDaoSupport implements TicketInfoDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.TicketInfoDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(TicketInfo record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public TicketInfo selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(TicketInfo record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<TicketInfo> selectByCondition(TicketInfoQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(TicketInfoQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}