package com.zhang.order.controller;

import com.zhang.order.client.ProductApiFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vo.ResponseUtil;
import vo.ResponseVO;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    //在@Bean的config类中使用@LoadBalanced注解完成Ribbon的配置,url使用SericeId替代

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ProductApiFeign productApi;


    /**
     * 使用restTemplate调用服务
     * @return
     */
    @GetMapping("/create")
    public ResponseVO addOrder(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCTAPI");
        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort());
        RestTemplate restTemplate = new RestTemplate();
        ResponseVO vo = restTemplate.getForObject(url+"/product/list",ResponseVO.class);
        logger.info("restTemplate hashcode:{}{}",restTemplate.hashCode(),url);
        return ResponseUtil.success(vo.getData()) ;
    }



    @GetMapping("/create2")
    public ResponseVO addOrder2(){
        String url = String.format("http://PRODUCTAPI");
        logger.info("restTemplate2 hashcode:{}{}",restTemplate.hashCode(),url);
        ResponseVO vo = restTemplate.getForObject(url+"/product/list",ResponseVO.class);
        return ResponseUtil.success(vo.getData()) ;
    }


    @GetMapping("/create/feign")
    public ResponseVO addOrderFeign(){
        logger.info("use feign prodcutapi:{}",productApi);
        return this.productApi.queryProductList();
    }


}
