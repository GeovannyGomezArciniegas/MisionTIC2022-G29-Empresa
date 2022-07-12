package com.geovanny.empresa.modelo;

import com.geovanny.empresa.excepciones.MaximoNumeroSubordinadosException;

public class Directivo extends Empleado{

    private static final String CATEGORIA_POR_DEFECTO = "No Asignado";
    private static final Integer CANTIDAD_SUBORDIANDOS = 2;

    private String categoria;

    private Empleado[] subordinados;
    private Integer numSubordinados;
    
    public Directivo(String nombre, Integer edad) {
        this(nombre, edad, SUELDO_POR_DEFECTO);
        //TODO Auto-generated constructor stub
    }

    public Directivo(String nombre, Integer edad, Double sueldoBruto) {
        this(nombre, edad, sueldoBruto, CATEGORIA_POR_DEFECTO);
    }

    public Directivo(String nombre, Integer edad, String categoria) {
        this(nombre, edad, SUELDO_POR_DEFECTO, categoria);
        this.categoria = categoria;
    }
    
    public Directivo(String nombre, Integer edad, Double sueldoBruto, String categoria) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;

        this.subordinados = new Empleado[CANTIDAD_SUBORDIANDOS];
        this.numSubordinados = 0;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Empleado[] getSubordinados() {
        return subordinados;
    }
    
    @Override
    public Double getSueldoBruto() {
        return super.getSueldoBruto() +100_000d;
    }


    @Override
    public void mostrar() {        
        System.out.printf("El Directivo de nombre %s tiene %d años, un sueldo de %,.2f y su categoria es %s %n", getNombre(),getEdad(), getSueldoBruto(), categoria);
    }

    /**
     * @param empleado
     */
    public void AgregarSubordinado(Empleado empleado) {
        if (numSubordinados >= CANTIDAD_SUBORDIANDOS){
            throw new MaximoNumeroSubordinadosException();
        }

        subordinados[numSubordinados++] = empleado;
        }
 
}
