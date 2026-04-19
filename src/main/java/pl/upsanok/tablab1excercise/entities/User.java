package pl.upsanok.tablab1excercise.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    // Zmieniamy na EAGER, aby uniknąć LazyInitializationException podczas mapowania w serwisie
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "favourite_flower_id")
    private Flower favouriteFlower;
}