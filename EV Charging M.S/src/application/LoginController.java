package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField username;
    
    @FXML
    private ImageView image1;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Label valid;

    @FXML
    private Button login;

    @FXML
    private Hyperlink forget;

    @FXML
    private void handleLogin(ActionEvent event) {
    	System.out.println("hiii");

        String user = username.getText();
        String pass = password.getText();
        String name = null;
        String password1 = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shree123");

            String sql1 = "SELECT * FROM manager WHERE manager_id='" + user + "'";

            Statement st1 = con.createStatement();

            ResultSet rs1 = st1.executeQuery(sql1);

            while (rs1.next()) {
                System.out.println("3");
                name = rs1.getString("name");
                password1 = rs1.getString("password");
                user = rs1.getString("manager_id");
                System.out.println("manager_id: " + user + ", Name: " + name + ", password: " + password1);
            }

            st1.close();
            con.close();

            if (password1 != null && password1.equals(pass)&& user.equals(user)) {
            	
            	System.out.println("hiii1234");
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/manage.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                    Stage primaryStage = new Stage();
                    primaryStage.setTitle("Welcome Page");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    
                    Stage stage = (Stage) login.getScene().getWindow();
                    stage.close();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }    String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        // Perform login verification
        // You can add your logic here to validate the entered username and password
        // For example, compare them with stored values or check against a database

        if (enteredUsername.equals("admin") && enteredPassword.equals("password")) {
            System.out.println("Login successful!");
            // Perform actions for successful login, such as navigating to another scene
        } else {
            System.out.println("Login failed!");
            valid.setText("Please Enter valid details");
            // Perform actions for failed login, such as displaying an error message
        }
    }
}
