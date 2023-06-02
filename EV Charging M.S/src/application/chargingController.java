package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class chargingController {

    @FXML
    private TextField vehicleNo;

    @FXML
    private TextField levelOfCharging;

    @FXML
    private TextField time;

    @FXML
    private Button chargingSubmit;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label warning;

    @FXML
    void onClickChargingSubmit(ActionEvent event) {
        // Your existing code for handling the button click
        // ...
    	String tVehicleNo = vehicleNo.getText();
        String tTime = time.getText();
        String tLevel = levelOfCharging.getText();
        LocalDate tDate = datePicker.getValue();

        System.out.println("Enter the data to charge the vehicle:");
        System.out.println("");

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shree123");
            if (tVehicleNo.isEmpty() || tTime.isEmpty() || tLevel.isEmpty() || tDate == null) {
                warning.setText("Please fill all required fields");
            } else {
                String sql = "INSERT INTO charging_station(vehicle_no, time, levelofcharging, \"date\") VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, tVehicleNo);
                stmt.setString(2, tTime);
                stmt.setString(3, tLevel);
                stmt.setDate(4, Date.valueOf(tDate));

                int rowsAffected = stmt.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);

                stmt.close();
                
                Stage stage = (Stage) chargingSubmit.getScene().getWindow();
                stage.close();
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
