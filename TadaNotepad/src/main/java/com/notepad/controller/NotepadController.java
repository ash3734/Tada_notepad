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

	@RequestMapping(value = "/notepad/notepadList")
	public List<Map<String,Object>> notepadList(@RequestParam Map<String,Object> param) throws Exception{
		return notepadService.notepadList(param);
	}
	
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
	
	@RequestMapping(method = RequestMethod.PUT, value = "/notepad/notepadUpdate")
	public String notepadUpdate(@RequestBody Map<String,Object> param) throws Exception{
		int rst = notepadService.notepadUpdate(param);
		if(rst==1) {
			return "suscess";
		}else if(rst==0){
			return "error when insert";
		}else if(rst==-1){
			return "id is reqired";
		}else {
			return "something error";
		}
		
	}
	
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
