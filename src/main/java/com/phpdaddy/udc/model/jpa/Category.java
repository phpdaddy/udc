package com.phpdaddy.udc.model.jpa;

import org.hibernate.annotations.OptimisticLock;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @ManyToOne
    @JoinColumn(columnDefinition = "integer", name = "parent_id")
    private Category parent;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "parent", fetch = FetchType.EAGER)
    @OptimisticLock(excluded = false)
    private Set<Category> children = new HashSet<>();

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category(String name, Long id) {

        this.name = name;
        this.id = id;
    }

    public Category() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Set<Category> getChildren() {
        return children;
    }

    public void setChildren(Set<Category> children) {
        this.children = children;
    }
}
