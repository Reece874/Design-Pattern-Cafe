package model;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application{

	public static void main(String[] args) {
		Kitchen.getKitchen();
		MasterList.getList().displayList();
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/View.fxml"));
		Scene scene = new Scene(root); 
		stage.setScene(scene);
		stage.setTitle("Waiter");
		stage.show();
		
		//Create Kitchen Stage
		Stage newWindow = new Stage();
		newWindow.setTitle("Kitchen");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ChefView.fxml"));
		newWindow.setScene(new Scene(loader.load()));
		newWindow.show();
		
		//Create Host Stage
		Stage newWindow2 = new Stage();
		newWindow2.setTitle("Host");
		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/HostView.fxml"));
		newWindow2.setScene(new Scene(loader2.load()));
		newWindow2.show();
		
	}

}
