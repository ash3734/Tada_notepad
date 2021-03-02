package com.notepad.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


@Repository
public class NotepadDao extends BaseDao{
	public List<Map<String,Object>> notepadList(Map<String,Object> map) throws Exception{
		return selectList("notepad.notepadList",map);
	}
	
	public int notepadListCount(Map<String,Object> map) throws  Exception{
		return selectInt("notepad.notepadListCount",map);
	}
	
	public int notepadInsertItem ( Map<String,Object> param) throws Exception{
		return insertitem("notepad.notepadInsert",param);
	}
	
	public int notepadUpdateItem ( Map<String,Object> param) throws Exception{
		return updateItem("notepad.notepadUdate",param);
	}
	
	public int notepadDeleteItem ( long id) throws Exception{
		return deleteItem("notepad.notepadDelete",id);
	}

}
