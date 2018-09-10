package com.zhang.product.service;

import com.zhang.product.dao.ProductDao;
import com.zhang.product.entity.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao dao;

    /**
     * 获取商品列表
     *
     * @return
     */
    public List<ProductInfo> productInfoList() {
        return dao.findAll();
    }

    /**
     * 根据状态获取商品列表
     *
     * @param status
     * @return
     */
    public List<ProductInfo> productInfoListByStatus(long status) {
        return dao.findAllByProductStatus(status);
    }

    /**
     * 根据商品id查询给定范围的商品信息
     *
     * @param productIds
     * @return
     */
    public List<ProductInfo> listProductInfoByIds(List productIds) {
        return dao.findByProductIdIn(productIds);
    }
}
