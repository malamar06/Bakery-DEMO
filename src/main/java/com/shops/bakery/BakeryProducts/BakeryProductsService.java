package com.shops.bakery.BakeryProducts;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BakeryProductsService {

    private final BakeryProductsRepository myBakeryRepository;

    @Autowired
    public BakeryProductsService(BakeryProductsRepository BakeryRepository)
    {
        this.myBakeryRepository = BakeryRepository;
    }

    public void addNewBakeryProduct(BakeryProducts newProduct) //POST related
    {
        System.out.println("===========\nService.addNewBakeryProduct step. I want to post this: ");
        System.out.println(newProduct);
        Optional<BakeryProducts> productByName = myBakeryRepository.findBakeryProductsByName(newProduct.getName());
        System.out.println("Checking if Products exists...");
        if (productByName.isPresent())
        {
            System.out.println("Product already exists!");
            throw new IllegalStateException("Product already exists!");
        }
        else{System.out.println("Does not exist.\nSaving the new product");}
        this.myBakeryRepository.save(newProduct);
    }
    public List<BakeryProducts> getBakeryProductData()//GET related
    {
        /*mocking here
        BakeryProducts cansbagette = new BakeryProducts("kokie",5,"Weißmehl","none",13);
        BakeryProducts cansbagette1 = new BakeryProducts("kokie1",5,"Weißmehl1","none1",13);
        System.out.println("======================");
        System.out.println(nobisNearMe.findAll());
        System.out.println("======================");
        return cansbagette1.returnProductData();*/

	    return myBakeryRepository.findAll();

    }

    public void deleteProduct(Integer bakeryProductId) {//cant use Long here so improvised to Integer.

        boolean exists = myBakeryRepository.existsById(bakeryProductId);
        if (!exists)
        {
            throw new IllegalStateException("Product with id:" + bakeryProductId + ", does not exists.");
        }
        myBakeryRepository.deleteById(bakeryProductId);
    }

    @Transactional
    public void updateBakeryProduct(Integer productId, String newname, Integer newprice)
    {
        if(!myBakeryRepository.existsById(productId))
        {
            throw new IllegalStateException("Post Failed: {Product with id:" + productId + ", does not exists.}");
        }
        BakeryProducts thisProduct = myBakeryRepository.findById(productId).orElseThrow(); //orElseThrow here for Template to Solid
        thisProduct.setName(newname);
        thisProduct.setPrice(newprice);

    }
}



/* MOCKING AND DEBUG
    {
        "name": "exampleBrot",
        "size": 1,
        "flourtype": "Weißmehl",
        "coating": "None",
        "price": 25
    }
    */