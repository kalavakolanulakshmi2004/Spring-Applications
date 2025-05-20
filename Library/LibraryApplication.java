package com.example.LibraryApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/books")

public class LibraryApplication {
	static private List<Books> bookList=new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	// all avail books
	@GetMapping
	public List<Books> getBookList(){
		return bookList;
	}

	// add new books
	@PostMapping
	public List<Books> addToBookList(@RequestBody Books b){
		bookList.add(b);
		return bookList;
	}

	// search for book
	@PutMapping("/{title}")
	public Books getBookDetails(@PathVariable String title){
		Books searchBooked=null;
		for(Books b:bookList){
			if(b.getTitle().equalsIgnoreCase(title)){
				searchBooked=b;
			}
		}
		return searchBooked;
	}

	//remove by title
	@DeleteMapping("/{title}")
	public List<Books> deleteBookByTitle(@PathVariable String title){
		Books deletedBook=null;
		bookList.removeIf(b->b.getTitle().equalsIgnoreCase(title));
		return bookList;
	}
}
/*
[
  {
    "title": "Mahabharata",
    "author": " Vyasa",
    "price": 450.9
  },
  {
    "title": "Ramayan",
    "author": " Valmiki",
    "price": 6650.9
  },
  {
    "title": "Malgudi Days",
    "author": "R.K. Narayan",
    "price": 300.5
  },
  {
    "title": "Gitanjali",
    "author": "Rabindranath Tagore",
    "price": 500.5
  }
]









 */