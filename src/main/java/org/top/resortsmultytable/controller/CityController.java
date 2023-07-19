package org.top.resortsmultytable.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.top.resortsmultytable.entity.City;
import org.top.resortsmultytable.repository.CityRepository;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("city")
public class CityController {

    private final CityRepository cityRepository;

    @GetMapping("ping")
    public String ping() {return "city pong";}

    @PostMapping("")
    public City add(@RequestBody City city) { return cityRepository.save(city); }

    @GetMapping("")
    public Iterable<City> getAll(){ return cityRepository.findAll(); }

    @GetMapping("/{id}")
    public Optional<City> getById(@PathVariable Integer id) {
        return cityRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public Optional<City> delete(@PathVariable Integer id) {
        Optional<City> deleted = cityRepository.findById(id);
        if(deleted.isPresent()) cityRepository.deleteById(id);
        return deleted;
    }

    @PatchMapping("")
    public Optional<City> update(@RequestBody City changed) {
        if(changed.getId() == null) return Optional.empty();
        Optional<City> updated = cityRepository.findById(changed.getId());
        if(updated.isPresent())
            return Optional.of(cityRepository.save(changed));
        return Optional.empty();
    }
}
