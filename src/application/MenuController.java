package application;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import Excel.CollecteurArbitres;
import Excel.CollecteurCategorieArbitre;
import Excel.CollecteurClubs;
import Excel.CollecteurDisponibilitesArbitre;
import Excel.CollecteurGroupements;
import Excel.CollecteurMatchs;
import Excel.Createur;
import foot2000.Modele;

public class MenuController implements Initializable {

	/**
	 * 
	 * VARIABLES STATIC (type logo, titre etc...).
	 * ========================================================================
	 * ========================================================================
	 */
	private static final String DOCUMENTS = "documents/";
	private static final String NOTICE = "NOTICE.pdf";
	private static final String EMBLEME = "images/Embleme.jpg";
	private static final double TEMPS_CALCUL = 35.0;

	/**
	 * 
	 * VARIABLES FXML (type button etc...).
	 * ========================================================================
	 * ========================================================================
	 */

	@FXML
	private Button fileSelectMatchs;
	@FXML
	private ImageView imageView;
	@FXML
	private TextField labelMatchs;
	@FXML
	private TextField labelClubs;
	@FXML
	private Button entrer;
	@FXML
	private TextField labelGroupements;
	@FXML
	private Button fileSelectGroupements;
	@FXML
	private TextField labelIndispo;
	@FXML
	private Button fileSelectClubs;
	@FXML
	private TextField labelArbitre;
	@FXML
	private Button reinitialiser;
	@FXML
	private Button fileSelectIndispo;
	@FXML
	private AnchorPane pane;
	@FXML
	private Button fileSelectArbitres;
	@FXML
	private Button notice;
	@FXML
	private ProgressIndicator progressBar;

	/**
	 * 
	 * VARIABLES AUTRES (type Fichier etc...).
	 * ========================================================================
	 * ========================================================================
	 */

	Stage stage;
	File fichierArbitres;
	File fichierMatchs;
	File fichierGroupements;
	File fichierClubs;
	File fichierIndispo;

	String output;

	/**
	 * 
	 * 
	 * 
	 * SELECTION DES FICHIERS
	 * ========================================================================
	 * ========================================================================
	 * 
	 * 
	 */
	public FileChooser filechooser() {

		FileChooser fileChooser = new FileChooser();

		// L'application n'accepte que les formats .xls
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XLS files (*.xls)", "*.xls");
		fileChooser.getExtensionFilters().add(extFilter);
		fileChooser.setTitle("Veuillez selectionner votre fichier");
		return fileChooser;
	}

	/**
	 * 
	 * 
	 * 
	 * SELECTION FICHIER ARBITRE
	 * ========================================================================
	 * ========================================================================
	 * 
	 * 
	 */
	@FXML
	void fileSelectArbitres() {
		FileChooser fileChooser = filechooser();
		fichierArbitres = fileChooser.showOpenDialog(new Stage());
		if (fichierArbitres != null) {
			labelArbitre.setVisible(true);
			labelArbitre.setText(fichierArbitres.getAbsolutePath());

		}
	}

	/**
	 * 
	 * 
	 * 
	 * SELECTION FICHIER MATCHS
	 * ========================================================================
	 * ========================================================================
	 * 
	 * 
	 */
	@FXML
	void fileSelectMatchs() {
		FileChooser fileChooser = filechooser();

		fichierMatchs = fileChooser.showOpenDialog(new Stage());
		if (fichierMatchs != null) {
			labelMatchs.setVisible(true);
			labelMatchs.setText(fichierMatchs.getAbsolutePath());
		}
	}

	/**
	 * 
	 * 
	 * 
	 * SELECTION FICHIER GROUPEMENTS
	 * ========================================================================
	 * ========================================================================
	 * 
	 * 
	 */
	@FXML
	void fileSelectGroupements() {
		FileChooser fileChooser = filechooser();
		fichierGroupements = fileChooser.showOpenDialog(new Stage());
		if (fichierGroupements != null) {
			labelGroupements.setVisible(true);
			labelGroupements.setText(fichierGroupements.getAbsolutePath());

		}
	}

	/**
	 * 
	 * 
	 * 
	 * SELECTION FICHIER GROUPEMENTS
	 * ========================================================================
	 * ========================================================================
	 * 
	 * 
	 */
	@FXML
	void fileSelectClubs() {
		FileChooser fileChooser = filechooser();
		fichierClubs = fileChooser.showOpenDialog(new Stage());
		if (fichierClubs != null) {
			labelClubs.setVisible(true);
			labelClubs.setText(fichierClubs.getAbsolutePath());

		}
	}

