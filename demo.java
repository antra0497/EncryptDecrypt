import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
/**
* This class is for main class of the project
* It generate the first GUI window of the project
* This class is written in Javafx
*/


public class demo extends Application
{

	BorderPane borderPane = new BorderPane ();

	public void start (Stage primaryStage)
	
	{	/**
		* Creating Object of Text Type and setting its properties
		*/
		Text Q = new Text("Select file type..");
		Q.setFont(Font.font("New Times Roman",FontWeight.BOLD,20));
		
		/**
		* Creating Object of HBox Type
		*/		
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);	
			
		/**
		* Creating Object of Buttons
		*/		
		Button b1 = new Button("Image.img");
		Button b2 = new Button("Text.txt");
		
		/**
		* Functioning of the Image Button
		*/
		b1.setOnAction(event->{
			borderPane.setCenter(new demoone(primaryStage).gridPane);
		});
		
		/**
		* Functioning of the Text Button
		*/
		b2.setOnAction(event->{
			borderPane.setCenter(new demotwo(primaryStage).gridPane);
		});

		/**
		* Adding both the button on the HBox
		*/
		hbox.getChildren().addAll(b1,b2);
		
		/**
		* Setting Text and HBox on the Border Pane
		*/		
		borderPane.setTop(Q);
		borderPane.setCenter(hbox);
		
	        /**
		* Setting Background Color
		*/			
		borderPane.setStyle("-fx-background-color:#D7ECFD;");

		/**
		* Creating Scene object 
		*/
		Scene scene = new Scene (borderPane, 500, 500);    

		primaryStage.setScene (scene);
		primaryStage.show ();
	}
}
