package a_theory.question6.vineyard.controller;

import a_theory.question6.vineyard.Wine;
import a_theory.question6.vineyard.service.WineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WineController {

    @Autowired
    private WineService wineService;

    @RequestMapping(value = "update/wine", method = RequestMethod.POST)
    public String updateWine(@RequestBody String update) throws JsonProcessingException {
        Wine wine = new ObjectMapper().readValue(update, Wine.class);
        return wineService.updateWine(wine.getRegion(), wine.getGrape(),
                wine.getRegion(), wine.getGrape(), wine.getDescription());
    }
}
