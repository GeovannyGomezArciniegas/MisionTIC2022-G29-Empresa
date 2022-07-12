package com.geovanny.empresa.modelo;

import com.geovanny.empresa.excepciones.MaximoNumeroClientesException;

public class Empresa {

    private static final Integer CANTIDAD_CLIENTES = 1;

    private String nombre;

    private Empleado[] empleados;
    private Cliente[] clientes;
    private Integer numClientes;

    public Empresa(String nombre, Empleado[] empleados) {
        this.nombre = nombre;
        this.empleados = empleados;

        this.clientes = new Cliente[CANTIDAD_CLIENTES];
        this.numClientes = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) throws MaximoNumeroClientesException{
        //Valido
        if (numClientes >= CANTIDAD_CLIENTES) {
            throw new MaximoNumeroClientesException("La Empresa no puede agregar un Cliente más");
        }

        //Proceso

        /*en esta variable "numClientes++" lo que se hace es que se utiliza la 
        * variable y luego se aumenta "++"
        */
        clientes[numClientes++] = cliente;
        
    }

    
}   

