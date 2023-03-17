package com.example.HowFastCanEat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordsService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private RecordsRepository recordsRepository;

    //metoder under her

    public List<Records> getTopThree() {
        return recordsRepository.findAllByOrderByIdDesc();
    }

    public List<Records> getByFood() {
        return recordsRepository.findAllByFoodId(1);
    }

    public List<Person> getAllPerson() {
        return (List<Person>) personRepository.findAll();
    }
}
