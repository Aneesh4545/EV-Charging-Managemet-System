package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class managecontroller {

    @FXML
    private Button newuser;
    
    @FXML
    private Button showd;

    @FXML
    private Button charge;

    @FXML
    private Button history;

    @FXML
    private Button Maintenance;
    
    @FXML
    private Button Search;
    
    @FXML
    private TableView<DisplayAnimalData> staustable;

    @FXML
    private TableColumn<DisplayAnimalData, Integer> portno;

    @FXML
    private TableColumn<DisplayAnimalData, String> vno;

    @FXML
    private TableColumn<DisplayAnimalData, String> cname;

    @FXML
    private TableColumn<DisplayAnimalData, String> vname;
    
    @FXML
    private Button logout;
    
    @FXML
    void onshow(ActionEvent event) {
    	portno.setCellValueFactory(new PropertyValueFactory<>("DisplayAnimalDataId"));

    	vno.setCellValueFactory(new PropertyValueFactory<>("name"));

    	cname.setCellValueFactory(new PropertyValueFactory<>("slides"));
    	
    	vname.setCellValueFactory(new PropertyValueFactory<>("vehi_name"));
    	

    	ObservableList<DisplayAnimalData> DisplayAnimalDataList = retrieveDisplayAnimalDataDetails();

    	staustable.setItems(DisplayAnimalDataList);

    	}
    private ObservableList<DisplayAnimalData> retrieveDisplayAnimalDataDetails() {

    	ObservableList<DisplayAnimalData> DisplayAnimalDataList = FXCollections.observableArrayList();

    	try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shree123");

        Statement statement = connection.createStatement();
    			

    	ResultSet resultSet = statement.executeQuery("SELECT * FROM customer")) {

    	while (resultSet.next()) {

    	int DisplayAnimalDataId = resultSet.getInt("id");
    	
    	
    	String name = resultSet.getString("name");

    	String slides = resultSet.getString("vehicle_no");
    	
    	String  vehi_name = resultSet.getString("vehicle_name");
    	
    	 
    	
    	
    	

    	
    	DisplayAnimalData DisplayAnimalData = new DisplayAnimalData( DisplayAnimalDataId, name, slides, vehi_name);

    	DisplayAnimalDataList.add(DisplayAnimalData);

    	}

    	} catch (SQLException e) {

    	e.printStackTrace();

    	}
    	
    	return DisplayAnimalDataList;
    }


@FXML
void onclick_Search(ActionEvent event) {
	
	try {

		//Parent root = FXMLLoader.load(getClass().getResource("/Resources/WelcomePage.fxml"));

		Parent root = FXMLLoader.load(getClass().getResource("/Resources/Vehicle.fxml"));

		Scene scene = new Scene(root);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         Stage stage1 = new Stage();
         stage1.setTitle("userpage");
         stage1.setScene(scene);
         stage1.show();

		} catch(Exception e) {

		e.printStackTrace();

		}
}

@FXML
void onhistoryclick(ActionEvent event) {
	
	try {

		//Parent root = FXMLLoader.load(getClass().getResource("/Resources/WelcomePage.fxml"));

		Parent root = FXMLLoader.load(getClass().getResource("/Resources/history.fxml"));

		Scene scene = new Scene(root);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         Stage stage1 = new Stage();
         stage1.setTitle("userpage");
         stage1.setScene(scene);
         stage1.show();

		} catch(Exception e) {

		e.printStackTrace();

		}
    
}

@FXML
void onmaintenanceclick(ActionEvent event) {
	
	
	try {

		//Parent root = FXMLLoader.load(getClass().getResource("/Resources/WelcomePage.fxml"));

		Parent root = FXMLLoader.load(getClass().getResource("/Resources/stationdetails.fxml"));

		Scene scene = new Scene(root);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         Stage stage1 = new Stage();
         stage1.setTitle("userpage");
         stage1.setScene(scene);
         stage1.show();

		} catch(Exception e) {

		e.printStackTrace();

		}

}

@FXML
void onnewuserclick(ActionEvent event) {
	

	try {

		//Parent root = FXMLLoader.load(getClass().getResource("/Resources/WelcomePage.fxml"));

		Parent root = FXMLLoader.load(getClass().getResource("/Resources/CoustomerDetailes.fxml"));

		Scene scene = new Scene(root);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         Stage stage1 = new Stage();
         stage1.setTitle("userpage");
         stage1.setScene(scene);
         stage1.show();

		} catch(Exception e) {

		e.printStackTrace();

		}

}


@FXML
void onclick_charge(ActionEvent event) {
	try {

		//Parent root = FXMLLoader.load(getClass().getResource("/Resources/WelcomePage.fxml"));

		Parent root = FXMLLoader.load(getClass().getResource("/Resources/charge.fxml"));

		Scene scene = new Scene(root);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         Stage stage1 = new Stage();
         stage1.setTitle("userpage");
         stage1.setScene(scene);
         stage1.show();

		} catch(Exception e) {

		e.printStackTrace();

		}
}


@FXML
void on_click_logout(ActionEvent event) {
	try {

		//Parent root = FXMLLoader.load(getClass().getResource("/Resources/WelcomePage.fxml"));

		Parent root = FXMLLoader.load(getClass().getResource("/Resources/login.fxml"));

		Scene scene = new Scene(root);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         Stage stage1 = new Stage();
         stage1.setTitle("userpage");
         stage1.setScene(scene);
         stage1.show();

		} catch(Exception e) {

		e.printStackTrace();

		}
 
}
}