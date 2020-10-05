package com.example.auto24backend.database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class CarMark {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(unique=true)
    private String carMark;

    @OneToOne(mappedBy = "car_mark", cascade = CascadeType.ALL)
    private Advertisement advertisement;

    public CarMark(String carMark) {
        this.carMark = carMark;
    }
}
