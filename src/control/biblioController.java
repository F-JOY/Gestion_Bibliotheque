/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import control.DBconnect;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import model.Lecteur;
import model.Ouvrage;
import model.Emprunt;

/**
 *
 * @author Mes documants
 */
public class biblioController implements Initializable{
   //left side pane gestion d'affichage des panneaux
    @FXML
    private Label user_name_label;
    @FXML
    private Button acc_btn;
    @FXML
    private Button book_btn;
    @FXML
    private Button emprunt_btn;
    @FXML
    private Button penalité_btn;
    @FXML
    private Label log_out_btn;
    @FXML
    private AnchorPane Acc_pan;
    @FXML
    private AnchorPane book_pan;
    @FXML
    private AnchorPane emprunt_pan;
    @FXML
    private AnchorPane rest_pan;
    
    //top border buttons gestion des fenetre reduire fermer ...
    @FXML
    private FontAwesomeIconView minus_icon;
    @FXML
    private Button close_btn;
    @FXML
    private FontAwesomeIconView x_icon;
    @FXML
    private ImageView max_min_btn;
    @FXML
    private Button reduire_btn;
    
   //////////////////recherche emprunt//////////////////////
    @FXML
    private TextField rechercheEmprunt_txt;
    @FXML
    private FontAwesomeIconView rechercheEmprunt_btn;
    
    /////////////////// text de l'acceuil///////////////
    @FXML
    private Label totalOuvrage_label;
    @FXML
    private Label totalEmprunt_label;
    @FXML
    private Label totalRest_lable;
    @FXML
    private Label totalRetard_lable;
    @FXML
    private Label totalPenalité_label;
    //////////////////////////////recherche ouvrage/////////////
    @FXML
    private TextField rechercheOuvrage_txt;
    @FXML
    private FontAwesomeIconView rechercheOuvrage_btn;
    
    @FXML
    private TextField titreOuvrage_txt;
    @FXML
    private TextField annéeOuvrage_txt;
    @FXML
    private TextField maisonEdit_txt;
    @FXML
    private TextField auteurOuvrage_txt;
    @FXML
    private TextField prixOuvrage_txt;
    @FXML
    private TextField nbExemplaire_txt;
    @FXML
    private TextArea discOuvrage_txt;
    @FXML
    private TextField isbnOuvrage_txt;
    @FXML
    private Button ajouterOuvrage_btn;//bouton ajouter ouvrage
    ObservableList<Ouvrage> ouvrageListTableView;
    
    @FXML
    private Button imprimerTotal_btn;// bouton imprission de rapport quotidien
    
    //les variable fonction ajouter emprunt
    @FXML
    private TextField emprunt_idLecteur_txt;
    @FXML
    private TextField emprun_ouvrage1;
    @FXML
    private TextField emprun_ouvrage2;
    @FXML
    private TextField emprun_ouvrage3;
    @FXML
    private DatePicker emprunt_date;
    @FXML
    private TextField rest_date;
    @FXML
    private Button ajouterEmprunt_btn;
    @FXML
    private Button imprimerEmprunt_btn;//rapport d'un emprunt a imprimer pour donnée au lecteur
    @FXML
    private ComboBox<?> combobox_filiere;
    @FXML
    private ComboBox<?> combobox_specialite;
    ObservableList listfiliere;
    
    
    @FXML
    private TableView<Ouvrage> ouvrage_tab;
    @FXML
    private TableView<?> emprunt_tab;
    @FXML
    private TableView<?> penalite_tab;
    
    
    
