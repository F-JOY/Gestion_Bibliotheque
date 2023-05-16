/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import io.github.palexdev.materialfx.dialogs.MFXGenericDialogBuilder;
import io.github.palexdev.materialfx.dialogs.MFXStageDialog;
import io.github.palexdev.materialfx.enums.ScrimPriority;
import io.github.palexdev.materialfx.filter.StringFilter;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.Duration;
import com.jfoenix.controls.JFXRadioButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Lecteur;
import model.Bibliothecaire;
import model.Sanction;

/**
 * FXML Controller class
 *
 * @author Mes documants
 */
public class gerantController implements Initializable {
//les variable des btn d'affichage
    @FXML
    private Button acc_btn;
    @FXML
    private Button biblio_btn;
    @FXML
    private Button abn_btn;
    
    @FXML
    private Button sanc_btn;
    @FXML
    private AnchorPane biblio_pan;
    @FXML
    private AnchorPane Acc_pan;
    @FXML
    private AnchorPane abn_pan;
    @FXML
    private AnchorPane sanc_pan;
   
    @FXML
    private Label log_out_btn;//btn deconnexion
    @FXML
    private FontAwesomeIconView btn_editprofil;//bouton visualiser le pan d'update profile de gerant
    @FXML
    private Label userName_label;//le nom d'utilisateur qui figure dans left side
    //les champs a changer dans les carde de l'acceuil
    @FXML
    private Label totalBiblio_label;
    @FXML
    private Label totalSanction_label;
    @FXML
    private Label totalBokk_label;
    @FXML
    private Label totalAbonné_label;
    //le deuxieme pan des bibliothecaires 

    @FXML
    private TextField rechercheBiblio_txt;
    @FXML
    private FontAwesomeIconView rechercheBiblio_btn;
    @FXML
    private TextField nomBiblio_txt;
    @FXML
    private TextField prenomBiblio_txt;
    @FXML
    private TextField adresseBiblio_txt;
    @FXML
    private TextField numeroTelBiblio_txt;
    @FXML
    private TextField emailBiblio_txt;
    @FXML
    private Button ajouterBiblio_btn;
    @FXML
    private TextField userNameBiblio_txt;
    @FXML
    private PasswordField passwordBiblio_txt;
    @FXML
    private PasswordField confirmePasswordBiblio_txt;
    
    
    
    //le troisieme pan des Abonnés
    @FXML
    private TextField recherchAbonnée_txt;
    @FXML
    private FontAwesomeIconView rechercheAbonnée_btn;
    @FXML
    private TextField nomAbonné_txt;
    @FXML
    private TextField prénomAbonné_txt;
    @FXML
    private TextField numeroTelAbonné_txt;
    @FXML
    private TextField adresseAbonné_txt;
    @FXML
    private TextField emailAbonné_txt;
    @FXML
    private DatePicker dateNaissAbonné_txt;
    @FXML
    private Button ajouterAbonné_btn;
    @FXML
    private RadioButton etudInterne_rdBtn;
    @FXML
    private RadioButton etudExterne_rdBtn;
    @FXML
    private RadioButton enseignant_rdBtn;
    //le pan des sactions
    @FXML
    private TextField retard_txt;
    @FXML
    private Button ajouterSanction_btn;
    @FXML
    private TextField sanction_txt;
    //les champs de update compte gestionnaire
    @FXML
    private AnchorPane edit_pan;
    @FXML
    private TextField userName_txt;
    @FXML
    private PasswordField prePassword_txt;
    @FXML
    private PasswordField newPassword_txt;
    @FXML
    private Button updateAccount_btn;//bouton enregistrer les modification
    //les icones et les bouttons gestion de la fenetre reduire close ...
    @FXML
    private Button reduire_btn;
    @FXML
    private Button close_btn;
    @FXML
    private ImageView max_min_btn;
    @FXML
    private FontAwesomeIconView minus_icon;
    @FXML
    private FontAwesomeIconView x_icon;
    @FXML
    private ToggleGroup typeAbn;
    @FXML
    private ToggleGroup calender;
    @FXML
    private ToggleGroup calender2;
    @FXML
    private LineChart<?, ?> statistique_cart;
    @FXML
    private TableView<Bibliothecaire> biblio_tab;//tableau view des bibliotecaires
    @FXML
    private TableView<Lecteur> abonné_tab;// table view des abonné(lecteurs)
    @FXML
    private AnchorPane paiment_interne_pan;
    @FXML
    private CheckBox paiement_interne_checkBox;//verification de paiement de la somme forfataire(etu_interne)
    @FXML
    private AnchorPane paiement_externe_pan;
    @FXML
    private CheckBox paiement_externe_checkBox;//verification de paiement des frais d'inscription(etu_externe)
    @FXML
    private TableView<Sanction> sanction_tab;
    @FXML
    private JFXRadioButton retard_jour_RDbtn;
    @FXML
    private JFXRadioButton retard_semaine_RDbtn;
    @FXML
    private JFXRadioButton retard_mois_RDbtn;
    @FXML
    private JFXRadioButton sanction_jour_RDbtn;
    @FXML
    private JFXRadioButton sanction_semain_RDbtn;
    @FXML
    private JFXRadioButton sanction_mois_RDbtn;
    @FXML
    private TableView<?> penalite_tab;
    

    
    /*LES colums de la tables bibliotecaires*/
    @FXML
    private TableColumn<Bibliothecaire, Integer> id_biblio_col;
    @FXML
    private TableColumn<Bibliothecaire, String> nom_biblio_col;
    @FXML
    private TableColumn<Bibliothecaire, String> prenom_biblio_col;
    @FXML
    private TableColumn<Bibliothecaire, String> adresse_biblio_col;
    @FXML
    private TableColumn<Bibliothecaire, String> numTel_biblio_col;
    @FXML
    private TableColumn<Bibliothecaire, String> email_biblio_col;
    
