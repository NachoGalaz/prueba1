package com.generation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Casa;

@Controller
/*esto establece que sea controlador @*/
public class IndexController {
    //http://localhost:8080/
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("Calles", "Irrarrazaval");
        model.addAttribute("Numeros", "123");
        model.addAttribute("Comunas");
        model.addAttribute("Propietarios");
  /*redireccionamiento (ruta a responder) ("/") ruta por default */

//instanciad e usuario
Casa casa = new Casa ();
//Pasando el objeto a la vista (JSP)
model.addAttribute("casa",casa);

        return "index.jsp";
    }




}
