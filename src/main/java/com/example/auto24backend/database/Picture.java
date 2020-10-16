package com.example.auto24backend.database;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @Builder @AllArgsConstructor
public class Picture {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

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
