/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import control.DBconnect;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
/**
 * FXML Controller class
 *
 * @author Mes documants
 */
public class connexionController implements Initializable {

    @FXML
    private JFXButton btnlogin;
    @FXML
    private Button reduire_btn;
    @FXML
    private Button close_btn;
    @FXML
    private FontAwesomeIconView minus_icon;
    @FXML
    private FontAwesomeIconView x_icon;
    @FXML
    private JFXTextField userName_txt;
    @FXML
    private JFXPasswordField passWord_txt;
     
    ObservableList listUtilisateur;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
public int getUser(){
    try {
         String query="SELECT * FROM utilisateur WHERE Nom_utilisateur='"+userName_txt.getText()+
                 "' AND Mot_de_pass='"+passWord_txt.getText()+"'"
;            DBconnect db= new DBconnect();
            Connection connection = (Connection) db.ConnectBd();
            PreparedStatement prepare = connection.prepareStatement(query);
            ResultSet result = prepare.executeQuery();
           
            while (result.next()) {  
                int id_user = result.getInt("ID");
               return id_user;    
            }
    } catch (Exception e) {
            System.out.println("Failed...");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            
    }
    return 0;
}


    @FXML
    private void connecter(MouseEvent event) throws IOException {
        System.out.println(getUser());
        if(!userName_txt.getText().matches("a-zA-Z0-9]{4,}") && passWord_txt.getText().isEmpty()){
           Notifications notification =Notifications.create();
           notification.title("Error");
           notification.text("wrong userName or passWord");
           notification.hideAfter(Duration.seconds(5));
           notification.position(Pos.BASELINE_CENTER);
           notification.show();
           passWord_txt.setText("");
           userName_txt.setText("");
        }else{
            if(getUser()==1){
             Stage stage= new Stage();
            Parent root=FXMLLoader.load(getClass().getResource("/view/espace_gerant.fxml"));
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            ((Node)event.getSource()).getScene().getWindow().hide();
            }else{
                if(getUser()==0){
                    Notifications notification =Notifications.create();
                    notification.title("Error");
                    notification.text("wrong userName or passWord");
                    notification.hideAfter(Duration.seconds(5));
                    notification.position(Pos.BASELINE_CENTER);
                    notification.show();
                    passWord_txt.setText("");
                    userName_txt.setText("");
                }else{
                     Stage stage= new Stage();
           Parent root=FXMLLoader.load(getClass().getResource("/view/espace_bibliothecaire.fxml"));
            Scene scene =new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            ((Node)event.getSource()).getScene().getWindow().hide();
                }
            }}
        
      
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
    private void initialcolse_color(MouseEvent event) {
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
}




/*
      public int dureRetard(){
      int dureeR=0;
         if (retard_jour_RDbtn.isSelected()){
             dureeR=1;
         }else {
             if(retard_semaine_RDbtn.isSelected()){
              dureeR= 7 ;
             }else if(retard_mois_RDbtn.isSelected()){
                 dureeR= 30;
             }
         }
     return dureeR;    
  }
  
    public int dureSanction(){
      int dureeS=0;
         if (retard_jour_RDbtn.isSelected()){
             dureeS=1;
         }else {
             if(retard_semaine_RDbtn.isSelected()){
              dureeS= 7 ;
             }else if(retard_mois_RDbtn.isSelected()){
                 dureeS= 30;
             }
         }
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
    
        private void ajouterSanction(MouseEvent event) {
        //  if(checkFieldsAbonne()){
         //   DialogErreurChampsVide(event,"Veuillez Saisir Tout Les Champs");
      //  }else{
           
                System.out.println("tout les champs sont complet");
                Sanction sanction = new Sanction(0,0);
                int sanc=convertToInteger(sanction_txt);
                sanction.setDuréeRetard(dureRetard()*sanc);
                int ret=convertToInteger(retard_txt);
                sanction.setDuréeSanction(dureSanction()*ret);      
                try {
        String query = "INSERT INTO sanction (Durée_retard, Durée_sanction) " +
                "VALUES ('" + sanction.getDuréeRetard() + "', '" + sanction.getDuréeSanction() + "')";
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
                DialogMessage(event,"Article a été Ajouter Avec Succes");
               
            }
        
   // }*/