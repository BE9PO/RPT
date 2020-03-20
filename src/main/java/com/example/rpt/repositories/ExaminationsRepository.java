package com.example.rpt.repositories;

import com.example.rpt.domain.Examination;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ExaminationsRepository extends CrudRepository<Examination, Integer>, JpaSpecificationExecutor<Examination> {
    List<Examination> findByDateIntakeAfter(Date date);

    List<Examination> findByDateOfExecutionAfter(Date date);

}