   @FXML
   private TableColumn<Bibliothecaire, String> nomUtilisateur_biblio_col;
   @FXML
   private TableColumn<Bibliothecaire, String> passWord_biblio_col;
   @FXML
   private TableColumn modifier_biblio_col;
   
   ObservableList<Bibliothecaire> bibliothecaireListTableView;
    /********************************************************/
    /*les colums de la table abonnés */
   @FXML
    private TableColumn<Lecteur, Integer> id_abonné_col;
    @FXML
    private TableColumn<Lecteur, String> nom_abonné_col;
    @FXML
    private TableColumn<Lecteur, String> prenom_abonné_col;
    @FXML
    private TableColumn<Lecteur, String> adresse_abonné_col;
    @FXML
    private TableColumn<Lecteur, String> dateNaiss_abonné_col;
    @FXML
    private TableColumn<Lecteur, String> numTel_abonné_col;
    @FXML
    private TableColumn<Lecteur, String> email_abonné_col;
    @FXML
    private TableColumn<Lecteur, String> type_abonné_col;
    @FXML
    private TableColumn<Lecteur, String> paiement_col;
    @FXML
    private TableColumn modifsupp_col;
   ObservableList<Lecteur> lecteurListTableView;
    /******************************************************/
    /* les column de la table des sanctions*/
    
    @FXML
    private TableColumn<Sanction, Integer> duréeRetard_col;
    @FXML
    private TableColumn<Sanction, Integer> duréeSanction_col;
    @FXML
    private TableColumn modifierSanction_col;
    @FXML
    private TableColumn supprimerSanction_col;
    
