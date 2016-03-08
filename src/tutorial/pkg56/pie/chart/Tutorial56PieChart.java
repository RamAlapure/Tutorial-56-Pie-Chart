/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.pkg56.pie.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Ram
 */
public class Tutorial56PieChart extends Application {
    private final ObservableList<PieChart.Data> details = FXCollections.observableArrayList();
    private BorderPane root;
    private PieChart pieChart;
    private Label label;
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("JavaFX 8 Tutorial 58 - Pie Chart and Mouse Event Handler");
        details.addAll(new PieChart.Data("Printing Cost", 20),
                new PieChart.Data("Paper Cost", 25),
                new PieChart.Data("Binding Cost", 30),
                new PieChart.Data("Promotion Cost", 10),
                new PieChart.Data("Transportation Cost", 10),
                new PieChart.Data("Royalty Cost", 15)
            );
        
        root = new BorderPane();
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        
        pieChart = new PieChart();
        pieChart.setData(details);
        pieChart.setTitle("Various Expenditures (in %) Incurred In Publishing A Book");
        //pieChart.setLegendSide(Side.BOTTOM);
        //pieChart.setLabelsVisible(true);
        //pieChart.setClockwise(false);
        //pieChart.setStartAngle(90);
        root.setCenter(pieChart);
        
        label = new Label();
        label.setFont(Font.font("SanSerif", FontWeight.BOLD, 15));
        
        pieChart.getData()
                .stream()
                .forEach(data ->{
                    data.getNode().addEventHandler(MouseEvent.ANY, e->{
                        label.setText(data.getName() + " Expenditures: " + (int)data.getPieValue() +
                                "%\n" + "Central Angle: " + (int)((data.getPieValue()/100)*360) +
                                "degree");
                    });
                });
        root.setBottom(label);
        BorderPane.setMargin(label, new Insets(0, 0, 10, 120));
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
