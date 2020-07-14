package com.woflhappy.graphqldemo.beans;

import com.woflhappy.graphqldemo.schema.Schema;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import graphql.GraphQL;

/**
 * @author cao.wei
 * 2020.07.14
 */
@Configuration
public class GraphqlBean {

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() {
        return this.graphQL;
    }

    /**
     * Initializes the GraphQL bean
     */
    @PostConstruct
    public void init() {
        this.graphQL = GraphQL.newGraphQL(Schema.SDLSchema()).build();
    }


}