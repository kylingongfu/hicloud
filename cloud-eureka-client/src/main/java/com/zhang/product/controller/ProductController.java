package com.zhang.product.controller;

import com.zhang.ResponseUtil;
import com.zhang.ResponseVO;
import com.zhang.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;

    @RequestMapping("/list")
    public ResponseVO productList(){
        List list = service.productInfoList();
        return ResponseUtil.success(list);
    }

    @RequestMapping("/list/{status}")
    public ResponseVO productListByStatus(@PathVariable Long status){
        List list = service.productInfoListByStatus(status);
        return ResponseUtil.success(list);
    }
}
