package pl.upsanok.tablab1excercise.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.upsanok.tablab1excercise.controllers.dto.Flower;
import pl.upsanok.tablab1excercise.entities.User;
import pl.upsanok.tablab1excercise.repositories.FlowerRepository;
import pl.upsanok.tablab1excercise.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlowersService {

    private final FlowerRepository flowersRepository;
    private final UserRepository userRepository;

    // a) Pobieranie wszystkich kwiatów do listy na stronie
    public List<Flower> getAllFlowers() {
        List<pl.upsanok.tablab1excercise.entities.Flower> entities = flowersRepository.findAll();
        List<Flower> result = new ArrayList<>();

        for (pl.upsanok.tablab1excercise.entities.Flower f : entities) {
            result.add(
                    Flower.builder()
                            .name(f.getName())
                            .build()
            );
        }
        return result;
    }

    // b) Pobieranie ulubionego kwiatu użytkownika - ZAKTUALIZOWANE
    public Flower getFavouriteFlowerForUser(String userName) {
        List<User> users = userRepository.findAll();

        for (User u : users) {
            if (u.getName().equals(userName)) {
                // Pobieramy zapisanego u użytkownika ID ulubionego kwiatka
                Integer favId = u.getFavouriteFlowerId();

                if (favId != null) {
                    // Szukamy w bazie kwiatka o tym konkretnym ID
                    Optional<pl.upsanok.tablab1excercise.entities.Flower> flowerEntity =
                            flowersRepository.findById(favId);

                    if (flowerEntity.isPresent()) {
                        return Flower.builder()
                                .name(flowerEntity.get().getName())
                                .build();
                    }
                }
            }
        }
        // Jeśli nie znaleziono usera lub nie ma on kwiatka, zwracamy pusty obiekt DTO
        return Flower.builder().build();
    }

    // c) Zapisywanie ulubionego kwiatu dla użytkownika - ZAKTUALIZOWANE
    public boolean saveFavouriteFlowerFor(String userName, String flowerName) {
        System.out.println(">>> Serwis zapisuje: User=[" + userName + "], Kwiat=[" + flowerName + "]");

        // 1. Znajdź lub stwórz użytkownika
        List<User> users = userRepository.findAll();
        User user = null;

        for (User u : users) {
            if (u.getName().equals(userName)) {
                user = u;
                break;
            }
        }

        if (user == null) {
            user = new User();
            user.setName(userName);
            user = userRepository.save(user); // Zapisujemy, by baza nadała ID
        }

        // 2. Znajdź ID kwiatka na podstawie nazwy wysłanej z Frontendu
        List<pl.upsanok.tablab1excercise.entities.Flower> allFlowers = flowersRepository.findAll();

        for (pl.upsanok.tablab1excercise.entities.Flower f : allFlowers) {
            if (f.getName().equalsIgnoreCase(flowerName)) {

                // 3. ZAPISUJEMY UŻYTKOWNIKA (bo to on ma kolumnę favourite_flower_id)
                user.setFavouriteFlowerId(f.getId());
                userRepository.save(user);

                System.out.println(">>> Pomyślnie przypisano kwiatek o ID " + f.getId() + " użytkownikowi " + userName);
                return true;
            }
        }

        return false;
    }
}