    ObservableList<Sanction> sanctionListTableView;
    /**************************************************/
    /*les colums de la table de penamités*/
    @FXML
    private TableColumn<?, ?> pénalité_ID_emprunt_col;
    @FXML
    private TableColumn<?, ?> penalité_Date_emprunt_col;
    @FXML
    private TableColumn<?, ?> penalité_ID_Lecteur_col;
    @FXML
    private TableColumn<?, ?> penalité_nomLecteur_col;
    @FXML
    private TableColumn<?, ?> penalité_prenomLecteur_col;
    @FXML
    private TableColumn<?, ?> debuPenalité_col;
    @FXML
    private TableColumn<?, ?> finPenalité_col;
    @FXML
    private TableColumn<?, ?> supprimerPenalité_col;
   
   
   DBconnect db= new DBconnect();
    Connection connection = (Connection) db.ConnectBd();
    /**
      Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Acc_pan.setVisible(true);
        abn_pan.setVisible(false);
        sanc_pan.setVisible(false);
        biblio_pan.setVisible(false);
        edit_pan.setVisible(false);
        paiement_externe_pan.setVisible(false);
        paiment_interne_pan.setVisible(false);
        getTotalOUvrage();
        getTotalAbonnee();
        getTotalBiblio();
        getTotalSanction();
        listLecteurTableView();
        listBibliothecairesTableView();
        listSanctionsTableView();
        
    }   
    @FXML
    public void panneauType(){
         if (etudInterne_rdBtn.isSelected()){
             paiment_interne_pan.setVisible(true);
             paiement_externe_pan.setVisible(false);
         }else{
             if(etudExterne_rdBtn.isSelected()){
                 paiment_interne_pan.setVisible(false);
             paiement_externe_pan.setVisible(true);
             }else{
                 paiment_interne_pan.setVisible(false);
             paiement_externe_pan.setVisible(false);
             }
         }
    }
   public void getTotalOUvrage(){
       try{
       String query="SELECT COUNT(*) AS total FROM ouvrage";
           
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
             if (result.next()) {
            int total = result.getInt("total");
            totalBokk_label.setText("");
            totalBokk_label.setText(total+"");
        }
       }catch (SQLException ex) { // Gestion d'erreur en cas de problème avec la base de données
        Logger.getLogger(gerantController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
   }
    public void getTotalAbonnee(){
       try{
       String query="SELECT COUNT(*) AS total FROM lecteur";
           
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
             if (result.next()) {
            int total = result.getInt("total");
            totalAbonné_label.setText("");
            totalAbonné_label.setText(total+"");
        }
       }catch (SQLException ex) { // Gestion d'erreur en cas de problème avec la base de données
        Logger.getLogger(gerantController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
   }
    public void getTotalSanction(){
       try{
       String query="SELECT COUNT(*) AS total FROM sanction";
           
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
             if (result.next()) {
            int total = result.getInt("total");
            totalSanction_label.setText("");
            totalSanction_label.setText(total+"");
        }
       }catch (SQLException ex) { // Gestion d'erreur en cas de problème avec la base de données
        Logger.getLogger(gerantController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
   }
     public void getTotalBiblio(){
       try{
       String query="SELECT COUNT(*) AS total FROM utilisateur WHERE Discriminator = 'biblio'";
           
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
             if (result.next()) {
            int total = result.getInt("total");
            totalBiblio_label.setText("");
            totalBiblio_label.setText(total+"");
        }
       }catch (SQLException ex) { // Gestion d'erreur en cas de problème avec la base de données
        Logger.getLogger(gerantController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
   }
   public void listLecteurTableView() {
    try{ // Exécution de la requête et récupération des résultats dans un ResultSet
        String query="SELECT * FROM lecteur";
           
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
             lecteurListTableView= FXCollections.observableArrayList();
         // Initialisation d'une liste observable pour stocker les résultats

        while (result.next()) { // Boucle sur les résultats du ResultSet
            Lecteur lecteur = new Lecteur(); // Création d'un objet Lecteur pour chaque ligne
            lecteur.setId_lecteur(result.getInt("ID")); // Récupération des données dans le ResultSet et mise à jour de l'objet Lecteur
            lecteur.setNom_lecteur(result.getString("nom"));
            lecteur.setPrenom_lecteur(result.getString("Prenom_lecteur"));
            lecteur.setAdresse_lecteur(result.getString("Adresse"));
            lecteur.setNumTel_lecteur(result.getString("Num_tel"));
            lecteur.setType_lecteur(result.getString("type"));
            lecteur.setEmail_lecteur(result.getString("Email"));
            lecteur.setPaiment_lecteur(result.getString("paiement"));
            lecteur.setDatenaiss_lecteur(result.getString("Date_naiss"));
            lecteur.setDateA_lecteur(result.getString("dateA"));
            lecteur.getlecteur();
            lecteurListTableView.add(lecteur); // Ajout de l'objet Lecteur à la liste observable
        }
        
        // Mise en place des colonnes dans le TableView à partir des propriétés de l'objet Lecteur
        id_abonné_col.setCellValueFactory(new PropertyValueFactory<>("id_lecteur"));
        nom_abonné_col.setCellValueFactory(new PropertyValueFactory<>("nom_lecteur"));
        prenom_abonné_col.setCellValueFactory(new PropertyValueFactory<>("prenom_lecteur"));
        adresse_abonné_col.setCellValueFactory(new PropertyValueFactory<>("adresse_lecteur"));
        email_abonné_col.setCellValueFactory(new PropertyValueFactory<>("email_lecteur"));
        numTel_abonné_col.setCellValueFactory(new PropertyValueFactory<>("numTel_lecteur"));
        dateNaiss_abonné_col.setCellValueFactory(new PropertyValueFactory<>("datenaiss_lecteur"));
        type_abonné_col.setCellValueFactory(new PropertyValueFactory<>("type_lecteur"));
        paiement_col.setCellValueFactory(new PropertyValueFactory<>("paiment_lecteur"));
                    //CREATE CELL FACTORY TO INSERT BUTTONS IN EVERY ROWS:
            Callback<TableColumn<Lecteur, String>, TableCell<Lecteur, String>> cellFactory = (param) -> {
                //make the tableCell containing button
                final TableCell<Lecteur, String> cell = new TableCell<Lecteur, String>() {

                    //override update method
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        //Esure the cell is created only non-empty rows
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            final MFXButton modifierButton = new MFXButton("Modifier");
                            final MFXButton supprimerButton = new MFXButton("Supprimer");
                            modifierButton.setStyle(
                                    "-fx-background-color:   #02e477; "
                                    + "-fx-text-fill: white;"
                                    + " -fx-background-radius: 5;"
                                    + " -fx-font-family: 'Comfortaa';"
                                    + " -fx-font-weight: bold;"
                            );
                            supprimerButton.setStyle(
                                    "-fx-background-color:  #ff1241;"
                                    + " -fx-text-fill: white;"
                                    + " -fx-background-radius: 5;"
                                    + " -fx-font-family: 'Comfortaa';"
                                    + "-fx-font-weight: bold;"
                            );
                            //Attach listenner to the button to do the action
                          
                           
                            //remberer to set the created button to the cell
                            final HBox hbox = new HBox(modifierButton, supprimerButton);
                            HBox.setMargin(modifierButton, new Insets(0,2, 0, 0));
                            HBox.setMargin(supprimerButton, new Insets(0, 0, 0, 2));
                            setGraphic(hbox);
                            setText(null);
                            supprimerButton.setOnAction((ActionEvent event) -> {
                                Lecteur up = getTableView().getItems().get(getIndex());
                                DialogSupprimerLecteur(event, up);
                            });
                        }
                    }
                };
                
                return cell;
            };
modifsupp_col.setCellFactory(cellFactory);
abonné_tab.setItems(lecteurListTableView);
    } catch (SQLException ex) { // Gestion d'erreur en cas de problème avec la base de données
        Logger.getLogger(gerantController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
   
   
 public void listBibliothecairesTableView() {
    try{ // Exécution de  la requête et récupération des résultats dans un ResultSet
        String query="SELECT * FROM utilisateur WHERE Discriminator='biblio'";
           
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            bibliothecaireListTableView= FXCollections.observableArrayList();
         // Initialisation d'une liste observable pour stocker les résultats

        while (result.next()) { // Boucle sur les résultats du ResultSet
            Bibliothecaire Biblio = new Bibliothecaire(0,"","","","","","",0);
                Biblio.setId_utilisateur(result.getInt("id"));
                Biblio.setNom_biblio(result.getString("Nom_biblio"));
                Biblio.setPrenom_biblio(result.getString("Prénom_biblio"));
                Biblio.setAdresse_biblio(result.getString("Adresse_biblio"));
                Biblio.setNumTel_biblio(result.getInt("num_tel_biblio"));
                Biblio.setEmail_biblio(result.getString("Email_biblio"));
                Biblio.setNom_utilisateur(result.getString("Nom_utilisateur"));
                Biblio.setPassword("rien");
                Biblio.getbibliothecaire();
            bibliothecaireListTableView.add(Biblio); // Ajout de l'objet Lecteur à la liste observable
        }
        
        // Mise en place des colonnes dans le TableView à partir des propriétés de l'objet Bibliothecaire
        id_biblio_col.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
        nom_biblio_col.setCellValueFactory(new PropertyValueFactory<>("nom_biblio"));
        prenom_biblio_col.setCellValueFactory(new PropertyValueFactory<>("prenom_biblio"));
        adresse_biblio_col.setCellValueFactory(new PropertyValueFactory<>("adresse_biblio"));
        email_biblio_col.setCellValueFactory(new PropertyValueFactory<>("email_biblio"));
        numTel_biblio_col.setCellValueFactory(new PropertyValueFactory<>("numTel_biblio"));
        nomUtilisateur_biblio_col.setCellValueFactory(new PropertyValueFactory<>("Nom_utilisateur"));
       // passWord_biblio_col.setCellValueFactory(new PropertyValueFactory<>(""));


                    //CREATE CELL FACTORY TO INSERT BUTTONS IN EVERY ROWS:
            Callback<TableColumn<Bibliothecaire, String>, TableCell<Bibliothecaire, String>> cellFactory = (param) -> {
                //make the tableCell containing button
                
                final TableCell<Bibliothecaire, String> cell = new TableCell<Bibliothecaire, String>() {

                    //override update method
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        //Esure the cell is created only non-empty rows
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            final MFXButton modifierButton = new MFXButton("Modifier");
                            final MFXButton supprimerButton = new MFXButton("Supprimer");
                            modifierButton.setStyle(
                                    "-fx-background-color:   #02e477; "
                                    + "-fx-text-fill: white;"
                                    + " -fx-background-radius: 5;"
                                    + " -fx-font-family: 'Comfortaa';"
                                    + " -fx-font-weight: bold;"
                            );
                            supprimerButton.setStyle(
                                    "-fx-background-color:  #ff1241;"
                                    + " -fx-text-fill: white;"
                                    + " -fx-background-radius: 5;"
                                    + " -fx-font-family: 'Comfortaa';"
                                    + "-fx-font-weight: bold;"
                            );
                            //Attach listenner to the button to do the action
                          
                           
                            //remberer to set the created button to the cell
                            final HBox hbox = new HBox(modifierButton, supprimerButton);
                            HBox.setMargin(modifierButton, new Insets(0,2, 0, 0));
                            HBox.setMargin(supprimerButton, new Insets(0, 0, 0, 2));
                            setGraphic(hbox);
                            setText(null);
                            supprimerButton.setOnAction((ActionEvent event) -> {
                               // Bibliothecaire up = getTableView().getItems().get(getIndex());
                                //DialogSupprimerLecteur(event, up);
                            });
                        }
                    }
                };
                
                return cell;
            };
modifier_biblio_col.setCellFactory(cellFactory);
biblio_tab.setItems(bibliothecaireListTableView);

    } catch (SQLException ex) { // Gestion d'erreur en cas de problème avec la base de données
        Logger.getLogger(gerantController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

  public void listSanctionsTableView() {
    try{ // Exécution de  la requête et récupération des résultats dans un ResultSet
        String query="SELECT * FROM sanction ";
           
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
            sanctionListTableView= FXCollections.observableArrayList();
         // Initialisation d'une liste observable pour stocker les résultats

        while (result.next()) { // Boucle sur les résultats du ResultSet
            Sanction sanction = new Sanction(0,0);
                sanction.setDuréeRetard(result.getInt("Durée_retard"));
                sanction.setDuréeSanction(result.getInt("Durée_sanction"));

            sanctionListTableView.add(sanction); // Ajout de l'objet Lecteur à la liste observable
        }
        
        // Mise en place des colonnes dans le TableView à partir des propriétés de l'objet Bibliothecaire
        duréeRetard_col.setCellValueFactory(new PropertyValueFactory<>("duréeRetard"));
        duréeSanction_col.setCellValueFactory(new PropertyValueFactory<>("duréeSanction"));
       


                    //CREATE CELL FACTORY TO INSERT BUTTONS IN EVERY ROWS:
            Callback<TableColumn<Sanction, String>, TableCell<Sanction, String>> cellFactory = (param) -> {
                //make the tableCell containing button
                
                final TableCell<Sanction, String> cell = new TableCell<Sanction, String>() {

                    //override update method
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        //Esure the cell is created only non-empty rows
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            final MFXButton modifierButton = new MFXButton("Modifier");
                            modifierButton.setStyle(
                                    "-fx-background-color:   #02e477; "
                                    + "-fx-text-fill: white;"
                                    + " -fx-background-radius: 5;"
                                    + " -fx-font-family: 'Comfortaa';"
                                    + " -fx-font-weight: bold;"
                            );
                           
                            //Attach listenner to the button to do the action
                          
                           
                            //remberer to set the created button to the cell
                            final HBox hbox = new HBox(modifierButton);
                            HBox.setMargin(modifierButton, new Insets(0,2, 0, 0));
                            setGraphic(hbox);
                            setText(null);
                            modifierButton.setOnAction((ActionEvent event) -> {
                               // Bibliothecaire up = getTableView().getItems().get(getIndex());
                                //DialogSupprimerLecteur(event, up);
                            });
                        }
                    }
                };
                
                return cell;
            };
             Callback<TableColumn<Sanction, String>, TableCell<Sanction, String>> cellF = (param) -> {
                //make the tableCell containing button
                
                final TableCell<Sanction, String> cell = new TableCell<Sanction, String>() {

                    //override update method
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        //Esure the cell is created only non-empty rows
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            final MFXButton supprimerButton = new MFXButton("Supprimer");
                            supprimerButton.setStyle(
                                    "-fx-background-color:  #ff1241;"
                                    + " -fx-text-fill: white;"
                                    + " -fx-background-radius: 5;"
                                    + " -fx-font-family: 'Comfortaa';"
                                    + "-fx-font-weight: bold;"
                            );
                            //Attach listenner to the button to do the action
                          
                           
                            //remberer to set the created button to the cell
                            final HBox hbox = new HBox(supprimerButton);
                            HBox.setMargin(supprimerButton, new Insets(0, 0, 0, 2));
                            setGraphic(hbox);
                            setText(null);
                            supprimerButton.setOnAction((ActionEvent event) -> {
                               // Bibliothecaire up = getTableView().getItems().get(getIndex());
                                //DialogSupprimerLecteur(event, up);
                            });
                        }
                    }
                };
                
                return cell;
            };
modifierSanction_col.setCellFactory(cellFactory);
supprimerSanction_col.setCellFactory(cellF);
sanction_tab.setItems(sanctionListTableView);

    } catch (SQLException ex) { // Gestion d'erreur en cas de problème avec la base de données
        Logger.getLogger(gerantController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
   
     private void DialogSupprimerLecteur(ActionEvent event, Lecteur lecteur){
        this.dialogContent = MFXGenericDialogBuilder.build()
					.setContentText(
                                                "VOUS LES VOUS VRAIMENT SUPPRIMER Lecteur: \nID: "+lecteur.getId_lecteur()
                                                +"\nNOM: "+lecteur.getNom_lecteur()
                                                +"\nPRENOM: "+lecteur.getPrenom_lecteur()
                                                +"\nADRESSE: "+lecteur.getAdresse_lecteur()
                                                +"\nTELEPHONE: "+lecteur.getNumTel_lecteur()
                                                +"\nTYPE: "+lecteur.getType_lecteur()
                                                +"\nEmail: "+lecteur.getEmail_lecteur()
                                                +"\nPaiement: "+lecteur.getPaiment_lecteur()
                                        )
					.makeScrollable(true)
					.get(); 
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			this.dialog = MFXGenericDialogBuilder.build(dialogContent)
					.toStageDialogBuilder()
                                        .initOwner(window)
					.initModality(Modality.APPLICATION_MODAL)
					.setDraggable(true)
					.setTitle("Dialogs Preview")
					.setOwnerNode(mainborderPane)
					.setScrimPriority(ScrimPriority.WINDOW)
					.setScrimOwner(true)
					.get();
        
        MFXButton cancel = new MFXButton("Cancel");
        MFXButton confirmer = new MFXButton("Confirmer");
        confirmer.setOnAction(e -> {
            lecteur.supprimerLecteur(lecteur);
            listLecteurTableView();
            
            
            dialog.close();
        });
        cancel.setOnAction(e -> {
            dialog.close();
        });
        dialogContent.addActions(
                confirmer,
                cancel
        );            

			

	dialogContent.setMaxSize(400, 200);
        MFXFontIcon infoIcon = new MFXFontIcon("mfx-info-circle-filled", 18);
	dialogContent.setHeaderIcon(infoIcon);
	dialogContent.setHeaderText("MESSAGE INFORMATION");
	convertDialogTo("mfx-info-dialog");
        
        // On récupère la taille de l'écran (la résolution)
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // et on place notre fenêtre au milieu
	dialog.showDialog();  
        
    }


    @FXML
    private void show_acc(MouseEvent event) {
          Acc_pan.setVisible(true);
        abn_pan.setVisible(false);
        sanc_pan.setVisible(false);
        biblio_pan.setVisible(false);
        edit_pan.setVisible(false);
        acc_btn.setStyle("-fx-background-color:white;-fx-border-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-width:3px");
        sanc_btn.setStyle("-fx-background-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
        abn_btn.setStyle("-fx-background-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
        biblio_btn.setStyle("-fx-background-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
    }

    @FXML
    private void show_boblio(MouseEvent event) {
        Acc_pan.setVisible(false);
        abn_pan.setVisible(false);
        sanc_pan.setVisible(false);
        biblio_pan.setVisible(true);
        edit_pan.setVisible(false);
         biblio_btn.setStyle("-fx-background-color:white;-fx-border-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-width:3px");
        sanc_btn.setStyle("-fx-background-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
        abn_btn.setStyle("-fx-background-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
        acc_btn.setStyle("-fx-background-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
    
    }

    @FXML
    private void show_abn(MouseEvent event) {
         Acc_pan.setVisible(false);
        abn_pan.setVisible(true);
        sanc_pan.setVisible(false);
        biblio_pan.setVisible(false);
        edit_pan.setVisible(false);
        abn_btn.setStyle("-fx-background-color:white;-fx-border-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-width:3px");
        sanc_btn.setStyle("-fx-background-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
        acc_btn.setStyle("-fx-background-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
        biblio_btn.setStyle("-fx-background-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
    
    }

   

    @FXML
    private void show_sanc(MouseEvent event) {
         Acc_pan.setVisible(false);
        abn_pan.setVisible(false);
        sanc_pan.setVisible(true);
        biblio_pan.setVisible(false);
        edit_pan.setVisible(false);
        sanc_btn.setStyle("-fx-background-color:white;-fx-border-color:linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-width:3px");
        acc_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
        abn_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
        biblio_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
    
    }

    @FXML
    private void log_out(MouseEvent event) throws IOException {
         System.out.println("You clicked me!");
           Stage stage= new Stage();
            Parent root=FXMLLoader.load(getClass().getResource("/view/connexion.fxml"));
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void show_editpan(MouseEvent event) {
        Acc_pan.setVisible(false);
        abn_pan.setVisible(false);
        sanc_pan.setVisible(false);
        biblio_pan.setVisible(false);
        edit_pan.setVisible(true);
         sanc_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
        acc_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
        abn_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
        biblio_btn.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #adf7f2, #15aaff);-fx-border-color:transparent");
    
    }



    @FXML
    private void reduire(MouseEvent event) {
        Stage stage=(Stage) reduire_btn.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void close(MouseEvent event) {
     
        javafx.application.Platform.exit();
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
    private void red_color(MouseEvent event) {
        close_btn.setStyle("-fx-background-color:red");
        x_icon.setStyle("-fx-fill:white");
    }

    @FXML
    private void initialcolse_color(MouseEvent event) {
        close_btn.setStyle("-fx-background-color:transparent");
        x_icon.setStyle("-fx-fill:black");
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
    
    //les fonction du BackEnd//
    public void clearchampsabbonne(){
    nomAbonné_txt.setText("");
    prénomAbonné_txt.setText("");
    
    numeroTelAbonné_txt.setText("");
    adresseAbonné_txt.setText("");
    emailAbonné_txt.setText("");
    }
    
  public boolean checkFieldsAbonne() {
      return nomAbonné_txt.getText().isEmpty() ||
              prénomAbonné_txt.getText().isEmpty() ||
              numeroTelAbonné_txt.getText().isEmpty() ||
              adresseAbonné_txt.getText().isEmpty() ||
              emailAbonné_txt.getText().isEmpty();
   
}
  public String GetType(){
   if (etudInterne_rdBtn.isSelected()){
             return "etudiant interne";
         }else{
             if(etudExterne_rdBtn.isSelected()){
              return "etudiant externe";
             }else if(enseignant_rdBtn.isSelected()){
                 return "enseignant";
             }else{
              return null;
             }
         }
  }

  public String checkpayemnt() {
if (etudInterne_rdBtn.isSelected()==true) {
        if(paiement_interne_checkBox.isSelected()==true){
        return "vrai";
        }
        return "faux";
} else if (etudExterne_rdBtn.isSelected()==true) {
    if(paiement_externe_checkBox.isSelected()==true){
    return "vrai";
    }
    return "faux";
} else {
return "faux";
}
}
    public boolean checketudiantextern(){
  if(etudExterne_rdBtn.isSelected()){
      return paiement_interne_checkBox.isSelected();
             }else{
                 return true;
             }
  }

    
    
    @FXML
    private void ajouterBiblio(MouseEvent event) {
        ajouterBibliothecaire(event);
        listBibliothecairesTableView();

    }
    @FXML
    private void rechercheBiblio(MouseEvent event) {
    }
    @FXML
    private void rechercheAbonnée(MouseEvent event) {
    }

    private MFXGenericDialog dialogContent;
    private MFXStageDialog dialog;
    @FXML
    private BorderPane mainborderPane;
     private void convertDialogTo(String styleClass) {
        dialogContent.getStyleClass().removeIf(
                s -> s.equals("mfx-info-dialog") || s.equals("mfx-warn-dialog") || s.equals("mfx-error-dialog")
        );

        if (styleClass != null) {
            dialogContent.getStyleClass().add(styleClass);
        }
    }
     private void DialogMessage(MouseEvent event, String text) {
        this.dialogContent = MFXGenericDialogBuilder.build()
                .setContentText(text)
                .makeScrollable(true)
                .get();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.dialog = MFXGenericDialogBuilder.build(dialogContent)
                .toStageDialogBuilder()
                .initOwner(window)
                .initModality(Modality.APPLICATION_MODAL)
                .setDraggable(true)
                .setTitle("Dialogs Preview")
                .setOwnerNode(mainborderPane)
                .setScrimPriority(ScrimPriority.WINDOW)
                .setScrimOwner(true)
                .get();

        MFXButton cancel = new MFXButton("Cancel");
        cancel.setOnAction(e -> {
            dialog.close();
        });
        dialogContent.addActions(
                cancel
        );

        dialogContent.setMaxSize(400, 200);
        MFXFontIcon infoIcon = new MFXFontIcon("mfx-info-circle-filled", 18);
        dialogContent.setHeaderIcon(infoIcon);
        dialogContent.setHeaderText("MESSAGE INFORMATION");
        convertDialogTo("mfx-info-dialog");

        // On récupère la taille de l'écran (la résolution)
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // et on place notre fenêtre au milieu
        dialog.showDialog();

    }
    @FXML
    private void ajouterAbonné(MouseEvent event) {
          if(checkFieldsAbonne()){
            DialogErreurChampsVide(event,"Veuillez Saisir Tout Les Champs");
        }else{
           
                System.out.println("tout les champs sont complet");
                Lecteur model = new Lecteur();
                model.setNom_lecteur(nomAbonné_txt.getText());
                model.setPrenom_lecteur(prénomAbonné_txt.getText());
                model.setNumTel_lecteur(numeroTelAbonné_txt.getText());
                model.setAdresse_lecteur(adresseAbonné_txt.getText());
                model.setEmail_lecteur(emailAbonné_txt.getText());
                model.setDateA_lecteur(java.time.LocalDate.now()+"");
                model.setType_lecteur(GetType());
                model.setPaiment_lecteur(checkpayemnt());
                model.ajouterLecteur(model);             
                listLecteurTableView();
                clearchampsabbonne();
                DialogMessage(event,"Article a été Ajouter Avec Succes");
                clearchampsabbonne();
               
            }
        
    }
        
    //ajouter bibliothecaire
    private void ajouterBibliothecaire(MouseEvent event) {
       // if(checkFieldsAbonne()){
        //DialogErreurChampsVide(event,"Veuillez Saisir Tout Les Champs");
      // }else{
           
                System.out.println("tout les champs sont complet");
                Bibliothecaire model = new Bibliothecaire(0,"","","","","","",0);
                model.setId_utilisateur(15);
                model.setNom_biblio(nomBiblio_txt.getText());
                model.setPrenom_biblio(prenomBiblio_txt.getText());
                model.setAdresse_biblio(adresseBiblio_txt.getText());
                model.setNumTel_biblio(Integer.valueOf(numeroTelBiblio_txt.getText()));
                model.setEmail_biblio(emailBiblio_txt.getText());
                model.setNom_utilisateur(userNameBiblio_txt.getText());
                model.setPassword(passwordBiblio_txt.getText());
                if(model.comparerMdp(passwordBiblio_txt.getText(), confirmePasswordBiblio_txt.getText())){
                     model.ajouterBibliothecaire(model);
                     DialogMessage(event,"bibliothecaire a été Ajouté Avec Succes");
                }else{
                     DialogMessage(event,"les mot de passes sont differents");
                     
                };
                
             //   clearchampsabbonne();
                
              //  clearchampsabbonne();
          //  }
        
    }
    
    
    
   
      public int dureRetard(){
      int dureeR=0;
         if (retard_jour_RDbtn.isSelected()){
             retard_mois_RDbtn.setSelected(false);
             retard_semaine_RDbtn.setSelected(false);
             dureeR=1;
         }else {
             if(retard_semaine_RDbtn.isSelected()){
                 retard_jour_RDbtn.setSelected(false);
                 retard_mois_RDbtn.setSelected(false);
              dureeR= 7 ;
             }else if(retard_mois_RDbtn.isSelected()){
                 retard_jour_RDbtn.setSelected(false);
                 retard_semaine_RDbtn.setSelected(false);
                 dureeR= 30;
             }
         }
                  System.out.println(dureeR);

     return dureeR;    
  }
  
    public int dureSanction(){
      int dureeS=0;
         if (sanction_jour_RDbtn.isSelected()){
             sanction_semain_RDbtn.setSelected(false);
             sanction_mois_RDbtn.setSelected(false);
             dureeS=1;
         }else {
             if(sanction_semain_RDbtn.isSelected()){
              sanction_mois_RDbtn.setSelected(false);
              sanction_jour_RDbtn.setSelected(false);
              dureeS= 7 ;
             }else if(sanction_mois_RDbtn.isSelected()){
                sanction_semain_RDbtn.setSelected(false);
                sanction_jour_RDbtn.setSelected(false);
                 dureeS= 30;
             }
         }
         System.out.println(dureeS);
     return dureeS;    
  }
    
    
 
        
    public int convertToInteger(TextField textField) {
        String value = textField.getText();
        int intValue = 0;

        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            // Handle the case where the value cannot be converted to an integer
            // You can display an error message or take appropriate action here
            e.printStackTrace();
        }

        return intValue;
    }
    
        private void creerSanction(MouseEvent event) {
        //  if(checkFieldsAbonne()){
         //   DialogErreurChampsVide(event,"Veuillez Saisir Tout Les Champs");
      //  }else{
           
                System.out.println("tout les champs sont complet");
                Sanction sanction = new Sanction(0,0);
                int sanc=convertToInteger(retard_txt);
                sanction.setDuréeRetard(dureRetard()*sanc);
                int ret=convertToInteger(sanction_txt);
                sanction.setDuréeSanction(dureSanction()*ret);      
                sanction.ajouterSanctionToDb(sanction);
                sanc=0;
                ret=0;
                DialogMessage(event,"Article a été Ajouter Avec Succes");
               
            }
        
   // }
    
    
    
    
    
    
    
    
    
    private void DialogErreurChampsVide(MouseEvent event, String text){
        this.dialogContent = MFXGenericDialogBuilder.build()
					.setContentText(text)
					.makeScrollable(true)
					.get(); 
                        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			this.dialog = MFXGenericDialogBuilder.build(dialogContent)
					.toStageDialogBuilder()
                                        .initOwner(window)
					.initModality(Modality.APPLICATION_MODAL)
					.setDraggable(true)
					.setTitle("Dialogs Preview")
					.setOwnerNode(mainborderPane)
					.setScrimPriority(ScrimPriority.WINDOW)
					.setScrimOwner(true)
					.get();
        
        MFXButton cancel = new MFXButton("Cancel");
        cancel.setOnAction(e -> {
            dialog.close();
        });
        dialogContent.addActions(
                cancel
        );            

			

	dialogContent.setMaxSize(400, 200);
        MFXFontIcon infoIcon = new MFXFontIcon("mfx-info-circle-filled", 18);
	dialogContent.setHeaderIcon(infoIcon);
	dialogContent.setHeaderText("MESSAGE INFORMATION");
	convertDialogTo("mfx-info-dialog");
        
        // On récupère la taille de l'écran (la résolution)
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        // et on place notre fenêtre au milieu
	dialog.showDialog();  
        
    }
    

    @FXML
    private void ajouterSanction(MouseEvent event) {
        creerSanction(event);
        listSanctionsTableView();
    }

    @FXML
    private void updateAccount(MouseEvent event) {
    }

    

}
    
    
