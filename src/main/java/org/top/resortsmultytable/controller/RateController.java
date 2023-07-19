package org.top.resortsmultytable.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.top.resortsmultytable.entity.Rate;
import org.top.resortsmultytable.repository.RateRepository;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("rate")
public class RateController {

    public final RateRepository rateRepository;

    @GetMapping("ping")
    public String ping() { return "rate pong";}

    @PostMapping("")
    public Rate add(@RequestBody Rate rate) { return rateRepository.save(rate); }

    @GetMapping("")
    public Iterable<Rate> getAll(){ return rateRepository.findAll(); }

    @GetMapping("/{id}")
    public Optional<Rate> getById(@PathVariable Integer id){
        return rateRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public Optional<Rate> delete(@PathVariable Integer id) {
        Optional<Rate> deleted = rateRepository.findById(id);
        if(deleted.isPresent()) rateRepository.deleteById(id);
        return deleted;
    }

    @PatchMapping("")
    public Optional<Rate> update(@RequestBody Rate rate){
        if(rate.getId() == null) return Optional.empty();
        Optional<Rate> updated = rateRepository.findById(rate.getId());
        if(updated.isPresent())
            return Optional.of(rateRepository.save(rate));
        return Optional.empty();
    }
}
