
package model;

import control.DBconnect;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Lecteur {

    private final IntegerProperty id_lecteur = new SimpleIntegerProperty();
    private final StringProperty nom_lecteur = new SimpleStringProperty();
    private final StringProperty prenom_lecteur = new SimpleStringProperty();
    private final StringProperty adresse_lecteur = new SimpleStringProperty();
    private final StringProperty email_lecteur = new SimpleStringProperty();
    private final StringProperty numTel_lecteur = new SimpleStringProperty();
    private final StringProperty datenaiss_lecteur = new SimpleStringProperty();
    private final StringProperty type_lecteur = new SimpleStringProperty();
    private final StringProperty paiment_lecteur = new SimpleStringProperty();
    private final StringProperty dateA_lecteur = new SimpleStringProperty();

    public String getDateA_lecteur() {
        return dateA_lecteur.get();
    }

    public void setDateA_lecteur(String value) {
        dateA_lecteur.set(value);
    }

    public StringProperty dateA_lecteurProperty() {
        return dateA_lecteur;
    }

    public String getPaiment_lecteur() {
        return paiment_lecteur.get();
    }

    public void setPaiment_lecteur(String value) {
        paiment_lecteur.set(value);
    }

    public StringProperty paiment_lecteurProperty() {
        return paiment_lecteur;
    }

    public String getType_lecteur() {
        return type_lecteur.get();
    }

    public void setType_lecteur(String value) {
        type_lecteur.set(value);
    }

    public StringProperty type_lecteurProperty() {
        return type_lecteur;
    }

    public String getDatenaiss_lecteur() {
        return datenaiss_lecteur.get();
    }

    public void setDatenaiss_lecteur(String value) {
        datenaiss_lecteur.set(value);
    }

    public StringProperty datenaiss_lecteurProperty() {
        return datenaiss_lecteur;
    }

    public String getNumTel_lecteur() {
        return numTel_lecteur.get();
    }

    public void setNumTel_lecteur(String value) {
        numTel_lecteur.set(value);
    }

    public StringProperty numTel_lecteurProperty() {
        return numTel_lecteur;
    }

    public String getEmail_lecteur() {
        return email_lecteur.get();
    }

    public void setEmail_lecteur(String value) {
        email_lecteur.set(value);
    }

    public StringProperty email_lecteurProperty() {
        return email_lecteur;
    }

    public String getAdresse_lecteur() {
        return adresse_lecteur.get();
    }

    public void setAdresse_lecteur(String value) {
        adresse_lecteur.set(value);
    }

    public StringProperty adresse_lecteurProperty() {
        return adresse_lecteur;
    }

    public String getPrenom_lecteur() {
        return prenom_lecteur.get();
    }

    public void setPrenom_lecteur(String value) {
        prenom_lecteur.set(value);
    }

    public StringProperty prenom_lecteurProperty() {
        return prenom_lecteur;
    }

    public String getNom_lecteur() {
        return nom_lecteur.get();
    }

    public void setNom_lecteur(String value) {
        nom_lecteur.set(value);
    }

    public StringProperty nom_lecteurProperty() {
        return nom_lecteur;
    }

    public int getId_lecteur() {
        return id_lecteur.get();
    }

    public void setId_lecteur(int value) {
        id_lecteur.set(value);
    }

    public IntegerProperty id_lecteurProperty() {
        return id_lecteur;
    }
public void getlecteur(){
System.out.println(id_lecteur+" "+nom_lecteur);
}
    public void ajouterLecteur(Lecteur model){
        try {
            String query = "INSERT INTO lecteur (ID,nom, Prenom_lecteur, Adresse, Email, Num_tel, Date_naiss, type, paiement) " +
               " VALUES('"+model.getId_lecteur()+
                "','"+model.getNom_lecteur()+
                "','"+model.getPrenom_lecteur()+
                "','"+model.getAdresse_lecteur()+
                "','"+model.getEmail_lecteur()+
                "','"+model.getNumTel_lecteur()+
                "','"+model.getDatenaiss_lecteur()+
                    "','"+model.getType_lecteur()+
                "','"+model.getPaiment_lecteur()+"')";
            DBconnect db = new DBconnect();
            Connection connection = (Connection) db.ConnectBd();
            Statement state = connection.createStatement();
            state.executeUpdate(query);
            System.out.println("added Lecteur");
            state.close();
            connection.close();
	} catch (Exception e) {
            System.out.println("Failed to add Lecteur");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
    
    public void supprimerLecteur(Lecteur model){
         
        try {
            String query = "DELETE FROM lecteur WHERE id ="+model.getId_lecteur();      
            DBconnect db = new DBconnect();
            Connection connection = (Connection) db.ConnectBd();
            Statement state = connection.createStatement();
            state.executeUpdate(query);
            System.out.println("Succed to delete the Lecteur");
            state.close();
            connection.close();
            
	} catch (Exception e) {
            System.out.println("Failed to delete the Lecteur");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            
	
    }
    }
    
    
}
