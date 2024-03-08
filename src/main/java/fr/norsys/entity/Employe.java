package fr.norsys.entity;
import javax.persistence.*;

@Entity
@Table(name="employes")

public class Employe {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
