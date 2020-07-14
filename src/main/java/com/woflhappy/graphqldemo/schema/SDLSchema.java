package com.woflhappy.graphqldemo.schema;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.woflhappy.graphqldemo.schema.data_fetchers.BookDataFetcher;
import com.woflhappy.graphqldemo.schema.runtime_wiring.SDLRuntimeWiring;

import java.net.URL;

import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;

/**
 * @author cao.wei
 * 2020.07.14
 */
@Slf4j
public class SDLSchema implements Schema {

    private final static String RESOURCE = "schema.graphqls";

    private String schema;

    @Override
    @SuppressWarnings("all")
    public Schema loading() {
        try {
            URL url = Resources.getResource(RESOURCE);
            this.schema = Resources.toString(url, Charsets.UTF_8);
        } catch (Exception e) {
            log.error(String.format("schema failed to load! error info:%s", e.getMessage()));
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public GraphQLSchema parse() {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(this.schema);
        RuntimeWiring runtimeWiring = new SDLRuntimeWiring(new BookDataFetcher()).runtimeWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }
}