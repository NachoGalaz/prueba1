package com.generation.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Casa;
import com.generation.repositories.CasaRepository;
/** Logica de negocio, o validaciones sistema */
/**LLamar al repository y sus metodos para q traigan info */
@Service 
public class CasaService {
    @Autowired
    CasaRepository casaRepository;

    public void saveCasa( @Valid Casa casa) {
        casaRepository.save(casa);
    }

    public CasaService() {
    }



    public CasaService(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }
    public CasaRepository getCasaRepository() {
        return casaRepository;
    }
    public void setCasaRepository(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }
    

}
