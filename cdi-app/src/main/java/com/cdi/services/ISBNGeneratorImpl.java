package com.cdi.services;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ISBNGeneratorImpl implements NumberGenerator {
    @Override
    public String generateISBNGenerator() {
        return "76323432343455";
    }
}
