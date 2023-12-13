package com.cakmak.todov2.library.rest;

import org.springframework.data.domain.Page;

import java.util.List;

public class BaseController {

    public <T> Response<DataResponse<T>> respond(List<T> items){
        System.out.println("BaseController'daki Response<DataResponse<T>> respond(List<T> items) metoduna girdi");
        return ResponseBuilder.build(items);
    }

    public <T> Response<PageResponse<T>> respond(Page<T> item){
        System.out.println("BaseController'daki Response<PageResponse<T>> respond(Page<T> item) metoduna girdi");

        return ResponseBuilder.build(item);
    }

    public <T> Response<T> respond(T item){
        System.out.println("BaseController'daki Response<T> respond metoduna girdi");

        return ResponseBuilder.build(item);
    }

    public Response<MetaResponse> respond(MetaResponse metaResponse){
        System.out.println("BaseController'daki Response<MetaResponse> respond(MetaResponse metaResponse) metoduna girdi");

        return ResponseBuilder.build(metaResponse);
    }

}
