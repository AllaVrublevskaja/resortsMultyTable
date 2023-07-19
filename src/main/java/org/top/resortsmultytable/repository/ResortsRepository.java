package org.top.resortsmultytable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.top.resortsmultytable.entity.Resorts;

public interface ResortsRepository extends JpaRepository <Resorts, Integer> {
}
