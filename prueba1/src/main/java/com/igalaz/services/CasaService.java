package com.igalaz.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igalaz.models.Casa;
import com.igalaz.repositories.CasaRepository;

@Service
public class CasaService {
    @Autowired
    CasaRepository casaRepository;
//Guardar una casa
    public void guardarCasa(@Valid Casa casa) {
        casaRepository.save(casa);
    }

    //lista casas
    public List<Casa> findAll() {
        return casaRepository.findAll();
        
    }

    public Casa buscarId(Long id) {
		return casaRepository.findById(id).get();//.get() especifica el tipo de datos que necesitamos
	}
	
	public void eliminarPorId(Long id) {
		
		casaRepository.deleteById(id);
	}

    
}
