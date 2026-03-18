package ntu.phamgiakhiem.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ntu.phamgiakhiem.models.Page;

@RestController
public class APIPageController {
	ArrayList<Page> dsTrang = new ArrayList<Page>();
	
	
	public APIPageController()
	{
		Page p1 = new Page(0, "GioiThieu", "mct", "Nội dung trang ở đây", 0);
		Page p2 = new Page(1, "About", "About me", "Nội dung trang ở đây", 0);
		Page p3 = new Page(2, "Trang Y", "sth", "Nội dung trang ở đây", 0);
		
		dsTrang.add(p1);
		dsTrang.add(p2);
		dsTrang.add(p3);
	}
	
	@GetMapping("/api/pages")
	public ArrayList<Page> getAllPages()
	{
		return dsTrang;
	}
	
	@GetMapping("/api/page/{id}")
	public Page getOneOBJ(@PathVariable("id") Long id)
	{
		for(Page p : dsTrang)
		{
			if(p.getId()==id)
				return p;
		}
		return null;
	}
	
	@DeleteMapping("/api/pages/del/{id}")
	public boolean pageDelete(@PathVariable("id") int id)
	{
		for(Page p:dsTrang)
		{
			if(p.getId() == id)
			{
				boolean kq = dsTrang.remove(p);
				return kq;
			}
		}
		return false;
	}
	
	@PostMapping("api/pages/add")
	public boolean pageAdd(@RequestBody Page entity)
	{
		boolean kq = dsTrang.add(entity);
		return kq;
	}
	
	@PutMapping("/api/pages/update/{id}")
	public boolean pageUpdate(@PathVariable("id") int id, @RequestBody Page entity)
	{
		for(Page p:dsTrang)
		{
			if(p.getId() == id)
				dsTrang.remove(p);
				dsTrang.add(entity);
				return true;
		}
		return false;
	}
}
