package com.phpdaddy.udc.model.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OptimisticLock;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
    private String keywords;
}
