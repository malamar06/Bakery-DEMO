package com.shops.bakery.BakeryProducts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/broetli/BakeryProducts")

public class BakeryProductsControl {

	@Autowired
	private BakeryProductsService bakeryService;

    @GetMapping
	public String getBakeryProduct()//GET
	{
		/*MOCKING AND DEBUG
		System.out.println("Abi mal geldi.");
		BakeryProducts mock1 = new BakeryProducts("sikkafasi",5,"beyazun","None",3131);
		System.out.println(mock1);
		System.out.println("0000000000000000000000000000000000000000000000000");
		System.out.println(List.of(mock1));
		System.out.println("0000000000000000000000000000000000000000000000000");*/

		return bakeryService.getBakeryProductData().toString();
	}

	@PostMapping
	public void registerNewBakeryProduct(@RequestBody BakeryProducts newProduct)//POST
	{
		/*MOCKING AND DEBUG
		System.out.println("Post request received getting object.\nStep: registerNewBakeryProduct");
		System.out.println(newProduct);*/
		bakeryService.addNewBakeryProduct(newProduct);
	}

	@DeleteMapping(path = "{bakeryProductId}")
	public void deleteBakeryProduct(@PathVariable ("bakeryProductId") Integer bakeryProductId)
	{
		bakeryService.deleteProduct(bakeryProductId);
	}

	@PutMapping(path = "{bakeryProductId}")
	public void updateBakeryProduct(@PathVariable("bakeryProductId") Integer bakeryProductId,
									@RequestParam(required = false) String name,
									@RequestParam(required = false) Integer price)
	{
		bakeryService.updateBakeryProduct(bakeryProductId, name, price);
	}

}
