package com.example.demo.repository;

import com.example.demo.model.Subject;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class SubjectRepository implements ObjectRepository {

    private HashMap<Integer, Subject> repository;

    public SubjectRepository() {
        this.repository = new HashMap<Integer, Subject>();

        Subject sub = new Subject(1, "chem");
        this.repository.put(1, sub);
    }

    public void store(Subject subject) {
        this.repository.put(subject.getId(), subject);
    }

    @Override
    public Subject retrieve(int id) {
        return this.repository.get(id);
    }

    @Override
    public Subject search(String name) {
        return null;
    }

    @Override
    public Subject delete(int id) {
        return null;
    }

    public List<Subject> getAll() {
        List<Subject> subs = new ArrayList<>();

        for(Subject e : this.repository.values())
            subs.add(e);

        return subs;
    }
}
