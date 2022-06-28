package com.igalaz.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	//solo mostrar el listado de autos
	@RequestMapping("/mostrar")
	public String mostrar(Model model) {
		//obtener una lista de Casas
		List<Casa> listaCasas = casaService.findAll();
		//pasamos la lista de autos al jsp
		model.addAttribute("casasCapturadas", listaCasas);
		return "mostrarCasas.jsp";
	}

    @RequestMapping("/editar/{id}") //editar para el despliegue 
	public String editar(@PathVariable("id") Long id,
			Model model) {
		System.out.println("el id es: "+id);
		
		Casa casa = casaService.buscarId(id);
		model.addAttribute("casa", casa);//pasar al jsp
		
		return "editarCasa.jsp";//redireccionar a otra url o path
	} 
	
	@PostMapping("/actualizar/{id}")
	public String actualizarCasa(@PathVariable("id") Long id,@Valid @ModelAttribute("casa") Casa casa,
			BindingResult resultado,
			Model model) {
		System.out.println("el id al actualizar es: "+id +" getId "+casa.getId());
		

		if(resultado.hasErrors()) {
			model.addAttribute("msgError","Datos erroneos");
			return "editarCasa.jsp";
		}else {
			casa.setId(id); //-> agregar el id al objeto
			
			//enviamos el obeto a persistir en base datos
			casaService.guardarCasa(casa);
			
			return "redirect:/casa/mostrar";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarCasa(@PathVariable("id") Long id) {
		
		casaService.eliminarPorId(id);
		
		return "redirect:/casa/mostrar";
		
	}
	


}

