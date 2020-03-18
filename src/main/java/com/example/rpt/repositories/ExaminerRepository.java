package com.example.rpt.repositories;

import com.example.rpt.domain.Examiner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ExaminerRepository extends CrudRepository<Examiner, Integer> {
    Set<Examiner> findAllByExaminerName(String examinerName);

    //TODO for testing
    Examiner findFirstByExaminerName(String examinerName);



}
