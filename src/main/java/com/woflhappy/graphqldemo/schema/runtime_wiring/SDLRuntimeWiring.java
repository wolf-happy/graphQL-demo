package com.woflhappy.graphqldemo.schema.runtime_wiring;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

import com.woflhappy.graphqldemo.schema.data_fetchers.BookDataFetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.idl.RuntimeWiring;

/**
 * @author cao.wei
 * 2020.07.14
 */
@Component
public class SDLRuntimeWiring {

    private RuntimeWiring runtimeWiring;

    @Autowired
    public SDLRuntimeWiring(BookDataFetcher bookDataFetcher) {
        this.runtimeWiring = RuntimeWiring.newRuntimeWiring()
                                          .type(newTypeWiring("Query").dataFetcher("books", bookDataFetcher.getBooks()))
                                          .type(newTypeWiring("Query").dataFetcher("bookById", bookDataFetcher.getById()))
                                          .build();
    }

    public RuntimeWiring runtimeWiring() {
        return runtimeWiring;
    }

}