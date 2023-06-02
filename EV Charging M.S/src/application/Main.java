	package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

						
		Parent root = FXMLLoader.load(getClass().getResource("/resources/manage.fxml"));

		//Parent root = FXMLLoader.load(getClass().getResource("/resources/login.fxml"));

			Scene scene = new Scene(root);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setTitle("Welcome Page");

			primaryStage.setScene(scene);

			//primaryStage.setFullScreen(true);

			primaryStage.show();

			} catch(Exception e) {

			e.printStackTrace();

			}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
