package com.shops.bakery.BakeryProducts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class BakeryProducts
{
    @Id
    @SequenceGenerator(name = "BakeryProducts_sequence", sequenceName = "BakeryProducts_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BakeryProducts_sequence")
    //@Column(name = "id")
    private Integer id;
    //@Column
    private String name;
    //@Column
    private Integer size;
    //@Column
    private String flourtype;
    //@Column
    private String coating;
    //@Column
    private Integer price;

    public String bach;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

    public String getFlourtype() {
        return flourtype;
    }

    public String getCoating() {
        return coating;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setFlourtype(String flourtype) {
        this.flourtype = flourtype;
    }

    public void setCoating(String coating) {
        this.coating = coating;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public BakeryProducts(Integer id, String name, Integer size, String flourtype, String coating, Integer price) //constructer
    {
        this.id = id;
        this.name = name;
        this.size = size;
        this.flourtype = flourtype;
        this.coating = coating;
        this.price = price;
        return;
    }
    
    public BakeryProducts(String name, Integer size, String flourtype, String coating, Integer price) //constructer
    {
        //System.out.println("Creating BakeryProduct(class constructer called):");
        //System.out.print(name + ", " +size+", "+ flourtype+", "+coating+", "+price+"\n");

        this.name = name;
        this.size = size;
        this.flourtype = flourtype;
        this.coating = coating;
        this.price = price;
        return;
    }

    public BakeryProducts() {
        this.id = -1;
        this.name = "noname";
        this.size = -1;
        this.flourtype = "notype";
        this.coating = "nocoating";
        this.price = -1;

    }

    public String returnProductData()
    {
        return "Name: " + this.name + ", Size: " + this.size + ", Flourtype: " + this.flourtype + ", Coating: " + this.coating + ", Price: " + this.price + "€";
    }

    @Override
    public String toString() {
        return "BakeryProducts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", flourtype='" + flourtype + '\'' +
                ", coating='" + coating + '\'' +
                ", price=" + price +
                '}';
    }

}
