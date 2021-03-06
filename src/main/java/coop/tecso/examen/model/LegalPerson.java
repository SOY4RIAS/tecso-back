package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "legal_person")
public class LegalPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "foundation_year")
    private Integer foundationYear;

    @Column(name = "rut", unique = true)
    private String rut;

    private Boolean active;

    public LegalPerson() {
    }

    public LegalPerson(String businessName, Integer foundationYear, String rut,
                       Boolean active) {
        this.businessName = businessName;
        this.foundationYear = foundationYear;
        this.rut = rut;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Integer foundationYear) {
        this.foundationYear = foundationYear;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "LegalPerson{" +
                "id=" + id +
                ", businessName='" + businessName + '\'' +
                ", foundationYear=" + foundationYear +
                ", rut='" + rut + '\'' +
                ", active=" + active +
                '}';
    }
}