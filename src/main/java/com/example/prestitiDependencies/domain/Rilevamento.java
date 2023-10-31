package com.example.prestitiDependencies.domain;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Rilevamento {
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getImporto() {
        return importo;
    }

    public void setImporto(Double importo) {
        this.importo = importo;
    }

    @ManyToOne
    private Organizzazione organizzazione;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String data;
    private Double importo;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rilevamento that = (Rilevamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Organizzazione getOrganizzazione() {
        return organizzazione;
    }

    public void setOrganizzazione(Organizzazione organizzazione) {
        this.organizzazione = organizzazione;
    }
}
