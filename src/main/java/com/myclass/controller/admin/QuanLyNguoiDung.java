package com.myclass.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myclass.dto.LoginDto;
import com.myclass.dto.RoleDto;
import com.myclass.dto.UserDto;
import com.myclass.entity.Hall;
import com.myclass.entity.User;
import com.myclass.service.AuthService;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;



@Controller
@RequestMapping(value = "api/QuanLyNguoiDung" , produces={"application/json","*/*"})
public class QuanLyNguoiDung {
	
	@Autowired
	private UserService userService;
	@Autowired
	private AuthService authService;
	@Autowired
	private RoleService roleService;
	
	@GetMapping("LayDanhSachLoaiNguoiDung")
	public Object get() {
		try {
			List<RoleDto> dtos = roleService.getAll(); 
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("LayDanhSachNhanVien")
	public Object get(@RequestHeader("Authorization") String Authorization) {
		List<UserDto> dtos = userService.getAll();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(dtos);
			return new ResponseEntity<Object>(json,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("DangNhap")
	public Object post(@RequestBody LoginDto loginDto) {
		try {
			String token = authService.Login(loginDto);
			return new ResponseEntity<Object>(token,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("ThemNhanVien")
	public Object post(@RequestBody UserDto userDto, @RequestHeader("Authorization") String Authorization) {
		try {
			userService.insert(userDto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("ChinhSuaThongTin/{id}")
	public Object put(@PathVariable("id") int id, @RequestBody UserDto userDto, @RequestHeader("Authorization") String Authorization) {
		try {
			userService.update(id,userDto);
			return new ResponseEntity<Object>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("XoaNhanVien/{id}")
	public Object delete(@PathVariable("id") int id,@RequestHeader("Authorization") String Authorization) {
		try {
			userService.delete(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("ThongTinTaiKhoan")
	public Object get(@PathVariable("id") int id) {
		try {
			UserDto userDto = userService.getById(id);
			return new ResponseEntity<Object>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("TimKiemNhanVien")
	public Object get(@RequestParam("phone") String phone ,@RequestHeader("Authorization") String Authorization) {
		try {
			UserDto userDto = userService.getByPhone(phone);
			return new ResponseEntity<Object>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
