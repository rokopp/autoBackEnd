package a_theory.question6.vineyard.repository;

import a_theory.question6.vineyard.database.Wine;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends PagingAndSortingRepository {

    List<Wine> findByRegionAndName(String region, String name);
    List<Wine> findByRegionAndGrape(String region, String grape);

    List<Wine> findByYearAndName(Integer year, String name);
    List<Wine> findByYearAndGrape(Integer year, String grape);

    List<Wine> findByName(String name);
    List<Wine> findByGrape(String grape);

}
