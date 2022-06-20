package com.generation.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


import com.generation.models.Casa;
import com.generation.services.CasaService;

@Controller
@RequestMapping("/registro")
public class RegistroController {
    @Autowired 
    CasaService casaService;
//siempre que quiera hacer una importacion de dependencias de otro 
//hay que usar autowired

    //Ruta para desplegar el jsp
    @RequestMapping("") //localhost:8080/registro
    public String registro(@ModelAttribute("casa") Casa casa){
        //ModelAttribute debe ir con lo mismo que tiene dentro en registro.jsp
        return "registro.jsp"; //pagina a desplegar
    }
    

    //Ruta para capturar los datos del formulario
    /*  @PostMapping("/usuario") //localhost:8080/registro/usuario
    //SE CAMBIO RequestMapping por PostMapping con lo que no se ve en la URL
    public String registroUsuario( @RequestParam(value= "nombre") String nombre ,  
    //en value debemos poner lo q va dentro de cada "name"  en registro.jsp 
                @RequestParam(value = "apellido") String apellido ,
                @RequestParam(value = "edad") String edad
                ) {
        System.out.println("Estamos en el metodo de registro de usuario " + nombre);
        System.out.println("Estamos en el metodo de registro de usuario " + apellido);
        System.out.println("Estamos en el metodo de registro de usuario " + edad);
        //Solo para visualizarlo en consola
        return "registro.jsp"; //pagina a desplegar
    }*/

    @PostMapping("/casa")
    public String guardarCasa(@Valid @ModelAttribute("casa") Casa casa,BindingResult resultado,
    Model model){
        //Para que funcione el Valid se agrega anotacion ,BindinResult resultado
        //BindinResult va al objeto usuario y ve si todos los atributos cumplen con las condiciones (notnull,size)
        if(resultado.hasErrors()){
         model.addAttribute("msgError","Debe realizar ingreso correcto de los datos");   //Capturando si existe un error en el ingreso de datos desde el .jsp
        return "registro.jsp";

        }else{

        //Enviar el objero al service
        casaService.saveCasa(casa);


        return "index.jsp";
    }
    
}
}
