package com.zhang;

public class ResponseUtil {
    public static ResponseVO success(Object obj){
        ResponseVO vo = new ResponseVO();
        vo.setData(obj);
        return vo;
    }
}
