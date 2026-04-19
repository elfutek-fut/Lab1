/* Stara wersja


package pl.upsanok.tablab1excercise.controllers;


import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.upsanok.tablab1excercise.controllers.dto.Flower;
import pl.upsanok.tablab1excercise.services.FlowersService;

import java.util.List;

@RestController()
@CrossOrigin(origins = {"*"})
//@CrossOrigin(origins = {"https://tab-front-production.up.railway.app"})
// @AllArgsConstructor
//public class FlowersImprovedController {
//
//    @Autowired
//    private FlowersService flowersService;
//
//    @GetMapping("flowers")
//    public ResponseEntity<List<Flower>> getFlowers() {
//        return ResponseEntity.ok(flowersService.getAllFlowers());
//    }
//
//    @GetMapping("flowers/fav/users/{userName}")
//    public ResponseEntity<Flower> getFavForUser(
//            @PathVariable String userName
//    ) {
//        var result = flowersService.getFavouriteFlowerForUser(userName);
//        return ResponseEntity.ok(result);
//    }
//
//    @PostMapping("flowers/fav/users/{userName}")
//    public ResponseEntity<Flower> setNewFavForUser(
//            @PathVariable String userName,
//            @RequestBody Flower flower
//    ) {
//        // 1. Wykonujemy zapis
//        boolean result = flowersService.saveFavouriteFlowerFor(userName, flower.name());
//
//        // 2. Pobieramy aktualny ulubiony kwiatek (żeby upewnić się, że zwracamy to, co jest w bazie)
//        Flower updatedFav = flowersService.getFavouriteFlowerForUser(userName);
//
//        return ResponseEntity.ok(updatedFav);
//    }
//}

public class GardenController {
    @Autowired
    private FlowersService flowersService;

    @GetMapping ("users/{userName}/garden")
    public ResponseEntity<List<Flower>> getGardenFlowersForUser(
            @PathVariable String userName
    ) {
        var result = flowersService.getFlowersInGardenFor(userName);
        return ResponseEntity.ok(result);
    }
    @PostMapping("users/{userName}/garden/flowers/{flowerName}")
    public ResponseEntity<Boolean> plantFlowerInUsersGarden(
            @PathVariable String userName,
            @PathVariable String flowerName
    ) {
        var result = flowersService.saveFlowerInGardenForUser(userName, flowerName);
        return ResponseEntity.ok(result);
    }
}


*/



package pl.upsanok.tablab1excercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.upsanok.tablab1excercise.controllers.dto.Flower;
import pl.upsanok.tablab1excercise.services.FlowersService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class GardenController {

    @Autowired
    private FlowersService flowersService;

    @GetMapping("users/{userName}/garden")
    public ResponseEntity<List<Flower>> getGardenFlowersForUser(
            @PathVariable String userName
    ) {
        var result = flowersService.getFlowersInGardenFor(userName);
        return ResponseEntity.ok(result);
    }

    @PostMapping("users/{userName}/garden/flowers/{flowerName}")
    public ResponseEntity<Boolean> plantFlowerInUsersGarden(
            @PathVariable String userName,
            @PathVariable String flowerName
    ) {
        var result = flowersService.saveFlowerInGardenForUser(userName, flowerName);
        return ResponseEntity.ok(result);
    }
}