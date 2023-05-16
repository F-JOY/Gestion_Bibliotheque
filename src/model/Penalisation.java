
package model;

import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;


public class Penalisation {

    

   
    private final IntegerProperty id_penalité ; 
    private final ObjectProperty<LocalDate> date_debut ;
    private final ObjectProperty<LocalDate> date_fin ; 
    public Penalisation(int id,LocalDate date_debut,LocalDate date_fin) {
    this.id_penalité=new SimpleIntegerProperty(id);
    this.date_debut= new SimpleObjectProperty<>(date_debut);
    this.date_fin=new SimpleObjectProperty<>(date_fin);
    
    }

    public int getId_penalité() {
        return id_penalité.get();
    }

    public void setId_penalité(int value) {
        id_penalité.set(value);
    }

    public IntegerProperty id_penalitéProperty() {
        return id_penalité;
    }
    

    public LocalDate getDate_debut() {
        return date_debut.get();
    }

    public void setDate_debut(LocalDate value) {
        date_debut.set(value);
    }

    public ObjectProperty date_debutProperty() {
        return date_debut;
    }
   
    public LocalDate getDate_fin() {
        return date_fin.get();
    }

    public void setDate_fin(LocalDate value) {
        date_fin.set(value);
    }

    public ObjectProperty date_finProperty() {
        return date_fin;
    }
    
   
    
}
