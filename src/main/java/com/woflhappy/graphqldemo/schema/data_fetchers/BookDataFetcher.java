package com.woflhappy.graphqldemo.schema.data_fetchers;

import com.woflhappy.graphqldemo.data.StaticData;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import graphql.schema.DataFetcher;

/**
 * @author cao.wei
 * 2020.07.14
 */
@SuppressWarnings("rawtypes")
@Component
public class BookDataFetcher {

    public DataFetcher getBooks() {
        return environment -> StaticData.BOOKS;
    }

    public DataFetcher getById() {
        return environment -> {
            String str = environment.getArgument("id");
            return StaticData.BOOKS.stream()
                                   .filter(book -> str.equals(book.get("id")))
                                   .findFirst().orElse(null);
        };
    }
}