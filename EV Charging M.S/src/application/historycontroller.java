package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;


public class historycontroller {
    @FXML
    private Label history;

    @FXML
    private TableView<DisplayHistoryData> table;
    
    @FXML
    private Rectangle color;


    @FXML
    private TableColumn<DisplayHistoryData, Integer> id;

    @FXML
    private TableColumn<DisplayHistoryData, String> name;

    @FXML
    private TableColumn<DisplayHistoryData, String> phone;

    @FXML
    private TableColumn<DisplayHistoryData, String> no;

    @FXML
    private TableColumn<DisplayHistoryData, String> vname;

    @FXML
    private TableColumn<DisplayHistoryData, Date> date;

    @FXML
    private TableColumn<DisplayHistoryData, String> level;
    
    @FXML
    private Button close;

    @FXML
    void close(ActionEvent event) {

        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
        
    }

    @FXML
    private Button show;

    @FXML
    void onShowButtonClicked(ActionEvent event) {
        id.setCellValueFactory(new PropertyValueFactory<>("displayHistoryDataId"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        no.setCellValueFactory(new PropertyValueFactory<>("vehicle_no"));
        vname.setCellValueFactory(new PropertyValueFactory<>("vehicleName"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        level.setCellValueFactory(new PropertyValueFactory<>("level"));

        table.setItems(getDisplayHistoryData());
    }

    private ObservableList<DisplayHistoryData> getDisplayHistoryData() {
        ObservableList<DisplayHistoryData> data = FXCollections.observableArrayList();

        try {
            // Connect to the database
        	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shree123");

            // Create a statement
            Statement statement = con.createStatement();

            // Retrieve data from the database
            ResultSet resultSet = statement.executeQuery("SELECT * FROM history");

            // Iterate through the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone_no");
                String no = resultSet.getString("vehicle_no");
                String vehicleName = resultSet.getString("vehicle_name");
                Date date = resultSet.getDate("date");
                String level = resultSet.getString("levelofcharging");

                // Create a new DisplayHistoryData object and add it to the list
                DisplayHistoryData historyData = new DisplayHistoryData(id, name, phone, no, vehicleName, date, level);
                data.add(historyData);
            }

            // Close the connection
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
