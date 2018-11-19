package com.zhang.product.controller;

import com.zhang.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vo.ResponseUtil;
import vo.ResponseVO;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/list")
    public ResponseVO productList() {
        List list = service.productInfoList();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("host",request.getServerPort());
        map.put("result",list);
        return ResponseUtil.success(map);
    }

    @RequestMapping("/list/{status}")
    public ResponseVO productListByStatus(@PathVariable Long status) {
        List list = service.productInfoListByStatus(status);
        return ResponseUtil.success(list);
    }
}
