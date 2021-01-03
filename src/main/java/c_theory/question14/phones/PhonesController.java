package c_theory.question14.phones;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("phones")
@RestController
public class PhonesController {

    //todo for question 14 there are 4 assignments in total
    // Each person has to do only 1. So 2 person team has to do 2 different ones, 3 person - 3, 4 person - 4.
    // Make sure to commit under your user otherwise points won't count.
    // I didn't number these so you can pick your favorite

    //todo
    // You are creating a rest controller for lessons. Think of a phone shop.
    // You need to add necessary annotations and methods to this class.
    // This class should compile.
    // It should run successfully when moved to your application package.
    // Method body is not important and will not be graded.
    // Modifying other classes is unnecessary and will not be graded.

    //todo A add necessary annotations on the class

    //todo B create a method to query phones (plural)

    @GetMapping
    public List<Phone> getPhones() {
        return null;
    }

    //todo C create a method to query single phone

    @GetMapping("{name}")
    public Phone getPhone(@PathVariable String name) {
        return null;
    }

    //todo D create a method to save a phone

    @PostMapping
    public Phone savePhone(@RequestBody Phone phone) {
        return null;
    }

    //todo E create a method to update a phone

    @PutMapping("{name}")
    public Phone updatePhone(@RequestBody Phone phone, @PathVariable String name) {
        return null;
    }

    //todo F create a method to delete a phone

    @DeleteMapping("{name}")
    public void deletePhone(@PathVariable String name) {
    }

    //todo G assuming each phone has apps installed (one-to-many relation) create a method to query phone's apps

    @GetMapping("apps")
    public List<App> getApps() {
        return null;
    }

    //todo H create a method to update phone's price (and nothing else)

    @PutMapping("{name}/{price}")
    public Phone updatePrice(@PathVariable String name, @PathVariable int price) {
        return null;
    }

    //todo I modify correct method to support searching by manufacturer while keeping original functionality

    @GetMapping
    public List<Phone> getPhones(@RequestParam(value = "manufacturer", required = false) String manufacturer) {
        return null;
    }

    //todo J modify correct method to support searching by price range: priceFrom-priceTo while keeping original functionality

    @GetMapping
    public List<Phone> getPhones(@RequestParam(value = "start", required = false) int start,
                                 @RequestParam(value = "end", required = false) int end) {
        return null;
    }

    //todo K modify correct method to order/sort chairs
    // * by latest released date first
    // * by earliest released date first
    // (you can assume that by default it searches most popular first)

    @GetMapping
    public List<Phone> getPhones(@RequestParam(value = "order", defaultValue = "releaseDate", required = false
                                            ) LocalDate order) {
        return null;
    }

    @GetMapping
    public List<Phone> getPhones(@RequestParam(value = "direction", defaultValue = "DESC", required = false)
                                             Sort.Direction releaseDate) {
        return null;
    }
}
