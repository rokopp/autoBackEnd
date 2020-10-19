package a_theory.question6.vineyard.service;

import a_theory.question6.vineyard.database.Wine;
import a_theory.question6.vineyard.repository.WineRepository;
import com.example.auto24backend.database.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineService {

    @Autowired
    private WineRepository wineRepository;

    public String updateWine(String region, String grape, String description,
                             String updateRegion, String updateGrape, String updateDescription) {
        List<Wine> wineList = wineRepository.findByRegionAndGrape(region, grape);
        if (wineList.size() == 1) {
            Wine updateWine = wineList.get(0);
            updateWine.setRegion(updateRegion);
            updateWine.setGrape(grape);
            updateWine.setDescription(updateDescription);
            return "Wine update successful";
        }
        return "No wine found";
    }


    public List<Wine> findByRegionAndName(String region, String name) {
        return wineRepository.findByRegionAndName(region, name);
    }

    public List<Wine> findByRegionAndGrape(String region, String grape) {
        return wineRepository.findByRegionAndGrape(region, grape);
    }

    public List<Wine> findByYearAndName(Integer year, String name) {
        return wineRepository.findByYearAndName(year, name);
    }

    public List<Wine> findByYearAndGrape(Integer year, String grape) {
        return wineRepository.findByYearAndGrape(year, grape);
    }

    public List<Wine> findByName(String name) {
        return wineRepository.findByName(name);
    }

    public List<Wine> findByGrape(String grape) {
        return wineRepository.findByGrape(grape);
    }
}
