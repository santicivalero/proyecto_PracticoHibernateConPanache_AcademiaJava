package com.santi.sistemalibrospanache.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.util.List;

@Entity
public class Libro extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String titulo;

    public static List<Libro> buscarPorTitulo(String texto) {
        return find("titulo LIKE ?1", "%" + texto + "%").list();
    }

    @Override
    public String toString() {
        return "Libro{id=" + id + ", titulo='" + titulo + "'}";
    }
}
