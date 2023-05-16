
package model;
import control.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Filiere {
    private Connection connection;
    private PreparedStatement prepare;
    private ResultSet result;
    ObservableList list;
    
    private final IntegerProperty id_filiere ;
    private final StringProperty nom_filiere;
    public Filiere(int id,String nom) {
        this.id_filiere=new SimpleIntegerProperty(id);
        this.nom_filiere = new SimpleStringProperty(nom);
        
    }
    
    public int getId_filiere() {
        return id_filiere.get();
    }

    public void setId_filiere(int value) {
        id_filiere.set(value);
    }

    public IntegerProperty id_filiereProperty() {
        return id_filiere;
    }
    

    public String getNom_filiere() {
        return nom_filiere.get();
    }

    public void setNom_filiere(String value) {
        nom_filiere.set(value);
    }

    public StringProperty nom_filiereProperty() {
        return nom_filiere;
    }
    
   
   
    
}
