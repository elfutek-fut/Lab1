package pl.upsanok.tablab1excercise.controllers.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor // Dodaj to!
@AllArgsConstructor // Dodaj to!
public class Flower {
    private Integer id;
    private String name;
}