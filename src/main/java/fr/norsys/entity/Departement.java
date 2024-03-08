package fr.norsys.entity;


import javax.persistence.*;

@Entity
@Table(name = "departements")
public class Departement {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="nom")
    private String nom;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }
}
