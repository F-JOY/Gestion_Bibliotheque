
package model;

import control.DBconnect;
import java.sql.Connection;
import java.sql.Statement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.*;

public class Bibliothecaire extends Utilisateur{
    private final StringProperty nom_biblio;
    private final StringProperty prenom_biblio ;
    private final StringProperty adresse_biblio ;
    private final StringProperty email_biblio ;
    private final IntegerProperty numTel_biblio;
    public Bibliothecaire(int id, String nom_utilisateur, String password,
            String nom,String prenom,String adresse,String email,int numTel) 
    {
        super(id,nom_utilisateur, password);
        this.nom_biblio=new SimpleStringProperty(nom);
        this.prenom_biblio=new SimpleStringProperty(prenom);
        this.adresse_biblio= new SimpleStringProperty(adresse);
        this.email_biblio=new SimpleStringProperty(email);
        this.numTel_biblio=new SimpleIntegerProperty(numTel);
    }
    

    public String getNom_biblio() {
        return nom_biblio.get();
    }

    public void setNom_biblio(String value) {
        nom_biblio.set(value);
    }

    public StringProperty nom_biblioProperty() {
        return nom_biblio;
    }
   

    public String getPrenom_biblio() {
        return prenom_biblio.get();
    }

    public void setPrenom_biblio(String value) {
        prenom_biblio.set(value);
    }

    public StringProperty prenom_biblioProperty() {
        return prenom_biblio;
    }
    

    public String getAdresse_biblio() {
        return adresse_biblio.get();
    }

    public void setAdresse_biblio(String value) {
        adresse_biblio.set(value);
    }

    public StringProperty adresse_biblioProperty() {
        return adresse_biblio;
    }
    

    public String getEmail_biblio() {
        return email_biblio.get();
    }

    public void setEmail_biblio(String value) {
        email_biblio.set(value);
    }

    public StringProperty email_biblioProperty() {
        return email_biblio;
    }
    

    public int getNumTel_biblio() {
        return numTel_biblio.get();
    }

    public void setNumTel_biblio(int value) {
        numTel_biblio.set(value);
    }

    public IntegerProperty numTel_biblioProperty() {
        return numTel_biblio;
    }
    
    public boolean comparerMdp(Object a,Object b){
        return Objects.equals(a, b);
    }
    
    public void getbibliothecaire(){
    System.out.println(nom_biblio+" "+prenom_biblio);
    }
public void ajouterBibliothecaire(Bibliothecaire model) {
    try {
        String query = "INSERT INTO utilisateur (Nom_utilisateur, Mot_de_pass, Nom_biblio, Prénom_biblio, Adresse_biblio, Email_biblio, Num_tel_biblio, Discriminator) " +
                "VALUES ('" + model.getNom_utilisateur() + "', " +
                "'" + model.getPassword() + "', " +
                "'" + model.getNom_biblio() + "', " +
                "'" + model.getPrenom_biblio() + "', " +
                "'" + model.getAdresse_biblio() + "', " +
                "'" + model.getEmail_biblio() + "', " +
                model.getNumTel_biblio() + ", " +
                "'biblio')";
        DBconnect db = new DBconnect();
        try (Connection connection = db.ConnectBd()) {
            Statement state = connection.createStatement();
            state.executeUpdate(query);
            System.out.println("Added Bibliothecaire");
            state.close();
        }
    } catch (Exception e) {
        System.out.println("Failed to add biblio");
        System.out.println(e.getMessage());
        System.out.println(e.getCause());
    }
}
    
}
