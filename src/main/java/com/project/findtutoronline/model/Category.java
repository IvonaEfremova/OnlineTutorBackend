package com.project.findtutoronline.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String categoryName;

    public Category() {
    }

    public Category(@NotNull String category_name) {
        this.categoryName = category_name;
    }

    public Category(Long id, String name) {
        this.id = id;
        categoryName = name;
    }
}
