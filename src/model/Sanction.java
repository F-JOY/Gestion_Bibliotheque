
package model;

import control.DBconnect;
import java.sql.Connection;
import java.sql.Statement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Sanction {

  //  private final IntegerProperty id_sanction ;
    private final IntegerProperty duréeRetard ;
    private final IntegerProperty duréeSanction ;

    public Sanction(int duréeRetard, int duréeSanction) {
        this.duréeRetard = new SimpleIntegerProperty(duréeRetard);
        this.duréeSanction = new SimpleIntegerProperty(duréeSanction);
    }
    
    
    
 /*   public int getId_sanction() {
        return id_sanction.get();
    }

    public void setId_sanction(int value) {
        id_sanction.set(value);
    }

    public IntegerProperty id_sanctionProperty() {
        return id_sanction;
    }
    */

    public int getDuréeRetard() {
        return duréeRetard.get();
    }

    public void setDuréeRetard(int value) {
        duréeRetard.set(value);
    }

    public IntegerProperty duréeRetardProperty() {
        return duréeRetard;
    }
    

    public int getDuréeSanction() {
        return duréeSanction.get();
    }

    public void setDuréeSanction(int value) {
        duréeSanction.set(value);
    }

    public IntegerProperty duréeSanctionProperty() {
        return duréeSanction;
    }
    
    
   public void ajouterSanctionToDb(Sanction model) {
    try {
        String query = "INSERT INTO sanction (Durée_retard, Durée_sanction) " +
                "VALUES ('" + model.getDuréeRetard() + "', '" + model.getDuréeSanction() + "')";
        DBconnect db = new DBconnect();
        try (Connection connection = db.ConnectBd()) {
            Statement state = connection.createStatement();
            state.executeUpdate(query);
            System.out.println("Added Sanction");
            state.close();
        }
    } catch (Exception e) {
        System.out.println("Failed to add sanction");
        System.out.println(e.getMessage());
        System.out.println(e.getCause());
    }
}

    
}
