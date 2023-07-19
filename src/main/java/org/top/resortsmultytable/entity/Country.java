package org.top.resortsmultytable.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "country_t")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "country_f")
    private String country;

    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<City> city;

    @Override
    public String toString(){ return id + " - " + country;}
}
