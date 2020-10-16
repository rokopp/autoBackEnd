package com.example.auto24backend.database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @Builder @AllArgsConstructor
public class Advertisement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 6)
    private String carSerialNr;

    private String description;

    @Column(length = 7)
    private Integer price;

    @OneToOne
    @JoinColumn(name = "car_mark_id")
    private CarMark carMark;

    @ManyToOne
    @JoinColumn(name = "uploader_id")
    private Account account;

    @OneToMany(mappedBy = "advertisement", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Picture> pictures;

    public Advertisement(String carSerialNr, String description, Integer price, CarMark carMark, Account account) {
        this.carSerialNr = carSerialNr;
        this.description = description;
        this.price = price;
        this.carMark = carMark;
        this.account = account;
    }
}
