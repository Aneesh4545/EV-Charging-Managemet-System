package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustmorController {

    @FXML
    private TextField name;

    @FXML
    private TextField phoneno;

    @FXML
    private TextField vehicle;

    @FXML
    private TextField vname;

    @FXML
    private Button submit;

    @FXML
    private Label warning;
    

    @FXML
    private Label cno;

    @FXML
    private Label pno;

    @FXML
    private Label vno;

    @FXML
    private Label vehiclename;


    @FXML
    private void handleSubmission(ActionEvent event) {
        String userName = name.getText();
        long phoneNo = Long.parseLong(phoneno.getText());
        String vehicleNo = vehicle.getText();
        String vehicleName = vname.getText();

        // Perform desired operations with the customer details
        // e.g., store in a database, display a message, etc.

        System.out.println("Submitted Customer Details:");
        System.out.println("User Name: " + userName);
        System.out.println("Phone No: " + phoneNo);
        System.out.println("Vehicle No: " + vehicleNo);
        System.out.println("Vehicle Name: " + vehicleName);

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shree123");
            if (userName.isEmpty() || vehicleNo.isEmpty() || vehicleName.isEmpty()) {
                warning.setText("Please fill all required fields");
            } else {
                String sql = "INSERT INTO customer (id, name, phone_no, vehicle_no, vehicle_name) VALUES (customer_seq.nextval, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, userName);
                stmt.setLong(2, phoneNo);
                stmt.setString(3, vehicleNo);
                stmt.setString(4, vehicleName);

                int rowsAffected = stmt.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);

                stmt.close();
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) submit.getScene().getWindow();
        stage.close();
    }
}

