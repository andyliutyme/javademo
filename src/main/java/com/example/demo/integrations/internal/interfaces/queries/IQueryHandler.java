package com.example.demo.integrations.internal.interfaces.queries;

public interface IQueryHandler<TQuery extends IQuery, TQueryResult extends IQueryResult> {
    public TQueryResult handle(TQuery query);
}
