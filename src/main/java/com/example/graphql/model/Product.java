package com.example.graphql.model;

import jakarta.persistence.*;

@Table
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String smiles;

    private String formula;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "molecular_weight")
    private double molecularWeight;

    @Column(name = "russian_common_name")
    private String russianCommonName;

    private String description;

    public Product() {
    }

    public Product(String smiles, String formula, String commonName, double molecularWeight, String russianCommonName, String description) {
        this.smiles = smiles;
        this.formula = formula;
        this.commonName = commonName;
        this.molecularWeight = molecularWeight;
        this.russianCommonName = russianCommonName;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSmiles() {
        return smiles;
    }

    public void setSmiles(String smiles) {
        this.smiles = smiles;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public double getMolecularWeight() {
        return molecularWeight;
    }

    public void setMolecularWeight(double molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public String getRussianCommonName() {
        return russianCommonName;
    }

    public void setRussianCommonName(String russianCommonName) {
        this.russianCommonName = russianCommonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
