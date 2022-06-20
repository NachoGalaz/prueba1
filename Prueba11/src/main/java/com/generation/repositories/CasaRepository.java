package com.generation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.models.Casa;

@Repository
public interface CasaRepository extends JpaRepository<Casa, Long>{
    // <Objeto,Tipo de dato para FK>
    /** Las interface solo definen los metodos, no implementamos */

    
}
