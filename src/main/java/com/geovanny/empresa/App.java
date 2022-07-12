package com.geovanny.empresa;

import com.geovanny.empresa.excepciones.MaximoNumeroClientesException;
import com.geovanny.empresa.modelo.Cliente;
import com.geovanny.empresa.modelo.Directivo;
import com.geovanny.empresa.modelo.Empleado;
import com.geovanny.empresa.modelo.Empresa;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Empleado geovanny = new Empleado("Geovanny", 45);
        geovanny.setSueldoBruto(3_000_000.0);
        
        
       
        Directivo juan = new Directivo("Juan", 25);
        juan.setCategoria("Jefe de Desarrollo");
        
        Empleado gustavo = new Empleado("Gustavo", 30);
        Empleado ivan = new Empleado("Ivan R", 25);

        try {
            juan.AgregarSubordinado(gustavo);
            juan.AgregarSubordinado(ivan);
            juan.AgregarSubordinado(geovanny);
        } catch (Exception ex) {
            System.err.println("El Directivo no puede agregar más subordinados");
            return;
        }

        Empresa empresa = new Empresa("Grupo 69", new Empleado[] {
            geovanny, juan, gustavo, ivan});

        try {
            Cliente maria = new Cliente("Maria Adelaida", 30, "3104526398");
            empresa.agregarCliente(maria);
            empresa.agregarCliente(new Cliente("Laura Gutierrez", 28, "3042104567"));
        } catch (MaximoNumeroClientesException ex) {
            System.err.println("Ha ocurrido un error al agregar un cliente\n\t"+ex.getMessage());
            return;
        }finally{
            System.out.println("Clientes agragados");

        }

        // Imprimir
        System.out.printf("La Empresa %s tiene los siguientes empleados: %n", empresa.getNombre());
        for (Empleado empleado : empresa.getEmpleados()) {
            empleado.mostrar();
            if (empleado instanceof Directivo) {
                Directivo directivo = (Directivo)empleado;
                System.out.print("          Y sus subordinados son: ");
                Boolean imprimioSubordinado = false;
                for (Empleado subordinado :directivo.getSubordinados()) {
                    if (subordinado == null) {
                        System.out.print(".");
                        break;
                    }

                    if (imprimioSubordinado) {
                        System.out.print(", ");
                    }

                    System.out.print(subordinado.getNombre());
                    imprimioSubordinado = true;
                }
                System.out.println();
            }
        }

        System.out.println("Y sus clientes son :");
        for (Cliente cliente : empresa.getClientes()) {
            if (cliente == null) {
                break;
            }
            cliente.mostrar();
        }
    }
}
 