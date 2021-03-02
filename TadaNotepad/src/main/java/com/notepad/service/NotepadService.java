package com.notepad.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public interface NotepadService {
	
	public List<Map<String,Object>> notepadList(Map<String,Object> map) throws Exception;
	
	public int notepadListCount(Map<String,Object> map) throws Exception;
	
	public int notepadInsert(Map<String,Object> map) throws Exception;
	
	public int notepadUpdate(Map<String,Object> map) throws Exception;
	
	public int notepadDelete(long id) throws Exception;
}
