package com.example.auto24backend.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @Builder
@AllArgsConstructor
public class CarMark {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String carMark;

    @OneToOne(mappedBy = "carMark", cascade = CascadeType.ALL)
    @JsonIgnore
    private Advertisement advertisement;

    public CarMark(String carMark) {
        this.carMark = carMark;
    }

}