	/**
	 * 
	 * 
	 * 
	 * SELECTION FICHIER GROUPEMENTS
	 * ========================================================================
	 * ========================================================================
	 * 
	 * 
	 */
	@FXML
	void fileSelectIndispo() {
		FileChooser fileChooser = filechooser();
		fichierIndispo = fileChooser.showOpenDialog(new Stage());
		if (fichierIndispo != null) {
			labelIndispo.setVisible(true);
			labelIndispo.setText(fichierIndispo.getAbsolutePath());

		}
	}

	/**
	 * 
	 * 
	 * OUVRIR NOTICE et REINITIALISER
	 * ========================================================================
	 * ========================================================================
	 * 
	 * 
	 * 
	 */
	@FXML
	void openNotice() {

		InputStream pdfInJar = getClass().getClassLoader().getResourceAsStream(
				DOCUMENTS + NOTICE);
		try {
			File pdf = new File(NOTICE);
			FileOutputStream fos = new java.io.FileOutputStream(pdf);
			while (pdfInJar.available() > 0) {
				fos.write(pdfInJar.read());
			}
			fos.close();
			Desktop.getDesktop().open(pdf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * ENTRER
	 * ========================================================================
	 * ========================================================================
	 * 
	 * @throws Exception
	 * 
	 * 
	 * 
	 */

	@FXML
	void handleEntrer() {
		try {
			setCollecteur();
			progression();

			Thread t = new Thread(new Runnable() {
				public void run() {
					try {
						Modele mod = foot2000.Main.run();

						Platform.runLater(new Runnable() {
							public void run() {
								FileChooser filechooser = filechooser();
								output = filechooser
										.showSaveDialog(new Stage())
										.getAbsolutePath();
								if (output != null) {
									File f = new File(output);
									Createur.adresseFichier = output;
									try {
										if (f != null) {
											f.createNewFile();
											Createur cr=new Createur(Createur.adresseFichier,
													mod.getRepresentation());
											try {
												cr.ecritureFichierExcel();
											} catch (RowsExceededException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (BiffException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (WriteException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											} catch (IndexOutOfBoundsException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}

										}

									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							}
						});
					} catch (Exception e) {
						alert();
					}
				}
			});
			t.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void alert() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				progressBar.setVisible(false);
				// TODO Auto-generated method stub
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("XLS invalide.");
				alert.setHeaderText("L'un des documents est invalide.");
				alert.setContentText("Veuillez consulter la notice, et fournir les documents sous le format demandé.");
				alert.show();
			}
		});

	}

	void progression() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				progressBar.setVisible(true);

				IntegerProperty seconds = new SimpleIntegerProperty();
				progressBar.progressProperty().bind(
						seconds.divide(TEMPS_CALCUL));
				Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,
						new KeyValue(seconds, 0)), new KeyFrame(Duration
						.minutes(TEMPS_CALCUL / 60.0), e -> {

					progressBar.setVisible(false);

				}, new KeyValue(seconds, TEMPS_CALCUL)));

				timeline.play();
			}
		});

	}

	void setCollecteur() {
		CollecteurArbitres.adresseFichier = labelArbitre.getText();
		CollecteurCategorieArbitre.adresseFichier = labelArbitre.getText();
		CollecteurClubs.adresseFichier = labelClubs.getText();
		CollecteurDisponibilitesArbitre.adresseFichier = labelIndispo.getText();
		CollecteurMatchs.adresseFichier = labelMatchs.getText();
		CollecteurGroupements.adresseFichier = labelGroupements.getText();
	}

	/**
	 * 
	 * 
	 * REINITIALISER
	 * ========================================================================
	 * ========================================================================
	 * 
	 * 
	 * 
	 */

	@FXML
	public void reinitialize() {
		fichierArbitres = null;
		fichierMatchs = null;
		fichierClubs = null;
		fichierGroupements = null;
		fichierIndispo = null;

		labelArbitre.setText("");
		labelClubs.setText("");
		labelGroupements.setText("");
		labelIndispo.setText("");
		labelMatchs.setText("");

		labelArbitre.setVisible(false);
		labelGroupements.setVisible(false);
		labelIndispo.setVisible(false);
		labelClubs.setVisible(false);
		labelMatchs.setVisible(false);

	}

	/**
	 * 
	 * 
	 * INITIALISER
	 * ========================================================================
	 * ========================================================================
	 * 
	 * 
	 * 
	 */

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageView.setImage(new Image(EMBLEME));

		progressBar.setVisible(false);

		labelArbitre.setDisable(true);
		labelClubs.setDisable(true);
		labelGroupements.setDisable(true);
		labelIndispo.setDisable(true);
		labelMatchs.setDisable(true);
	}
}
