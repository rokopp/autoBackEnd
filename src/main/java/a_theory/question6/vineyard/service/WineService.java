package a_theory.question6.vineyard.service;

import a_theory.question6.vineyard.Wine;
import a_theory.question6.vineyard.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineService {

    @Autowired
    private WineRepository wineRepository;

    public String updateWine(String region, String grape,
                             String updateRegion, String updateGrape, String updateDescription) {
        List<Wine> wineList = wineRepository.findByRegionAndGrape(region, grape);
        if (wineList.size() == 1) {
            Wine updateWine = wineList.get(0);
            updateWine.setRegion(updateRegion);
            updateWine.setGrape(updateGrape);
            updateWine.setDescription(updateDescription);
            return "Wine update successful";
        }
        return "No wine found";
    }
}
