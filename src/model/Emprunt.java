/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.DBconnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Emprunt {
    private final IntegerProperty id_emprunt ;
    private final StringProperty date_emprunt ;
    private final StringProperty prolongation ; 
    private final StringProperty date_restitution; 
    private final StringProperty code_ouvrage; 
    
    public Emprunt(int id,String date_emprunt,String prolongation,String date_restitution,String code_ouvrage) {
        this.id_emprunt=new SimpleIntegerProperty(id);
        this.date_emprunt=new SimpleStringProperty(date_emprunt);
        this.prolongation=new SimpleStringProperty(prolongation);
        this.date_restitution= new SimpleStringProperty(date_restitution);
        this.code_ouvrage= new SimpleStringProperty(code_ouvrage);

    }
     public int getId_emprunt() {
        return id_emprunt.get();
    }

    public void setId_emprunt(int value) {
        id_emprunt.set(value);
    }

    public IntegerProperty id_empruntProperty() {
        return id_emprunt;
    }
    

    public String getDate_emprunt() {
        return date_emprunt.get();
    }

    public void setDate_emprunt(String value) {
        date_emprunt.set(value);
    }

    public StringProperty date_empruntProperty() {
        return date_emprunt;
    }
   
        public String getCode_ouvrage() {
        return code_ouvrage.get();
    }

    public void setCode_ouvrage(String value) {
        code_ouvrage.set(value);
    }

    public StringProperty code_ouvrageProperty() {
        return code_ouvrage;
    }

    public String isProlongation() {
        return prolongation.get();
    }

    public void setProlongation(String value) {
        prolongation.set(value);
    }

    public StringProperty prolongationProperty() {
        return prolongation;
    }
    

    public String getDate_restitution() {
        return date_restitution.get();
    }

    public void setDate_restitution(String value) {
        date_restitution.set(value);
    }

    public StringProperty date_restitutionProperty() {
        return date_restitution;
    }
    
   public void ajouterEmprunt(Emprunt model) {
    try {
        String query = "INSERT INTO Emprunt (Date_emprunt,Prolongation,Date_ristitution,LecteurID,OuvrageID) " +
                "VALUES ('" +/* Date.valueOf(model.getDate_emprunt())*/"" + "', " +
                "'" + "f" + "', " +
                "'" + /*Date.valueOf(model.getDate_restitution())*/ ""+ "', " +
                "'" + Integer.valueOf(model.getId_emprunt()) + "', " +
                "'" + Integer.valueOf(model.getCode_ouvrage())+"' )";
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
