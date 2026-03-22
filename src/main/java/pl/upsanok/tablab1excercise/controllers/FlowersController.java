//package pl.upsanok.tablab1excercise.controllers;
//
//import java.util.List;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import pl.upsanok.tablab1excercise.controllers.dto.Flower;
//import pl.upsanok.tablab1excercise.services.FlowersService;
//
//@RestController
//@AllArgsConstructor
//@CrossOrigin(origins = {"*"})
//public class FlowersController {
//
//    private final FlowersService flowersService;
//
//    @GetMapping("flowers")
//    public ResponseEntity<List<Flower>> getFlowers() {
//        return ResponseEntity.ok(flowersService.getAllFlowers());
//    }
//
//    @GetMapping("flowers/fav/users/{userName}")
//    public ResponseEntity<Flower> getFavouriteFlower(@PathVariable String userName) {
//        return ResponseEntity.ok(
//                flowersService.getFavouriteFlowerForUser(userName)
//        );
//    }
//
//    @PostMapping("flowers/fav")
//    public ResponseEntity<Boolean> saveFavouriteFlower(
//            @RequestParam String userName,
//            @RequestBody Flower flower
//    ) {
//
//        boolean result = flowersService.saveFavouriteFlowerFor(
//                userName,
//                flower.name()
//        );
//
//        return ResponseEntity.ok(result);
//    }
//}