package com.myclass.controller;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.HallDto;
import com.myclass.dto.UserDto;
import com.myclass.dto.UserHallDto;
import com.myclass.entity.Hall;
import com.myclass.entity.User;
import com.myclass.service.HallService;
import com.myclass.service.UserService;

@Controller
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private HallService hallService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("paging/{pageIndex}")
	public ResponseEntity<Page<Hall>> paging(@PathVariable int pageIndex){
		
		Page<Hall> hall = hallService.findAllPaging(pageIndex-1);
		if(hall.getSize()==0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Hall>>(hall,HttpStatus.OK);
	}
	
	@GetMapping("TimKiemTheoGia")
	public ResponseEntity<Page<Hall>> get(@RequestParam int priceStart,@RequestParam int priceEnd,@RequestParam int pageIndex) {
		
		Page<Hall> hall = hallService.findByPrice(priceStart,priceEnd,pageIndex-1);
		
		
		if(hall.getSize()==0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Hall>>(hall,HttpStatus.OK);
	
	}
	
	@GetMapping("search")
	public Object get(@RequestParam String name,@RequestParam int priceStart,@RequestParam int priceEnd,@RequestParam Date date ) {
	
		ArrayList<String> ListA = new ArrayList<String>();
		ArrayList<Object> ListB = new ArrayList<Object>();
		List<HallDto> hallDtoS = hallService.getByHall(ListA,ListB);
		return hallDtoS;
	}
	
	@PostMapping("DatTiec")
	public Object post( @RequestBody HallDto hallDto ) {
		try {
		
			return new ResponseEntity<Object>(HttpStatus.CREATED);
			} catch (Exception e) {
			e.printStackTrace();
			}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	
	
}
