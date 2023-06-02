package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class updatecontroller {

    @FXML
    private TextField total;

    @FXML
    private TextField enable;

    @FXML
    private TextField disable;

    @FXML
    private TextField capacity;

    @FXML
    private TextField power;

    @FXML
    private Button submit;

    @FXML
    private Label warning;

    @FXML
    void onclicksubmit(ActionEvent event) {
        try {
            int ttotal = Integer.parseInt(total.getText());
            int tenable = Integer.parseInt(enable.getText());
            int tdisable = Integer.parseInt(disable.getText());
            int tcapacity = Integer.parseInt(capacity.getText());
            String tpower = power.getText();

            System.out.println("Submitted Customer Details:");
            System.out.println("Total number of booths: " + ttotal);
            System.out.println("Number of enable booths: " + tenable);
            System.out.println("Number of disable booths: " + tdisable);
            System.out.println("Capacity of charging station: " + tcapacity);
            System.out.println("Total power of station: " + tpower);

            if (ttotal <= 0 || tenable <= 0 || tdisable <= 0 || tcapacity <= 0 || tpower.isEmpty()) {
                warning.setText("Please fill all required fields");
            } else {
                Class.forName("oracle.jdbc.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shree123");

                String sql = "UPDATE station_details SET no_of_booths=?, enable_booths=?, disable_booths=?, capacity=?, total_power=? WHERE station_id=1";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, ttotal);
                stmt.setInt(2, tenable);
                stmt.setInt(3, tdisable);
                stmt.setInt(4, tcapacity);
                stmt.setString(5, tpower);

                int rowsAffected = stmt.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);

                stmt.close();
                con.close();
                
                Stage stage = (Stage) submit.getScene().getWindow();
                stage.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQLException
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle ClassNotFoundException
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle NumberFormatException (for parsing integers)
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any other exceptions
        }
    }
}
