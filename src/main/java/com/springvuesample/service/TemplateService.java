package com.springvuesample.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

public abstract class TemplateService<T> {

    public abstract List<T> findAll();

    public abstract T findById(final Long id) throws EntityNotFoundException;

    public abstract void create(final T entity);

    public abstract void update(final Long id, final T entity) throws EntityNotFoundException;

    public abstract void deleteById(final Long id);

    public abstract T getOne(final Long id) throws EntityNotFoundException;

}