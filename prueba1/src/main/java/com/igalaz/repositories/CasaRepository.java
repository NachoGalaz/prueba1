package com.igalaz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igalaz.models.Casa;

@Repository
public interface CasaRepository extends JpaRepository<Casa,Long> {
    
}
