package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.CapitalOrderInfoDAO;
import com.bazinga.capital.model.CapitalOrderInfo;
import com.bazinga.capital.query.CapitalOrderInfoQuery;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.util.Assert;

 /**
  * 〈本地订单信息 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2019-01-06
  */
@Repository
public class CapitalOrderInfoDAOImpl extends SqlSessionDaoSupport implements CapitalOrderInfoDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.CapitalOrderInfoDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(CapitalOrderInfo record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public CapitalOrderInfo selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(CapitalOrderInfo record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<CapitalOrderInfo> selectByCondition(CapitalOrderInfoQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(CapitalOrderInfoQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}