    /*les column dela table des ouvrages*/
    @FXML
    private TableColumn<?, ?> isbn_col;
    @FXML
    private TableColumn<?, ?> titre_col;
    @FXML
    private TableColumn<?, ?> nbExemplaire_col;
    @FXML
    private TableColumn<?, ?> prix_col;
    @FXML
    private TableColumn<?, ?> filiere_col;
    @FXML
    private TableColumn<?, ?> specialité_col;
    /****************************************************/
    /*les column de la tables des emprunt*/
    @FXML
    private TableColumn<?, ?> idEmprunt_col;
    @FXML
    private TableColumn<?, ?> dateEmprunt_col;
    @FXML
    private TableColumn<?, ?> idLecteurEmprunt_col;
    @FXML
    private TableColumn<?, ?> codeOuvrage_col;
    @FXML
    private TableColumn<?, ?> dateRestEmprunt_col;
    @FXML
    private TableColumn<?, ?> prolongationEmprunt_col;
    @FXML
    private TableColumn<?, ?> restEmprunt_col;
    /******************************************************/
    /*les columns de la table des pénalités */
    @FXML
    private TableColumn<?, ?> idLecteurPenalité_col;
    @FXML
    private TableColumn<?, ?> nomLecteurPenalité_col;
    @FXML
    private TableColumn<?, ?> prenomLecteurPenalité_col;
    @FXML
    private TableColumn<?, ?> debutPenalité_col;
    @FXML
    private TableColumn<?, ?> finPenalité_col;
    /****************************************************/
    
    DBconnect db= new DBconnect();
    Connection connection = (Connection) db.ConnectBd();
    
    
     public void FiliereData(){
        try{
            String query="SELECT * FROM filiere";
           
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
             listfiliere= FXCollections.observableArrayList();
            while (result.next()) {                
                String item= result.getString("Nom_filiere");
                listfiliere.add(item);
                
            }
            combobox_filiere.setItems(listfiliere);
            
            
        }catch(Exception e){
             System.out.println("Failed...");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            
        }
        
         
    }
     public int getID_filiere(){
         try {
             String query="SELECT * FROM filiere WHERE Nom_filiere='"+combobox_filiere.getValue()+"'";
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
             while (result.next()) {                 
                 int id_fil=result.getInt("ID");
                 return id_fil;
             }
             
         } catch (Exception e) {
             System.out.println("Failed...");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
         }
         return 0;
     }
     
          public String getNom_filiere(int Idfiliere){
         try {
             String query="SELECT * FROM filiere WHERE ID=idfiliere";
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
             while (result.next()) {                 
                 String nom_fil=result.getString("Nom_filiere");
                 return nom_fil;
             }
             
         } catch (Exception e) {
             System.out.println("Failed...");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
         }
         return "";
     }
     
     
     
         public int SprcialitéId(){
        try{
            String query="SELECT ID FROM specialite WHERE Nom_specialite='"+combobox_specialite.getValue()+"'";
            
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
              while (result.next()) {                 
                 int id_fil=result.getInt("ID");
                 return id_fil;
             }
            
            
        }catch(Exception e){
             System.out.println("Failed...");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            
        }return 0; 
         };
     
    public void SprcialitéData(){
        try{
            String query="SELECT * FROM specialite WHERE FiliereID='"+getID_filiere()+"'";
            
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            listfiliere= FXCollections.observableArrayList();
            while (result.next()) {                
                String item= result.getString("Nom_specialite");
                listfiliere.add(item);
                
            }
            combobox_specialite.setItems(listfiliere);
            
        }catch(Exception e){
             System.out.println("Failed...");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            
        }
        
         
    }
    
    public void initialize(URL url, ResourceBundle rb) {
         Acc_pan.setVisible(true);
        book_pan.setVisible(false);
        emprunt_pan.setVisible(false);
        rest_pan.setVisible(false);
         FiliereData();
        listOuvrageTableView();
    }
    @FXML
    private void getSpecialité(ActionEvent event) {
      SprcialitéData();  
    }
    

    @FXML
    private void show_acc(MouseEvent event) {
        Acc_pan.setVisible(true);
        book_pan.setVisible(false);
        emprunt_pan.setVisible(false);
        rest_pan.setVisible(false);
        acc_btn.setStyle("-fx-background-color:white;-fx-border-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-width:3px");
         book_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
         emprunt_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
         penalité_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
    }

    @FXML
    private void show_book(MouseEvent event) {
         Acc_pan.setVisible(false);
        book_pan.setVisible(true);
        emprunt_pan.setVisible(false);
        rest_pan.setVisible(false);
        book_btn.setStyle("-fx-background-color:white;-fx-border-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-width:3px");
         acc_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
         emprunt_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
         penalité_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
   
    }

    @FXML
    private void show_emprunt(MouseEvent event) {
         Acc_pan.setVisible(false);
        book_pan.setVisible(false);
        emprunt_pan.setVisible(true);
        rest_pan.setVisible(false);
        emprunt_btn.setStyle("-fx-background-color:white;-fx-border-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-width:3px");
         book_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
         acc_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
         penalité_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
   
    }

