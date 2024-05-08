package br.com.fiap.traffic.model;

import java.util.Objects;

public class Street {

    private Long id;
    private String cep;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(id, street.id) && Objects.equals(cep, street.cep) && Objects.equals(name, street.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, name);
    }
}
