
package pl.upsanok.tablab1excercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.upsanok.tablab1excercise.controllers.dto.Flower;
import pl.upsanok.tablab1excercise.services.FlowersService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class FlowersImprovedController {

    @Autowired
    private FlowersService flowersService;

    @GetMapping("flowers")
    public ResponseEntity<List<Flower>> getFlowers() {
        return ResponseEntity.ok(flowersService.getAllFlowers());
    }

    @GetMapping("flowers/fav/users/{userName}")
    public ResponseEntity<Flower> getFavForUser(@PathVariable String userName) {
        var result = flowersService.getFavouriteFlowerForUser(userName);
        if (result == null) {
            return ResponseEntity.ok(Flower.builder().build());
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("flowers/fav/users/{userName}")
    public ResponseEntity<Flower> setNewFavForUser(
            @PathVariable String userName,
            @RequestBody Flower flowerDTO // Odbieramy Flower z Frontendu
    ) {
        // Zapisujemy w bazie
        flowersService.saveFavouriteFlowerFor(userName, flowerDTO.getName());

        // Pobieramy zaktualizowany obiekt, żeby go zwrócić
        Flower updatedFav = flowersService.getFavouriteFlowerForUser(userName);
        return ResponseEntity.ok(updatedFav);
    }
}