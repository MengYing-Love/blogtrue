package com.xaut.blog.blog.dao;

import org.springframework.stereotype.Repository;

@Repository("h")
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "hibernate";
    }
}
