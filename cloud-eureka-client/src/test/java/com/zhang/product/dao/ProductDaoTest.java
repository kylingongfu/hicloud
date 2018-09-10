package com.zhang.product.dao;

import com.zhang.product.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Test
    public void findAllByProductStatus() {
        List list = productDao.findAllByProductStatus(0);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findByProductIdIn() {
        List<ProductInfo> list = productDao.findByProductIdIn(Arrays.asList("157875196366160022", "164103465734242707"));
        Assert.assertTrue(list.size() > 0);
    }
}