package pl.upsanok.tablab1excercise.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Usunąłem nadmiarowe @Column, @Id wystarczy

    @Column(name = "name", nullable = false)
    private String name;

    // TO POLE JEST KLUCZOWE: Odpowiada kolumnie w Twoim SQL
    @Column(name = "favourite_flower_id")
    private Integer favouriteFlowerId;

    // Gettery i settery
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Dodane Gettery i Settery dla kwiatka
    public Integer getFavouriteFlowerId() {
        return favouriteFlowerId;
    }

    public void setFavouriteFlowerId(Integer favouriteFlowerId) {
        this.favouriteFlowerId = favouriteFlowerId;
    }
}