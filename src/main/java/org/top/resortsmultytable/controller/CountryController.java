package org.top.resortsmultytable.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.top.resortsmultytable.entity.Country;
import org.top.resortsmultytable.repository.CountryRepository;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("country1")
public class CountryController {

    private final CountryRepository countryRepository;

    @GetMapping("ping")
    public String ping() {return "country pong";}

    @PostMapping("")
    public Country add(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    @GetMapping("")
    public Iterable <Country> getAll() { return countryRepository.findAll(); }

    @GetMapping("/{id}")
    public Optional <Country> getById(@PathVariable Integer id) {
        return countryRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public Optional <Country> delete(@PathVariable Integer id){
        Optional<Country> deleted = countryRepository.findById(id);
        if(deleted.isPresent())
            countryRepository.deleteById(id);
        return deleted;
    }

    @PatchMapping("")
    public Optional<Country> update(@RequestBody Country changed){
        if (changed.getId()==null) return Optional.empty();
        Optional <Country> updated = countryRepository.findById(changed.getId());
        if (updated.isPresent())
            return Optional.of(countryRepository.save(changed));
        return Optional.empty();
    }
}
