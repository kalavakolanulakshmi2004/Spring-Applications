package com.example.ShoppingCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/products")
public class ShoppingCartApplication {
	static private List<Products> productsList=new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(com.example.ShoppingCart.ShoppingCartApplication.class, args);
	}

	// list of all items
	@GetMapping
	public List<Products> getProductsList(){
		return productsList;
	}

	//add products to list
	@PostMapping
	public List<Products> addToProductList(@RequestBody Products p){
		productsList.add(p);
		return productsList;
	}

	//update
	@PutMapping("/{name}")
	public List<Products> updateProductQuantity(@PathVariable String name,@RequestBody Map<String, Integer> updateData){
		int newQuantity=updateData.get("quantity");


		for(Products product :productsList){
			if(product.getName().equalsIgnoreCase(name)){
				product.setQuantity(newQuantity);
				return productsList;
			}
		}
		return productsList;
	}


	//remove
	@DeleteMapping("/{name}")
	public List<Products> deleteProductByName(@PathVariable String name){
		productsList.removeIf(productsList->productsList.getName().equalsIgnoreCase(name));
		return productsList;
	}

	// view cost
	@GetMapping("/total-cost") // <--- New mapping for the total cost
	public Map<String, Float> viewTotalCost(){ // Changed return type to Map for structured JSON
		float totalCost=0;

		for(Products p:productsList){
			totalCost+=p.getPrice()*p.getQuantity();
		}

		// Return the total cost in a Map, which Spring will convert to JSON
		Map<String, Float> response = new HashMap<>();
		response.put("totalCost", totalCost);
		return response;
	}

}
/*
[
  {
    "name": "shoes",
    "price": 400.5,
    "quantity": 2
  },
  {
    "name": "phone",
    "price": 140440.6,
    "quantity": 3
  },
  {
    "name": "books",
    "price": 440.9,
    "quantity": 6
  }
]






 */
