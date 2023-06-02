package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class searchcontroller {

    @FXML
    private TextField V_NO;

    @FXML
    private Button SEARCH;

    @FXML
    private TextArea status;

    @FXML
    private Label warning;
    
    @FXML
    private Button delete;
    
    @FXML
    private Label comment;
    
    @FXML
    private Button close;

    @FXML
    void on_click_close(ActionEvent event) {
    	 Stage stage = (Stage) close.getScene().getWindow();
         stage.close();
    }


    @FXML
    void onclicksearch(ActionEvent event) {
        String name = null;
        long phoneno = 0; // Changed the data type to long
        String tvehicle_no = null;
        String vehicle_name = null;

        tvehicle_no = V_NO.getText();
        String vno = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shree123");
            String sql2 = "SELECT * FROM customer WHERE vehicle_no = '" + tvehicle_no + "'";
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);

            if (!rs2.next()) {
                warning.setText("Please make new entry for the vehicle");
            } else {
                String sql1 = "SELECT * FROM customer WHERE vehicle_no = '" + tvehicle_no + "'";
                Statement st1 = con.createStatement();
                ResultSet rs1 = st1.executeQuery(sql1);

                if (rs1.next()) {
                    name = rs1.getString("name");
                    phoneno = rs1.getLong("phone_no"); // Retrieve phone number as long
                    vehicle_name = rs1.getString("vehicle_name");

                    String data = "ID: " + rs1.getInt("id") + "\nName: " + name + "\nPhone number: " + phoneno
                            + "\nVehicle name: " + vehicle_name;
                    status.setText(data);
                    warning.setText("Data found successfully");
                } else {
                    warning.setText("Data not found... please enter the information of a new user");
                }
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    void onclick_delete(ActionEvent event) {
             
    	 

          String tvehicle_no = V_NO.getText();
          String vno = null;
    	         
    	try {
             Class.forName("oracle.jdbc.OracleDriver");
             Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shree123");
             String sql2 = "DELETE FROM customer WHERE vehicle_no = '" + tvehicle_no + "'";
            
             Statement st2 = con.createStatement();
             ResultSet rs2 = st2.executeQuery(sql2);
              st2.close();
           con.close();
           
           comment.setText("Deleted succesfully!!");
         } catch (SQLException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
    }
}
