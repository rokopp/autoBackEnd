package a_theory.question6.vineyard.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class WineDto {
    private Long id;

    private String name;

    private String region;

    private String grape;

    private Integer year;
}
