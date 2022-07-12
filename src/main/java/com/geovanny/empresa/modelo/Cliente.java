package com.geovanny.empresa.modelo;

public class Cliente extends Persona {
    private String telefono;

    public Cliente(String nombre, Integer edad) {
        this(nombre, edad, "No asignado");
    }
    
    public Cliente(String nombre, Integer edad, String telefono) {
        super(nombre, edad);
        this.telefono = telefono;
    }

    public void mostrar(){
        System.out.printf("%s edad %d años y su telefono es %s %n", getNombre(), getEdad(), telefono);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    

    
}
