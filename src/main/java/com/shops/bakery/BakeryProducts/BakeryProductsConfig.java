package com.shops.bakery.BakeryProducts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;


@Configuration
public class BakeryProductsConfig {


    @Bean
    CommandLineRunner commandLineRunner(BakeryProductsRepository mydemrepo)


    {
        //Here is the actual saving to my server. Creating 2 new BakeryProduct Variables and passing them down to saveAll
        //function of BakeryProductsRepository (which is an extension of Jpa object repositoryies)
        return args -> {
           BakeryProducts kekwnoway = new BakeryProducts("Kasebroetchen", 4, "Vollkorn", "None", 32);
           BakeryProducts kekwnoway2 = new BakeryProducts("Schococockie", 1, "Vollkorn", "None", 12);
           mydemrepo.saveAll(List.of(kekwnoway,kekwnoway2));

        };
    }
}
