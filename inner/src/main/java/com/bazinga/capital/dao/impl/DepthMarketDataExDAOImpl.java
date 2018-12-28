package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.DepthMarketDataExDAO;
import com.bazinga.capital.model.DepthMarketDataEx;
import com.bazinga.capital.query.DepthMarketDataExQuery;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

 /**
  * 〈买一买一信息 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2018-12-28
  */
@Repository
public class DepthMarketDataExDAOImpl extends SqlSessionDaoSupport implements DepthMarketDataExDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.DepthMarketDataExDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(DepthMarketDataEx record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public DepthMarketDataEx selectByPrimaryKey(Long id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(DepthMarketDataEx record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<DepthMarketDataEx> selectByCondition(DepthMarketDataExQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(DepthMarketDataExQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}