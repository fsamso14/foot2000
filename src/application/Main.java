package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * 
	 * VARIABLES STATIC (type logo, titre etc...).
	 * ========================================================================
	 * ========================================================================
	 */

	private final static String LOGO = "images/Logo.png";
	private final static String MENU = "Menu.fxml";
	private final static String TITRE = "Foot 2000";
	private final static String CSS = "application.css";

	/**
	 * 
	 * Méthode start
	 * ========================================================================
	 * ========================================================================
	 */

	@Override
	public void start(Stage primaryStage) {
		try {
			// ========================================================================
			// On charge le menu principal, sous format fxml
			// ========================================================================
			Parent root = FXMLLoader.load(getClass().getResource(MENU));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(
					getClass().getResource(CSS).toExternalForm());

			// ========================================================================
			// Changement du titre, ajout d'un logo et empechement de resize la
			// fenetre.
			// ========================================================================
			primaryStage.setTitle(TITRE);
			primaryStage.getIcons().add(new Image(LOGO));
			primaryStage.setResizable(false);

			// ========================================================================
			// Affichage de la scene.
			// ========================================================================
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Méthode start
	 * ========================================================================
	 * ========================================================================
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
