package spring.database.repository;


import spring.database.entity.Company;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
   //Указываем поля в сущности Company с большой буквы. В данном случае, мы хотим искать 
   //по имени
   //Доступные варианты: Optional, Entity, Future
	
    Optional<Company> findByName(@Param("name2") String name);
   
   //Collection
    List<Company> findAllByNameContainingIgnoreCase(String fragment);
   
}