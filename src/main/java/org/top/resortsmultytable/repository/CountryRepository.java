package org.top.resortsmultytable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.top.resortsmultytable.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
