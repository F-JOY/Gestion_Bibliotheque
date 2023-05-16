
package model;

import control.DBconnect;
import java.sql.Connection;
import java.sql.Statement;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ouvrage {
    private final IntegerProperty id_ouvrage ;
    private final StringProperty isbn ;
    private final StringProperty titre ;
    private final StringProperty auteur ;
    private final StringProperty maisonEdition;
    private final IntegerProperty annéeEdition ;
    private final FloatProperty prix ;
    private final IntegerProperty nbExemplaires ;
    private final StringProperty discription; 
    private final IntegerProperty filiere; 
    private final IntegerProperty specialite; 



    
    public Ouvrage(int id,String isbn,String titre,String auteur,String maisonEdition,int annéeEdition,float prix, int nbExemplaires,String disc, int filiere, int specialite) {
    this.id_ouvrage= new SimpleIntegerProperty(id);
    this.isbn= new SimpleStringProperty(isbn);
    this.titre= new SimpleStringProperty(titre);
    this.auteur=new SimpleStringProperty(auteur);
    this.maisonEdition=new SimpleStringProperty(maisonEdition);
    this.annéeEdition=new SimpleIntegerProperty(annéeEdition);
    this.prix=new SimpleFloatProperty(prix);
    this.nbExemplaires=new SimpleIntegerProperty(nbExemplaires);
    this.discription= new SimpleStringProperty(disc);
    this.filiere= new SimpleIntegerProperty(filiere);
    this.specialite= new SimpleIntegerProperty(specialite);
    }
    

    public int getId_ouvrage() {
        return id_ouvrage.get();
    }

    public void setId_ouvrage(int value) {
        id_ouvrage.set(value);
    }

    public IntegerProperty id_ouvrageProperty() {
        return id_ouvrage;
    }
    
    
        public int filiere_ouvrage() {
        return filiere.get();
    }

    public void filiere_ouvrage(int value) {
        filiere.set(value);
    }

    public IntegerProperty filiereProperty() {
        return filiere;
    }
    
        public int specialite_ouvrage() {
        return specialite.get();
    }

    public void specialite_ouvrage(int value) {
        specialite.set(value);
    }

    public IntegerProperty specialiteProperty() {
        return specialite;
    }
    

    public String getIsbn() {
        return isbn.get();
    }

    public int getfiliere() {
        return filiere.get();
    }
    
    public int getspecialite() {
        return specialite.get();
    }
    
    public void setIsbn(String value) {
        isbn.set(value);
    }
    
        public void setFiliere(int value) {
        filiere.set(value);
    }
        
    public void setSpecialite(int value) {
        specialite.set(value);
    }


    public StringProperty isbnProperty() {
        return isbn;
    }
    

    public String getTitre() {
        return titre.get();
    }

    public void setTitre(String value) {
        titre.set(value);
    }

    public StringProperty titreProperty() {
        return titre;
    }
   

    public String getAuteur() {
        return auteur.get();
    }

    public void setAuteur(String value) {
        auteur.set(value);
    }

    public StringProperty auteurProperty() {
        return auteur;
    }
   

    public String getMaisonEdition() {
        return maisonEdition.get();
    }

    public void setMaisonEdition(String value) {
        maisonEdition.set(value);
    }

    public StringProperty maisonEditionProperty() {
        return maisonEdition;
    }

    public int getAnnéeEdition() {
        return annéeEdition.get();
    }

    public void setAnnéeEdition(int value) {
        annéeEdition.set(value);
    }

    public IntegerProperty annéeEditionProperty() {
        return annéeEdition;
    }
    
    public float getPrix() {
        return prix.get();
    }

    public void setPrix(float value) {
        prix.set(value);
    }

    public FloatProperty prixProperty() {
        return prix;
    }

    public int getNbExemplaires() {
        return nbExemplaires.get();
    }

    public void setNbExemplaires(int value) {
        nbExemplaires.set(value);
    }

    public IntegerProperty nbExemplairesProperty() {
        return nbExemplaires;
    }
    

    public String getDiscription() {
        return discription.get();
    }

    public void setDiscription(String value) {
        discription.set(value);
    }

    public StringProperty discriptionProperty() {
        return discription;
    }
    
    public void ajouterOuvrage(Ouvrage model, Integer id_filiere,Integer id_specialite) {
    try {
        String query = "INSERT INTO ouvrage (isbn, specialiteID , Titre, Auteur, Maison_edition, Date_edition, Prix, Nb_exemplaire,Discription,idSpecialite) " +
                "VALUES ('" + model.getIsbn() + "', " +
                "'" + model.getfiliere()+ "', " +
                "'" + model.getTitre() + "', " +
                "'" + model.getAuteur() + "', " +
                "'" + model.getMaisonEdition() + "', " +
                "'" + model.getAnnéeEdition() + "', " +
                model.getPrix() + ", " +
                "'" + model.getNbExemplaires() + "', " +
                "'" + model.getDiscription()+"', "+
                "'" + model.getspecialite() +"')";
        DBconnect db = new DBconnect();
        try (Connection connection = db.ConnectBd()) {
            Statement state = connection.createStatement();
            state.executeUpdate(query);
            System.out.println("Added Ouvrage");
            state.close();
        }
    } catch (Exception e) {
        System.out.println("Failed to add biblio");
        System.out.println(e.getMessage());
        System.out.println(e.getCause());
    }
}
    
}