    @FXML
    private void log_out(MouseEvent event) throws IOException {
         Stage stage= new Stage();
            Parent root=FXMLLoader.load(getClass().getResource("/view/connexion.fxml"));
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void show_sanc(MouseEvent event) {
    }

    @FXML
    private void initial_color(MouseEvent event) {
         reduire_btn.setStyle("-fx-background-color:transparent");
        minus_icon.setStyle("-fx-fill:black");
    }

    @FXML
    private void blue_color(MouseEvent event) {
        reduire_btn.setStyle("-fx-background-color:#13d4ee");
        minus_icon.setStyle("-fx-fill:white");
    }

    @FXML
    private void reduire(MouseEvent event) {
        Stage stage=(Stage) reduire_btn.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void initialclose_color(MouseEvent event) {
        close_btn.setStyle("-fx-background-color:transparent");
        x_icon.setStyle("-fx-fill:black");
    }

    @FXML
    private void red_color(MouseEvent event) {
        close_btn.setStyle("-fx-background-color:red");
        x_icon.setStyle("-fx-fill:white");
    }

    @FXML
    private void close(MouseEvent event) {
         javafx.application.Platform.exit();
         
    }

    @FXML
    private void max_min_screen(MouseEvent event) {
        Stage stage=(Stage) max_min_btn.getScene().getWindow();
    Image imgmin= new Image("/images/minimize.png");
    Image imgmax= new Image("/images/maximize_icon.png");
    if(stage.isMaximized()==false){
        stage.setMaximized(true);
        max_min_btn.setImage(imgmin);
    }else{
        stage.setMaximized(false);
        max_min_btn.setImage(imgmax);
    }    
    }

    @FXML
    private void show_penalité(MouseEvent event) {
        rest_pan.setVisible(true);
        book_pan.setVisible(false);
        emprunt_pan.setVisible(false);
        Acc_pan.setVisible(false);
        penalité_btn.setStyle("-fx-background-color:white;-fx-border-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-width:3px");
         book_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
         emprunt_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
         acc_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
   
    }
    
    
    
    private void ajouterOuv(MouseEvent event) {
       // if(checkFieldsAbonne()){
        //DialogErreurChampsVide(event,"Veuillez Saisir Tout Les Champs");
      // }else{
           
                System.out.println("tout les champs sont complet");
                int id_filiere =getID_filiere();
                int id_specialité=SprcialitéId();
                Ouvrage model = new Ouvrage(0,"","","","",0,0.0f,0,"",0,0);
                model.setIsbn(isbnOuvrage_txt.getText());
                model.setTitre(titreOuvrage_txt.getText());
                model.setAuteur(auteurOuvrage_txt.getText());
                model.setMaisonEdition(maisonEdit_txt.getText());
                model.setAnnéeEdition(Integer.valueOf(annéeOuvrage_txt.getText()));
                model.setDiscription(discOuvrage_txt.getText());
                model.setNbExemplaires(Integer.valueOf(nbExemplaire_txt.getText()));
                model.setPrix(Float.valueOf(prixOuvrage_txt.getText()));
                model.setFiliere(id_filiere);
                model.setSpecialite(id_specialité);
                model.ajouterOuvrage(model,id_filiere,id_specialité);
                     
                     
                };
                
             //   clearchampsabbonne();
                
              //  clearchampsabbonne();
          //  }
    
    
    
    private int nombreOuvrages(TextField emprun_ouvrage1 ,TextField emprun_ouvrage2 ,TextField emprun_ouvrage3){
        int totalOuvrages=0;
    if (!emprun_ouvrage1.getText().isEmpty()) {
        totalOuvrages++;
    }
    
    if (!emprun_ouvrage2.getText().isEmpty()) {
        totalOuvrages++;
    }
    
    if (!emprun_ouvrage3.getText().isEmpty()) {
        totalOuvrages++;
    }
        return totalOuvrages;
    }
    
    
    
    private void ajouterEmpr(MouseEvent event) {
       // if(checkFieldsAbonne()){
        //DialogErreurChampsVide(event,"Veuillez Saisir Tout Les Champs");
      // }else{
           
                System.out.println("tout les champs sont complet");
                  //  if (!emprun_ouvrage1.getText().isEmpty()) {
                 Emprunt model1 = new Emprunt(0,"","f","","");
                model1.setId_emprunt(Integer.valueOf(emprunt_idLecteur_txt.getText()));
                model1.setCode_ouvrage(emprun_ouvrage1.getText());
              //  model1.setDate_emprunt(emprunt_date.getValue().toString());
               // model1.setDate_restitution(rest_date.getText());
                model1.ajouterEmprunt(model1);
  //  }
    
  /*  if (!emprun_ouvrage2.getText().isEmpty()) {
                                       Emprunt model = new Emprunt(0,"","f","","");
                model.setId_emprunt(Integer.valueOf(emprunt_idLecteur_txt.getText()));
                model.setCode_ouvrage(emprun_ouvrage2.getText());
                model.setDate_emprunt(emprunt_date.getValue().toString());
                model.setDate_restitution(rest_date.getText());
                model.ajouterEmprunt(model);
    }
    
    if (!emprun_ouvrage3.getText().isEmpty()) {
                        Emprunt model2 = new Emprunt(0,"","f","","");
                model2.setId_emprunt(Integer.valueOf(emprunt_idLecteur_txt.getText()));
                model2.setCode_ouvrage(emprun_ouvrage3.getText());
                model2.setDate_emprunt(emprunt_date.getValue().toString());
                model2.setDate_restitution(rest_date.getText());
                model2.ajouterEmprunt(model2);
    }*/

                     
                     
                };
                
             //   clearchampsabbonne();
                
              //  clearchampsabbonne();
          //  }
    
    
    
    
    
     public void listOuvrageTableView() {
    try{ // Exécution de la requête et récupération des résultats dans un ResultSet
        String query="SELECT * FROM ouvrage";
           
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
             ouvrageListTableView= FXCollections.observableArrayList();
         // Initialisation d'une liste observable pour stocker les résultats

        while (result.next()) { // Boucle sur les résultats du ResultSet
            Ouvrage ouv = new Ouvrage(0,"","","","",0,0.0f,0,"",0,0); // Création d'un objet Lecteur pour chaque ligne
            ouv.setIsbn(result.getString("isbn")); // Récupération des données dans le ResultSet et mise à jour de l'objet Lecteur
            ouv.setTitre(result.getString("Titre"));
            ouv.setNbExemplaires(result.getInt("Nb_exemplaire"));
            ouv.setPrix(result.getInt("Prix"));
            ouv.setFiliere(result.getInt("SpecialiteID"));
            ouv.setSpecialite(result.getInt("idSpecialite"));
            ouvrageListTableView.add(ouv); // Ajout de l'objet Lecteur à la liste observable
        }
        
        // Mise en place des colonnes dans le TableView à partir des propriétés de l'objet Lecteur
        isbn_col.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        titre_col.setCellValueFactory(new PropertyValueFactory<>("titre"));
        nbExemplaire_col.setCellValueFactory(new PropertyValueFactory<>("nbExemplaires"));
        prix_col.setCellValueFactory(new PropertyValueFactory<>("prix"));
        filiere_col.setCellValueFactory(new PropertyValueFactory<>("filiere"));
        specialité_col.setCellValueFactory(new PropertyValueFactory<>("specialite"));
       
        
ouvrage_tab.setItems(ouvrageListTableView);
    } catch (SQLException ex) { // Gestion d'erreur en cas de problème avec la base de données
        Logger.getLogger(gerantController.class.getName()).log(Level.SEVERE, null, ex);
    }
}      
     
     
     
     
     
    
    
    @FXML
    private void rechercheEmprunt(MouseEvent event) {
    }

    @FXML
    private void imprimerTotalEmprunt(MouseEvent event) {
    }

    @FXML
    private void ajouterEmprunt(MouseEvent event) {
        ajouterEmpr(event);
    }
    
    @FXML
    private void imprimerEmprunt(MouseEvent event) {
    }
    

    @FXML
    private void rechercheOuvrage(MouseEvent event) {
    }

    @FXML
    private void ajouterOuvrage(MouseEvent event) {
        ajouterOuv(event);
        listOuvrageTableView();
    }

    

    
    
}
