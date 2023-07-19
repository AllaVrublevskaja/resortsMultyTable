package org.top.resortsmultytable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.top.resortsmultytable.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {
}
