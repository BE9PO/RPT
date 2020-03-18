package com.example.rpt.repositories;

import com.example.rpt.domain.Examination;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ExaminationsRepository extends CrudRepository<Examination, Integer> {
    List<Examination> findTopByDateIntakeAfter (Date date);
    List<Examination> findAllByDateOfExecutionExistsAndDateOfExecutionAfter(Date date);

}
