package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/users")
public class DemoApplication {
	private static List<demo> userList = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping
	public List<demo> getUserList(){
		return  userList;
	}

	@PostMapping
	public List<demo> addToList(@RequestBody demo d){

		userList.add(d);
		return  userList;
	}

	@PutMapping("/{name}")
	public demo getUpdatedUser(@PathVariable String name, @RequestBody demo updatedUser){
		for(demo d :userList){
			if(d.getName().equalsIgnoreCase(name)){
				d.setName(updatedUser.getName());
				d.setEmail(updatedUser.getEmail());
				d.setPwd(updatedUser.getPwd());

				return d;
			}
		}
		return null;
	}

	@DeleteMapping("/{name}")
	public void deleteUserList(@PathVariable String name){
		userList.removeIf(userList-> userList.getName().equalsIgnoreCase(name));
	}

}
//[
//		{
//		"name": "sita",
//		"pwd": "s1s1",
//		"email": "sita@gmail.com"
//		},
//		{
//		"name": "rita",
//		"pwd": "rita@rita123",
//		"email": "rita@gmail.com"
//		},
//		{
//		"name": "gita",
//		"pwd": "gita@123",
//		"email": "gita@gmail.com"
//		}
//]