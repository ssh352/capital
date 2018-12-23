package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.OrderInfoDAO;
import com.bazinga.capital.model.OrderInfo;
import com.bazinga.capital.query.OrderInfoQuery;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.util.Assert;

 /**
  * 〈订单信息 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2018-12-22
  */
@Repository
public class OrderInfoDAOImpl extends SqlSessionDaoSupport implements OrderInfoDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.OrderInfoDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(OrderInfo record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public OrderInfo selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInfo record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<OrderInfo> selectByCondition(OrderInfoQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(OrderInfoQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}