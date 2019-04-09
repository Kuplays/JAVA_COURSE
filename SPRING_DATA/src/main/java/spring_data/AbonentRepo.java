package ru.sibguti.kuplays;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "abonents", path = "abonents")
public interface AbonentRepo extends PagingAndSortingRepository<Abonent, Long> {

	List<Abonent> findByNameDetails(@Param("nameDetails") String nameDetails);

}