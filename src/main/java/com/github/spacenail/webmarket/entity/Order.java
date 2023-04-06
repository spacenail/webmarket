package com.github.spacenail.webmarket.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Order {
    private Long id;
    private User user;
    private Set<Product> productSet;
    private Date createDate;
    private Integer summaryCost;

    public Order(Long id, User user, List<Product> productList, Date createDate) {
        this.id = id;
        this.user = user;
        createDate = new Date();
        summaryCost = productList.stream().map(x->x.getPrice()).reduce(0,(acc, x)-> acc + x);
        this.productSet = productList.stream().collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
