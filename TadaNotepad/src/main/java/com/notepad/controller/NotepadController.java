package com.notepad.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.notepad.service.NotepadService;

@RestController
public class NotepadController {

	@Autowired
	private NotepadService notepadService;

	/* 
	 * 메모장 리스트 조회
	 * param : id, create_id, string, created_start, created_end
	 * return : List 
	 */
	@RequestMapping(value = "/notepad/notepadList")
	public List<Map<String,Object>> notepadList(@RequestParam Map<String,Object> param) throws Exception{
		return notepadService.notepadList(param);
	}

	/*
	 * 메모장 리스트 삽입
	 * body : create_id, memo
	 * return : 성공 : suecess, 실패 : error when insert
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/notepad/notepadInsert")
	public String notepadInsert(@RequestBody Map<String,Object> param) throws Exception{
		int rst = notepadService.notepadInsert(param);
		System.out.println("rst "+rst);
		if(rst==1) {
			return "suscess";
		}else if(rst==0){
			return "error when insert";
		}else {
			return "something error";
		}
	}
	
	/*
	 * 메모장 리스트 업데이트 
	 *body : id, memo
	 *return : 성공 : suecess, 실패 : error when update
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/notepad/notepadUpdate")
	public String notepadUpdate(@RequestBody Map<String,Object> param) throws Exception{
		int rst = notepadService.notepadUpdate(param);
		if(rst==1) {
			return "suscess";
		}else if(rst==0){
			return "error when update";
		}else if(rst==-1){
			return "id is reqired";
		}else {
			return "something error";
		}
		
	}

	/*
	 * 메모장 리스트 삭제
	 * param : id
	 * return : 성공 : suecess, 실패 : error when delete
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/notepad/notepadDelete")
	public String notepadDelete(@RequestParam long id) throws Exception{
		int rst = notepadService.notepadDelete(id);
		if(rst==1) {
			return "suscess";
		}else if(rst==0){
			return "error when delete";
		}else {
			return "something error";
		}
	}
	
}
