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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class stationcontroller {

    @FXML
    private TextArea showDetails;

    @FXML
    private Button showData;

    @FXML
    private Button update;

    @FXML
    private Label title;

    @FXML
    private Label tText;
    
    @FXML
    private Button Close;

    @FXML
    void Onclickclose(ActionEvent event) {
    	Stage stage = (Stage) Close.getScene().getWindow();
        stage.close();
    }


    @FXML
    void onClickShowData(ActionEvent event) {
        int booths = 0;
        int enable = 0;
        int disable = 0;
        int capacity = 0;
        String power = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shree123");

            String sql = "SELECT * FROM station_details";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                booths = rs.getInt("no_of_booths");
                enable = rs.getInt("enable_booths");
                disable = rs.getInt("disable_booths");
                capacity = rs.getInt("capacity");
                power = rs.getString("total_power");

                String data = "no_of_booths: " + booths + "\nenable_booths: " + enable + "\ndisable_booths: "
                        + disable + "\ncapacity: " + capacity + "\ntotal_power: " + power;
                showDetails.setText(data);
                tText.setText("Data found successfully");
            } else {
                showDetails.setText("");
                tText.setText("Data not found... please enter the information of a new user");
            }

            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickUpdate(ActionEvent event) {
    	try {

    		//Parent root = FXMLLoader.load(getClass().getResource("/Resources/WelcomePage.fxml"));

    		Parent root = FXMLLoader.load(getClass().getResource("/Resources/update.fxml"));

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
