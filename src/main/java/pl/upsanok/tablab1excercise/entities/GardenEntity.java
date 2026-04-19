package pl.upsanok.tablab1excercise.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users_flowers")
@IdClass(GardenId.class)
@Getter
@Setter
@Builder
@NoArgsConstructor // Bardzo ważne dla Hibernate
@AllArgsConstructor
public class GardenEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "flower_id")
    private Flower flower; // Zmienione z flowerEntity na flower

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Zmienione z userEntity na user
}