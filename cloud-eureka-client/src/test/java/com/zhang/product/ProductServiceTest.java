package com.zhang.product;

import com.zhang.product.entity.ProductInfo;
import com.zhang.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService service;

    @Test
    public void productInfoList() {
        List list = service.productInfoList()
                .stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        System.out.println(list);

        Assert.assertTrue(service.productInfoList().size() > 1);
    }
}