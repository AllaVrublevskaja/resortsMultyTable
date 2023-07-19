package org.top.resortsmultytable.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "resorts_t")
@Getter
@Setter
public class Resorts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "resorts_f")
    private String resorts;

    @Column(name = "price_f")
    private double price;

    @OneToOne
    @JoinColumn(name = "rate_id")
    private Rate rate;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Override
    public String toString() { return id + " - " + resorts;}
}
