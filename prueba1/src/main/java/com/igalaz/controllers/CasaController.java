package com.igalaz.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igalaz.models.Casa;
import com.igalaz.services.CasaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/casa")
public class CasaController {
    @Autowired
    CasaService casaService;
    
    @RequestMapping("")
    public String inicio(@ModelAttribute("casa") Casa casa){
        return "casa.jsp";
    }

    @PostMapping("/guardar")
    public String guardarCasa(@Valid @ModelAttribute("casa") Casa casa,
    BindingResult resultado, //corroborar que las tag de model se cumplan
    Model model){
        if(resultado.hasErrors()){
            model.addAttribute("msgError", "Datos erroneos");
            return "casa.jsp";
            //si el resultado tiene errores es decir hay datos mal ingresados vuelve a la pagina de ingreso de datos
        }else{
                //enviar objeto a base de datos
                casaService.guardarCasa(casa);
                //lista de casas
                List<Casa> listaCasas = casaService.findAll();
                //lista a jsp
                model.addAttribute("casasCapturadas", listaCasas);
                return "mostrarCasas.jsp"; //muestra tabla
    }
    }


}

