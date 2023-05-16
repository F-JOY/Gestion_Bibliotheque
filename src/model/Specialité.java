
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Specialité {

    private final IntegerProperty id_specialité;
    private final StringProperty nom_specialité ;
    public Specialité(int id,String nom) {
        this.id_specialité=new SimpleIntegerProperty(id);
        this.nom_specialité=new SimpleStringProperty(nom);
        
    }

    public int getId_specialité() {
        return id_specialité.get();
    }

    public void setId_specialité(int value) {
        id_specialité.set(value);
    }

    public IntegerProperty id_specialitéProperty() {
        return id_specialité;
    }
    

    public String getNom_specialité() {
        return nom_specialité.get();
    }

    public void setNom_specialité(String value) {
        nom_specialité.set(value);
    }

    public StringProperty nom_specialitéProperty() {
        return nom_specialité;
    }
    
}
