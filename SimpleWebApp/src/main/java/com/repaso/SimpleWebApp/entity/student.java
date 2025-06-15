package com.repaso.SimpleWebApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
@AllArgsConstructor
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public student(){}

    public student(String nombre, String apellido,String direccion,String telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

}
