package org.top.resortsmultytable.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rate_t")
@Getter
@Setter
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rate_f")
    private String rate;

    @OneToOne
    @JsonIgnore
    private Resorts resorts;

    @Override
    public String toString(){ return id + " - " + rate;}
}
