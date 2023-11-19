package org.example;

import BaseDatos.*;
import login.*;
import personas.*;
import servicio.*;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, SQLException, ClassNotFoundException {
        // Iniciamos las tablas para hacer las respectivas transacciones
        TablaPlataforma tablaPlataforma = new TablaPlataforma();
        TablaUsuarios tablaUsuarios = new TablaUsuarios();
        TablaPersona tablaPersona = new TablaPersona();
        TablaServicios tablaServicios = new TablaServicios();
        TablaDetalleCompra tablaDetalleCompra = new TablaDetalleCompra();



        // Registramos dos usuarios
        System.out.println("---------- Registrando usuarios nuevos ----------");
        Usuario usuario1 = new Usuario("Maykoll", "Gomez", "maykoll@gmail.com",
                "unillanos");
        Usuario usuario2 = new Usuario("Valentina", "Mesa", "valentina@gmail.com",
                "unillanos");

        Plataforma plataforma1 = new Plataforma(1,"Windows", "10");
        // Guardamos plataforma en la base de datos
        tablaPlataforma.insertar(plataforma1);

        UsuarioRegistrado usuarioRegistrado1 = new UsuarioRegistrado(usuario1, plataforma1);
        UsuarioRegistrado usuarioRegistrado2 = new UsuarioRegistrado(usuario2, plataforma1);
        // Guardamos los usuarios
        tablaUsuarios.insertar(usuarioRegistrado1);
        tablaUsuarios.insertar(usuarioRegistrado2);

        // Login
        System.out.println("--------- Ingresando usuario Maykoll ---------");
        tablaUsuarios.login("maykoll@gmail.com", "unillanos");
        System.out.println("--------- Ingresando usuario incorrecto --------");
        tablaUsuarios.login("Incorrecto@gmai,com", "incorrecto");

        System.out.println("---------- Actualizando nombre de Maykoll a Alexis y consultando ---------");
        tablaUsuarios.actualizar(usuarioRegistrado1, "nombre", "Alexis");
        tablaUsuarios.login("maykoll@gmail.com", "unillanos");

        System.out.println("---------- Eliminando usuario 2 ----------");
        tablaUsuarios.eliminar(usuarioRegistrado2);

        // Creando objetos hijos de Persona
        System.out.println("--------- Creando objetos hijos de persona y guardando ---------");
        Estudiante estudiante1 = new Estudiante(1, "Brayan", 20, "CDE4435");
        Empleado empleado1 = new Empleado(2, "Felipe", 30, "EMP234");
        Docente docente1 = new Docente(3, "Valentina", 30, "DOC236");

        // Guardando en la base de datos
        tablaPersona.insertar(estudiante1);
        tablaPersona.insertar(empleado1);
        tablaPersona.insertar(docente1);

        // Saludando
        estudiante1.saludar();
        empleado1.saludar();
        docente1.saludar();

        // Actualizando nombre de Brayam
        System.out.println("--------- Actualizando nombre Brayan");
        tablaPersona.actualizar(estudiante1, "nombre", "Maykoll");

        System.out.println("--------- Eliminando a Valentina ----------");
        tablaPersona.eliminar(docente1);

        // Consultando personas mayores a 20 años
        System.out.println("---------- Consultando personas mayores a 20 años ----------");
        tablaPersona.consultarMayores(20);


        // Persona Cargo
        System.out.println("---------- Creando cargos ----------");
        Cargo cargo1 = new Cargo("Director");
        Cargo cargo2 = new Cargo("Tutor");
        Empresa empresa1 = new Empresa("Unillanos");
        PersonaCargo personaCargo1 = new PersonaCargo(docente1, cargo1, empresa1);
        PersonaCargo personaCargo2 = new PersonaCargo(estudiante1, cargo2, empresa1);

        personaCargo1.saludar();
        personaCargo2.saludar();


        // Creando ventas de servicio
        System.out.println("---------- Creando Servicios y ventas de servicio ----------");
        // Servicios
        Servicios servicio1 = new Servicios(1, "Biblioteca",
                "Prestamo de libros", 20000);
        Servicios servicio2 = new Servicios(2, "Desarrollo profesional",
                "Curso intensivo", 500000);
        Servicios servicio3 = new Servicios(3, "Consultoria",
                "Realiza consultas", 600000);
        // guardando en base de datos
        tablaServicios.insertar(servicio1);
        tablaServicios.insertar(servicio2);
        tablaServicios.insertar(servicio3);

        // Venta de servicios
        DetalleVentaServicio detalleVentaServicio1 = new DetalleVentaServicio(1,
                "Servicio Publico", servicio1);
        DetalleVentaServicio detalleVentaServicio2 = new DetalleVentaServicio(2,
                "Educacion", servicio2);
        DetalleVentaServicio detalleVentaServicio3 = new DetalleVentaServicio(3,
                "Beneficio", servicio3);

        List<DetalleVentaServicio> servicios1 = new ArrayList<>();
        List<DetalleVentaServicio> servicios2 = new ArrayList<>();

        servicios1.add(detalleVentaServicio1);
        servicios1.add(detalleVentaServicio2);
        servicios2.add(detalleVentaServicio2);
        servicios2.add(detalleVentaServicio3);

        VentaServicio ventaServicio1 = new VentaServicio(1, "Venta1", servicios1,
                estudiante1);
        VentaServicio ventaServicio2 = new VentaServicio(2, "Venta2", servicios2,
                empleado1);

        // Guardando en base de datos
        tablaDetalleCompra.insertar(ventaServicio1);
        tablaDetalleCompra.insertar(ventaServicio2);

        ventaServicio1.mostrarVenta();
        ventaServicio2.mostrarVenta();

        System.out.println("---------- Actualizando nombre de venta1 a Servicios ----------");
        tablaDetalleCompra.actualizar(ventaServicio1, "nomb_venta", "Servicios");

        System.out.println("---------- Eliminando venta de servicio 2 ----------");
        tablaDetalleCompra.eliminar(ventaServicio2);

        System.out.println("---------- Generando factura con consulta en la base de datos de la Servicios ----------");
        tablaDetalleCompra.generarFactura(ventaServicio1);


        // Generar factura
        System.out.println("---------- Generando factura en objetos ----------");
        Facturacion factura1 = new Facturacion(1, ventaServicio1);
        Facturacion factura2 = new Facturacion(2, ventaServicio2);


        // Mostrando factura
        System.out.println("---------- Mostrando factura 1 de objetos ----------");
        factura1.mostrarFactura();


    }
}