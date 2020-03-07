package com.example.rpt.repositories;

import com.example.rpt.domain.Examiner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ExaminerRepository extends CrudRepository<Examiner, Integer> {
    public Set<Examiner> findAllByExaminerName(String examinerName);

}
