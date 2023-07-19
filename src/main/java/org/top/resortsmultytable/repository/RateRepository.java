package org.top.resortsmultytable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.top.resortsmultytable.entity.Rate;

public interface RateRepository extends JpaRepository <Rate, Integer> {
}
