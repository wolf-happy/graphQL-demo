package com.woflhappy.graphqldemo.data;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author cao.wei
 * 2020.07.14
 */
public class StaticData {

    public static List<Map<String, String>> BOOKS = Arrays.asList(
        ImmutableMap.of("id", "book-1",
                        "name", "Harry Potter and the Philosopher's Stone",
                        "pageCount", "223",
                        "authorId", "author-1"),
        ImmutableMap.of("id", "book-2",
                        "name", "Moby Dick",
                        "pageCount", "635",
                        "authorId", "author-2"),
        ImmutableMap.of("id", "book-3",
                        "name", "Interview with the vampire",
                        "pageCount", "371",
                        "authorId", "author-3")
    );

    public static List<Map<String, String>> AUTHORS = Arrays.asList(
        ImmutableMap.of("id", "author-1",
                        "firstName", "Joanne",
                        "lastName", "Rowling"),
        ImmutableMap.of("id", "author-2",
                        "firstName", "Herman",
                        "lastName", "Melville"),
        ImmutableMap.of("id", "author-3",
                        "firstName", "Anne",
                        "lastName", "Rice")
    );


}