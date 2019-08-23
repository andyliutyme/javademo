package com.example.demo.integrations.internal.models;

import com.example.demo.integrations.internal.interfaces.queries.IQueryResult;
import lombok.Getter;

public class QueryResultList<T> implements IQueryResult {
    @Getter
    private T[] items;

    public QueryResultList(T[] items)
    {
        this.items = items;
    }
}
