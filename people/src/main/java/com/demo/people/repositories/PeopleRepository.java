package com.demo.people.repositories;

import com.demo.people.models.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends PagingAndSortingRepository<Person, Long> {



}
