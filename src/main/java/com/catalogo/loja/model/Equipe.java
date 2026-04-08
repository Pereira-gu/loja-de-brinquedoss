package com.catalogo.loja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foto;
    private String nome;
    private String rgm;

    public Equipe() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getRgm() { return rgm; }
    public void setRgm(String rgm) { this.rgm = rgm; }
}