package com.example.auto24backend.database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Picture {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(unique=true)
    private String fileName;

    private String filePath;

    @ManyToOne
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;


    public Picture(String fileName, String filePath, Advertisement advertisement) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.advertisement = advertisement;
    }
}
