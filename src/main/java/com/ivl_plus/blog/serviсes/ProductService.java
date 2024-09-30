package com.ivl_plus.blog.serviсes;

import com.ivl_plus.blog.models.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;
    {//добавление товаров нужно через data sql/ не добавляет в БД
        products.add(new Product(++ID,"Доска обрезная", "1 куб",300));
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

    }

    public List<Product> list() {return products;}
    public void saveProduct(Product product){
        product.setId(++ID);

        products.add(product);
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

}
