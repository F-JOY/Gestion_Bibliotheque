
package model;

import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Restitution {

    private final IntegerProperty id_restitution ; 
    private final ObjectProperty<LocalDate> date_restitution ;
    private final BooleanProperty retard ;

    public Restitution(int id,LocalDate date_restitution,Boolean retard) {
        this.id_restitution=new SimpleIntegerProperty(id);
        this.date_restitution= new SimpleObjectProperty<>(date_restitution);
        this.retard= new SimpleBooleanProperty(retard);
    }
    
    public int getId_restitution() {
        return id_restitution.get();
    }

    public void setId_restitution(int value) {
        id_restitution.set(value);
    }

    public IntegerProperty id_restitutionProperty() {
        return id_restitution;
    }
    

    public LocalDate getDate_restitution() {
        return date_restitution.get();
    }

    public void setDate_restitution(LocalDate value) {
        date_restitution.set(value);
    }

    public ObjectProperty date_restitutionProperty() {
        return date_restitution;
    }
    

    public boolean isRetard() {
        return retard.get();
    }

    public void setRetard(boolean value) {
        retard.set(value);
    }

    public BooleanProperty retardProperty() {
        return retard;
    }
    
    
}
