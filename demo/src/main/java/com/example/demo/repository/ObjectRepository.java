package com.example.demo.repository;

public interface ObjectRepository<T> {


    public T retrieve(int id);
    public T search(String name);
    public T delete(int id);
}
