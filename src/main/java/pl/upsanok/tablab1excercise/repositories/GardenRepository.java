package pl.upsanok.tablab1excercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.upsanok.tablab1excercise.entities.GardenEntity;
import pl.upsanok.tablab1excercise.entities.GardenId;

import java.util.List;

@Repository
public interface GardenRepository extends JpaRepository<GardenEntity, GardenId> {
    // Używamy podkreślnika (User_Name), aby wskazać pole 'name' wewnątrz encji 'User'
    List<GardenEntity> findByUser_Name(String userName);
}