package com.notepad.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BaseDao {

	
	
	@Autowired
	private SqlSession sqlSession;

	public List<Map<String,Object>> selectList (String queryId, Map<String,Object> param) throws Exception{
		List<Map<String,Object>> list = sqlSession.selectList(queryId,param);
		return list;
	}
	
	
	public int selectInt (String queryId, Map<String,Object> param) throws Exception{
		return (Integer)sqlSession.selectOne(queryId,param);
	}
	
	public int insertitem (String queryId, Map<String,Object> param) throws Exception{
		return sqlSession.insert(queryId,param);
	}
	
	public int updateItem (String queryId, Map<String,Object> param) throws Exception{
		return sqlSession.update(queryId,param);
	}
	
	public int deleteItem (String queryId,long id) throws Exception{
		return sqlSession.delete(queryId,id);
	}
}