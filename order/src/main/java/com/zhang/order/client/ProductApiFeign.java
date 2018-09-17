package com.zhang.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import vo.ResponseVO;

@FeignClient("productapi")
public interface ProductApiFeign {

    @GetMapping("/product/list")
    public ResponseVO queryProductList();
}
