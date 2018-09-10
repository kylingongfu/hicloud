package com.zhang.product.dao;

import com.zhang.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<ProductInfo, String> {
    public List<ProductInfo> findAllByProductStatus(long status);

    public List<ProductInfo> findByProductIdIn(List<String> productIds);
}
