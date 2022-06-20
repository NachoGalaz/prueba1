package com.generation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //objeto usuario se convertira en una entidad
@Table(name="casas") // el nombre con el q lo veremos en la base de datos

public class Casa {
    //atributos
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //Long se usa en UsuarioRepository como tipo de dato
    //Cada valor agregamos primary key

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Size(min=10,max=60)
    private String calle;
    
    @Size(min=3,max=20)
    private Integer numero;


    @NotNull
    private String comuna;
    @NotNull
    private String propietario;





    //Constructores
    public Casa() {
    }

    public Casa(Long id, @Size(min = 10, max = 60) String calle, @Size(min = 3, max = 20) Integer numero,
    @NotNull String comuna, @NotNull String propietario) {
this.id = id;
this.calle = calle;
this.numero = numero;
this.comuna = comuna;
this.propietario = propietario;
}



    //Getter y setter

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    
    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    
}
