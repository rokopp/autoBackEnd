package a_theory.question6.vineyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WineController {

    @Autowired
    private Vineyard vineyard;

    @GetMapping
    public List<Wine> findWineByRegionGrapeNameYear(@RequestBody(required = false) String region,
                                                    @RequestBody(required = false) String grape,
                                                    @RequestBody(required = false) String name,
                                                    @RequestBody(required = false) int year) {
        return vineyard.emptyMethodReturnList();
    }

    @PutMapping("{id}")
    public Wine updateWine(@PathVariable long id, @RequestBody Wine wineUpdate) {
        Wine wineSearch = vineyard.emptyMethodReturn1();
        vineyard.emptyMethodVoid();
        return vineyard.emptyMethodReturn1();
    }
}
