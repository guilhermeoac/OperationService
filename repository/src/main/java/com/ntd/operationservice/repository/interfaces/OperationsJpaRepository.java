package com.ntd.operationservice.repository.interfaces;

import com.ntd.operationservice.repository.model.Operation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationsJpaRepository extends JpaRepository<Operation, Long> {

    List<Operation> findOperationByType(String Type);
}

