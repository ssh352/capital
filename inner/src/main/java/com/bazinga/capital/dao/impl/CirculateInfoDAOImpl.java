package com.bazinga.capital.dao.impl;

import com.bazinga.capital.dao.CirculateInfoDAO;
import com.bazinga.capital.model.CirculateInfo;
import com.bazinga.capital.query.CirculateInfoQuery;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

 /**
  * 〈流通信息 DAO〉<p>
  * 〈功能详细描述〉
  *
  * @author
  * @date 2018-12-28
  */
@Repository
public class CirculateInfoDAOImpl extends SqlSessionDaoSupport implements CirculateInfoDAO {

    private final String MAPPER_NAME = "com.bazinga.capital.dao.CirculateInfoDAO";

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int insert(CirculateInfo record) {
        return this.getSqlSession().insert( MAPPER_NAME + ".insert", record);
    }

    @Override
    public CirculateInfo selectByPrimaryKey(Integer id) {
        return this.getSqlSession().selectOne( MAPPER_NAME + ".selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(CirculateInfo record) {
        return this.getSqlSession().update( MAPPER_NAME + ".updateByPrimaryKeySelective", record);
    }

    @Override
    public List<CirculateInfo> selectByCondition(CirculateInfoQuery query) {
        return this.getSqlSession().selectList( MAPPER_NAME + ".selectByCondition", query);
    }

    @Override
    public Integer countByCondition(CirculateInfoQuery query) {
        return (Integer)this.getSqlSession().selectOne( MAPPER_NAME + ".countByCondition", query);
    }
}