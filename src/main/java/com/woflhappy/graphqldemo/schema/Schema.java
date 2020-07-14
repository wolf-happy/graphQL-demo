package com.woflhappy.graphqldemo.schema;

import java.io.IOException;

import graphql.schema.GraphQLSchema;

/**
 * @author cao.wei
 * 2020.07.14
 */
public interface Schema {

    // loading schema
    Schema loading() throws Exception;

    // schema parsing graphQL schema;
    GraphQLSchema parse();

    static GraphQLSchema SDLSchema() {
        return new SDLSchema().loading().parse();
    }
}
