package a_theory.question6.chocolate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("cake")
@RestController
public class ChocolateController {

    @Autowired
    private Chocolate chocolate;

    @GetMapping
    public List<Cake> findByIngredients(@RequestParam(required = false) List<String> ingredients,
                                        @RequestParam(required = false) List<String> toppings) {
        return chocolate.emptyMethodReturnList();
    }

    @PostMapping
    public Cake addCake(@RequestBody Cake cake) {
       return chocolate.emptyMethodReturn1();
    }

    @PutMapping("{id}")
    public Cake updateCake(@PathVariable long id, @RequestBody Cake cake) {
        //find the cake
        Cake cake1 = chocolate.emptyMethodReturn1();
        //update
        chocolate.emptyMethodVoid();
        //save
        return chocolate.emptyMethodReturn1();
    }
}
