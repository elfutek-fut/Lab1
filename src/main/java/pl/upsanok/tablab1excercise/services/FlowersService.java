package pl.upsanok.tablab1excercise.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.upsanok.tablab1excercise.controllers.dto.Flower; // Nasze DTO
import pl.upsanok.tablab1excercise.entities.GardenEntity;
import pl.upsanok.tablab1excercise.entities.User;
import pl.upsanok.tablab1excercise.repositories.FlowerRepository;
import pl.upsanok.tablab1excercise.repositories.GardenRepository;
import pl.upsanok.tablab1excercise.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlowersService {

    private final FlowerRepository flowersRepository;
    private final UserRepository userRepository;
    private final GardenRepository gardenRepository;

    // Pobieranie wszystkich kwiatów i mapowanie na DTO
    public List<Flower> getAllFlowers() {
        return flowersRepository.findAll().stream()
                .map(f -> Flower.builder()
                        .id(f.getId())
                        .name(f.getName())
                        .build())
                .collect(Collectors.toList());
    }

    // Pobieranie ulubionego kwiatu (z automatycznym tworzeniem użytkownika)
    public Flower getFavouriteFlowerForUser(String userName) {
        User user = userRepository.findByName(userName);
        if (user == null) {
            user = userRepository.save(User.builder().name(userName).build());
        }

        if (user.getFavouriteFlower() == null) {
            return null;
        }

        return Flower.builder()
                .id(user.getFavouriteFlower().getId())
                .name(user.getFavouriteFlower().getName())
                .build();
    }

    // Pobieranie kwiatów z ogrodu danego użytkownika
    public List<Flower> getFlowersInGardenFor(String userName) {
        return gardenRepository.findByUser_Name(userName).stream()
                .map(garden -> Flower.builder()
                        .id(garden.getFlower().getId())
                        .name(garden.getFlower().getName())
                        .build())
                .collect(Collectors.toList());
    }

    // Sadzenie kwiatka w ogrodzie
    @Transactional
    public boolean saveFlowerInGardenForUser(String userName, String flowerName) {
        User user = userRepository.findByName(userName);
        if (user == null) {
            user = userRepository.save(User.builder().name(userName).build());
        }

        var flower = flowersRepository.findByName(flowerName);
        if (flower != null) {
            gardenRepository.save(GardenEntity.builder()
                    .flower(flower)
                    .user(user)
                    .build());
            return true;
        }
        return false;
    }

    // Ustawianie ulubionego kwiatka
    @Transactional
    public boolean saveFavouriteFlowerFor(String userName, String flowerName) {
        User user = userRepository.findByName(userName);
        var flower = flowersRepository.findByName(flowerName);

        if (user == null || flower == null) return false;

        user.setFavouriteFlower(flower);
        userRepository.save(user);
        return true;
    }
}