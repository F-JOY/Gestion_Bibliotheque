
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Utilisateur {
    private final IntegerProperty id_utilisateur;
    private final StringProperty nom_utilisateur;
    private final StringProperty password ;
  
    public Utilisateur(int id,String nom_utilisateur,String password) {
        this.id_utilisateur=new SimpleIntegerProperty(id);
        this.nom_utilisateur = new SimpleStringProperty(nom_utilisateur);
        this.password= new SimpleStringProperty(password);
    }
    

    public int getId_utilisateur() {
        return id_utilisateur.get();
    }

    public void setId_utilisateur(int value) {
        id_utilisateur.set(value);
    }

    public IntegerProperty id_utilisateurProperty() {
        return id_utilisateur;
    }
    

    public String getNom_utilisateur() {
        return nom_utilisateur.get();
    }

    public void setNom_utilisateur(String value) {
        nom_utilisateur.set(value);
    }

    public StringProperty nom_utilisateurProperty() {
        return nom_utilisateur;
    }
  

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String value) {
        password.set(value);
    }

    public StringProperty passwordProperty() {
        return password;
    }
    
}
