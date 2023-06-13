/**
 * Cette classe est le controller du fichier fxml SisMapView qui est notre page principal
 *
 * @version 1.0
 *
 * @see com.sae201g3b.SisMapApplication
 * @author Enzo HOURLAY
 */
package com.sae201g3b;

import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.controlsfx.control.RangeSlider;

import java.io.IOException;
import java.util.ArrayList;

public class SisMapController extends SisApplicationModel{
    @FXML
    private BorderPane borderPane;
    @FXML
    private MapView france;
    @FXML
    private TableView tableau;
    @FXML
    private RadioMenuItem menuCarte,menuTab;
    @FXML
    private TableColumn<Seisme,String> colonneId,colonneLatitude,colonneLongitude,colonneIntensite,colonneDate,colonneHeure,colonneNom,colonneRegion,colonneChoc,colonneQualite;
    private ArrayList<MapLayer> mapLayerArrayList = new ArrayList<>();
    private final MapPoint francePoint = new MapPoint(46.227638, 2.213749);
    private final MapPoint francePoint2 = new MapPoint(46.227600, 2.213700);

    @FXML
    private TextField id,region,de,jusqua;
    @FXML
    private RangeSlider intensite;

    public void initialize(){
        /* Ligne nécessaire pour empêcher de l'erreur sur la map Gluon */
        System.setProperty("javafx.platform", "desktop");
        System.setProperty("http.agent", "Gluon Mobile/1.0.3");

        /* Initialisation de la map sur la France */
        france.setZoom(6);
        france.flyTo(0,francePoint,0.1);
        //france.setDisable(true);

        /* Initialisation de la TableView qui affiche les données des séismes */
        colonneId.setCellValueFactory(new PropertyValueFactory<>("Identifiant"));
        colonneLatitude.setCellValueFactory(new PropertyValueFactory<>("Latitude"));
        colonneLongitude.setCellValueFactory(new PropertyValueFactory<>("Longitude"));
        colonneIntensite.setCellValueFactory(new PropertyValueFactory<>("Intensite"));
        colonneDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        colonneHeure.setCellValueFactory(new PropertyValueFactory<>("Heure"));
        colonneNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colonneRegion.setCellValueFactory(new PropertyValueFactory<>("Region"));
        colonneChoc.setCellValueFactory(new PropertyValueFactory<>("Choc"));
        colonneQualite.setCellValueFactory(new PropertyValueFactory<>("Qualite"));

        //ObservableList<Seisme> listeSeisme = FXCollections.observableArrayList(CSV.getData());
        //tableau.setItems(listeSeisme);
        tableau.itemsProperty().bind(super.getCSV().dataFiltrerProperty());

        afficheSeismeCarte();
    }

    public void changeCenter(ActionEvent event){
        if(event.getSource()==menuCarte){
            borderPane.setCenter(france);
            afficheSeismeCarte();
        } else if (event.getSource()==menuTab){
            borderPane.setCenter(tableau);
        }
    }

    public void afficheSeismeCarte(){
        for(Seisme seisme: super.getCSV().getDataFiltrer()){
            try {
                MapLayer layer = new SeismePoint(new MapPoint(Float.parseFloat(seisme.getLatitude()),
                                                            Float.parseFloat(seisme.getLongitude())),
                                                Float.parseFloat(seisme.getIntensite()));
                mapLayerArrayList.add(layer);
                france.addLayer(layer);
            } catch (IllegalArgumentException e){
                System.out.println("Lat,Lon ou Intensité est null");
            }
        }
        france.setCenter(francePoint2);
        france.flyTo(0.1,francePoint,0.1);
    }

    public void resetPoint(){
        for(MapLayer layer : mapLayerArrayList){
            france.removeLayer(layer);
        }
        mapLayerArrayList = new ArrayList<>();
        super.getCSV().setDataFiltrer((ObservableList<Seisme>) super.getCSV().getData());
    }

    @FXML
    public void resetFiltreControlleur(){
        super.resetFiltreControlleur();
        resetPoint();
        afficheSeismeCarte();
    }

    @FXML
    public void appliquerChangement(){
        super.setId(id);
        super.setRegion(region);
        super.setDe(de);
        super.setJusqua(jusqua);
        super.setIntensite(intensite);
        super.appliquerChangement();
        resetPoint();

        afficheSeismeCarte();
    }
    @FXML
    public void changerFXML() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DashboardView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            Stage stage = (Stage) borderPane.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 }
