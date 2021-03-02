package com.notepad.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepad.dao.NotepadDao;
import com.notepad.service.NotepadService;

@Service
public class NotepadServiceImpl implements NotepadService{
	
	@Autowired
	private NotepadDao notepadDao;
	
	public List<Map<String,Object>> notepadList(Map<String,Object> map) throws Exception{
		return notepadDao.notepadList(map);
	}
	
	public int notepadListCount(Map<String,Object> map) throws Exception{
		return notepadDao.notepadListCount(map);
	}
	
	public int notepadInsert(Map<String,Object> map) throws Exception{
		if(map.get("create_id")==null) {
			return -1;
		}
		return notepadDao.notepadInsertItem(map);
	}
	
	public int notepadUpdate(Map<String,Object> map) throws Exception{
		if(map.get("id")==null) {
			return -1;
		}
		return notepadDao.notepadUpdateItem(map);
	}
	
	public int notepadDelete(long id) throws Exception{
		return notepadDao.notepadDeleteItem(id);
	}
}
