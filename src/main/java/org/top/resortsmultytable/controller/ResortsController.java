package org.top.resortsmultytable.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.top.resortsmultytable.entity.Resorts;
import org.top.resortsmultytable.repository.ResortsRepository;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("resorts")
public class ResortsController {

    public final ResortsRepository resortsRepository;

    @GetMapping("ping")
    public String ping() { return "resorts pong";}

    @PostMapping("")
    public Resorts add(@RequestBody Resorts resorts) {
        return resortsRepository.save(resorts);
    }

    @GetMapping("")
    public Iterable<Resorts> getAll(){
        return resortsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Resorts> getById(@PathVariable Integer id) {
        return resortsRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public Optional<Resorts> delete(@PathVariable Integer id){
        Optional<Resorts> deleted = resortsRepository.findById(id);
        if(deleted.isPresent()) resortsRepository.deleteById(id);
        return deleted;
    }

    @PatchMapping("")
    public Optional<Resorts> update(@RequestBody Resorts resorts) {
        if(resorts.getId() == null) return Optional.empty();
        Optional<Resorts> updated = resortsRepository.findById(resorts.getId());
        if(updated.isPresent())
            return Optional.of(resortsRepository.save(resorts));
        return Optional.empty();
    }
}
