package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//Create the time entry fields
			Label t1H = new Label("Time #1:  Hour ");
			t1H.setStyle("-fx-text-fill: #0F0");
			TextField t1Hour = new TextField();
			Label t1M = new Label(": min ");
			t1M.setStyle("-fx-text-fill: #0F0");
			TextField t1Min = new TextField();
			Label t1S = new Label(": sec ");
			t1S.setStyle("-fx-text-fill: #0F0");
			TextField t1Sec = new TextField();
			Label t1Ms = new Label(". ms ");
			t1Ms.setStyle("-fx-text-fill: #0F0");
			TextField t1Msec = new TextField();
			
			Label t2H = new Label("Time #2: Hour ");
			t2H.setStyle("-fx-text-fill: #0F0");
			TextField t2Hour = new TextField();
			Label t2M = new Label(": min ");
			t2M.setStyle("-fx-text-fill: #0F0");
			TextField t2Min = new TextField();
			Label t2S = new Label(": sec ");
			t2S.setStyle("-fx-text-fill: #0F0");
			TextField t2Sec = new TextField();
			Label t2Ms = new Label(". ms ");
			t2Ms.setStyle("-fx-text-fill: #0F0");
			TextField t2Msec = new TextField();
			
			//Select addition or subtraction
			RadioButton add = new RadioButton("Add");
			add.setStyle("-fx-text-fill: #0F0");
			RadioButton sub = new RadioButton("Subtract");
			sub.setStyle("-fx-text-fill: #0F0");
			
			ToggleGroup tg = new ToggleGroup();
			add.setToggleGroup(tg);
			sub.setToggleGroup(tg);
			
			//Button to process calculation
			Button calculate = new Button("Calculate Time");
			
			//Button to clear boxes
			Button clear = new Button ("Clear Times");
			
			//Button to copy result
			Button copyResult = new Button ("Copy");
			
			//Textfied to return result
			TextField result = new TextField("0:00:00.000");
			
			//Layout
			
			GridPane gridPane = new GridPane();
			
			gridPane.setMinSize(200,200);
			
			gridPane.setPadding(new Insets(10, 10, 10, 10));
			
			gridPane.setVgap(5);
			
			gridPane.setHgap(5);
			
			gridPane.setAlignment(Pos.CENTER);
			
			gridPane.add(t1H, 0, 0);
			gridPane.add(t1Hour, 1, 0);
			gridPane.add(t1M, 2, 0);
			gridPane.add(t1Min, 3, 0);
			gridPane.add(t1S, 4, 0);
			gridPane.add(t1Sec, 5, 0);
			gridPane.add(t1Ms, 6, 0);
			gridPane.add(t1Msec, 7, 0);

			gridPane.add(t2H, 0, 1);
			gridPane.add(t2Hour, 1, 1);
			gridPane.add(t2M, 2, 1);
			gridPane.add(t2Min, 3, 1);
			gridPane.add(t2S, 4, 1);
			gridPane.add(t2Sec, 5, 1);
			gridPane.add(t2Ms, 6, 1);
			gridPane.add(t2Msec, 7, 1);
			
			gridPane.add(add, 0, 2);
			gridPane.add(sub, 1, 2);
			
			gridPane.add(calculate, 0, 3);
			gridPane.add(result, 1, 3);
			gridPane.add(copyResult, 2, 3);
			gridPane.add(clear, 3, 3);
			
			//Stage
			primaryStage.setTitle("Timing Calculator");
			
			//Scene
			Scene scene = new Scene(gridPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			//Button action Calculate
			calculate.setOnAction(e -> {
				int t1h = (t1Hour.getLength() != 0) ? Integer.parseInt(t1Hour.getText()) : 0;
				int t1m = (t1Min.getLength() != 0) ? Integer.parseInt(t1Min.getText()) : 0;
				int t1s = (t1Sec.getLength() != 0) ? Integer.parseInt(t1Sec.getText()) : 0;
				int t1ms = (t1Msec.getLength() != 0) ? Integer.parseInt(t1Msec.getText()) : 0;
				int t2h = (t2Hour.getLength() != 0) ? Integer.parseInt(t2Hour.getText()) : 0;
				int t2m = (t2Min.getLength() != 0) ? Integer.parseInt(t2Min.getText()) : 0;
				int t2s = (t2Sec.getLength() != 0) ? Integer.parseInt(t2Sec.getText()) : 0;
				int t2ms = (t2Msec.getLength() != 0) ? Integer.parseInt(t2Msec.getText()) : 0;
				
				if(add.isSelected()) {
					result.setText(TimeConversion.addTimes(t1h, t1m, t1s, t1ms, t2h, t2m, t2s, t2ms));
				}
				else if (sub.isSelected()) {
					result.setText(TimeConversion.subTimes(t1h, t1m, t1s, t1ms, t2h, t2m, t2s, t2ms));
				}	
			});
			
			//Button Action Clear
			clear.setOnAction(e -> {
				t1Hour.clear();
				t1Min.clear();
				t1Sec.clear();
				t1Msec.clear();
				t2Hour.clear();
				t2Min.clear();
				t2Sec.clear();
				t2Msec.clear();
				result.clear();
				t1Hour.requestFocus();
			});
			
			//Button copyResult
			copyResult.setOnAction(e -> {
				Clipboard clipboard = Clipboard.getSystemClipboard();
				ClipboardContent content = new ClipboardContent();
				content.putString((result.getLength() != 0)? result.getText() : "0:00:00.000");
				clipboard.setContent(content);
			});
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
