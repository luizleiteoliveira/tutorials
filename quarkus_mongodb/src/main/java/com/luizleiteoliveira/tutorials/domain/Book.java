package com.luizleiteoliveira.tutorials.domain;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Book extends PanacheMongoEntity {

    public String name;
    public String author;
    public Integer yearPublication;

    public static Book findByName(String nameToSearch) {
        return find("name", nameToSearch).firstResult();
    }
}
