package com.ivl_plus.blog.services;

import com.ivl_plus.blog.models.Category;
import com.ivl_plus.blog.models.Product;
import com.ivl_plus.blog.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product save() {
        return productRepository.save(new Product("Доска обрезная", "1 куб", BigDecimal.valueOf(300), 1, new Category("category1", "description of category 1")));
    }

    private List<Product> products = new ArrayList<>();
    private long ID = 0;
    /*
        products.add(new Product(++ID,"Доска обрезная сухая", "1 куб",500));
        products.add(new Product(++ID,"Доска необрезная", "1 куб",300));
        products.add(new Product(++ID,"Доска необрезная сухая", "1 куб",500));
        products.add(new Product(++ID,"Вагонка", "1 м.кв.",10));
        products.add(new Product(++ID,"Имитация бруса", "1 м.кв.",20));
        products.add(new Product(++ID,"Блок-хаус", "1 м.кв.",25));
        products.add(new Product(++ID,"Доска пола", "1 м.кв.",25));
        products.add(new Product(++ID,"Террасная доска", "1 м.кв.",30));
        products.add(new Product(++ID,"Туалет", "односкатный",420));
        products.add(new Product(++ID,"Туалет", "двухскатный",500));
        products.add(new Product(++ID,"Туалет", "кукушка",700));
        products.add(new Product(++ID,"Будка для собак", "",250));
        products.add(new Product(++ID,"Колодец", "",450));
        products.add(new Product(++ID,"Душевая кабина", "",700));
        products.add(new Product(++ID,"Беседка", "",900));
        //System.out.println(products.size());

    }*/

    public List<Product> list() {
        return productRepository.findAll();
    }
    public void saveProduct(Product product){
        product.setId(++ID);

        products.add(product);
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

}
