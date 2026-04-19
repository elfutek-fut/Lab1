package pl.upsanok.tablab1excercise.entities;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class GardenId implements Serializable {
    // Nazwy pól muszą być identyczne jak nazwy pól @Id w GardenEntity
    private int flower;
    private int user;
}