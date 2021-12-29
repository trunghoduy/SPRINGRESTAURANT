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
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myclass.dto.HallDto;
import com.myclass.dto.ServiceDto;
import com.myclass.entity.Hall;
import com.myclass.service.ServiceService;

@Controller
public class QuanLyDichVuCuoi {

	@Autowired
	private ServiceService serviceService;
	@GetMapping("LayDanhSachDichVuCuoi")
	public Object get(@RequestHeader("Authorization") String Authorization) {
		List<ServiceDto> serviceDto = serviceService.getAll();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(serviceDto);
			return new ResponseEntity<Object>(json,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@PostMapping("ThemDichVuCuoi")
	public Object post(@RequestBody ServiceDto serviceDto,@RequestHeader("Authorization") String Authorization) {
		try {
			serviceService.insert(serviceDto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("SuaThongTinDichVuCuoi/{id}")
	public Object put(@PathVariable("id") int id, @RequestBody ServiceDto serviceDto,@RequestHeader("Authorization") String Authorization) {
		try {
				serviceService.update(serviceDto,id);
			 return new ResponseEntity<Object>(serviceDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("XoaDichVuCuoi")
	public Object delete(@PathVariable("id") int id,@RequestHeader("Authorization") String Authorization) {
		try {
			serviceService.delele(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("TimKiemDichVuCuoi")
	public Object get(@PathVariable("id") int id,@RequestHeader("Authorization") String Authorization) {
		try {
				ServiceDto serviceDto = serviceService.getById(id);
				return new ResponseEntity<Object>(serviceDto, HttpStatus.OK);
			} catch (Exception e) {
			e.printStackTrace();
			}
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
	
}
