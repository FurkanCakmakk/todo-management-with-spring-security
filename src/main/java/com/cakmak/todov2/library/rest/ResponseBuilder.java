package com.cakmak.todov2.library.rest;

import org.springframework.data.domain.Page;

import java.util.List;

public class ResponseBuilder {

    private ResponseBuilder() {
    }

    public static <T> Response<DataResponse<T>> build(List<T> items){
        System.out.println("ResponseBuilder'da Response<DataResponse<T>> build(List<T> items) metoduna girdi. İtems liste olarak dönecek.");
        return new Response<>(new DataResponse<>(items , items.size()));
    }

    public static <T> Response<PageResponse<T>> build(Page<T> items){
        System.out.println("ResponseBuilder'da Response<PageResponse<T>> build(Page<T> items) metoduna girdi. Response sayfa olarak dönecek");

        return new Response<>(new PageResponse<>(items));
    }

    public static <T> Response<T> build(T item){
        System.out.println("ResponseBuilder'da Response<T> build(T item) metoduna girdi. Tek bir item dönecek");

        return new Response<>(item);
    }

    public static Response<MetaResponse> build(MetaResponse metaResponse){
        System.out.println("ResponseBuilder'da Response<MetaResponse> build(MetaResponse metaResponse) metoduna girdi.");

        return new Response<>(metaResponse);
    }

}
