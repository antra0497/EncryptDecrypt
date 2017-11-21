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
import java.util.*;

import java.io.*;

public class demoone
{
	GridPane gridPane = new GridPane();
	BorderPane bp=new BorderPane();
	String srcStr,desStr;
	
	public demoone(Stage stage)
	{
		Text Qq = new Text("Select the file position and type of Encrypt/Decrypt");
		Qq.setFont(Font.font("New Times Roman",FontWeight.BOLD,20));
		
		gridPane.setAlignment(Pos.CENTER);
	
		TextField src = new TextField();
		TextField des = new TextField();
		
		Label l1=new Label();
		Label l2=new Label();
			
		src.setPromptText("--source--");
		des.setPromptText("--destination--");
		
		Button srcBt = new Button("Browse");
		Button desBt = new Button("Browse");
		
		srcBt.setOnAction(event->{
			FileChooser fileChooser = new FileChooser();
			File selectedFile = fileChooser.showOpenDialog(stage);
			if(selectedFile!=null)
			{
				src.setText(selectedFile.getAbsolutePath());
			}
		});
		
		desBt.setOnAction(event->{
			DirectoryChooser dirChooser = new DirectoryChooser();
			
			File selectedFile = dirChooser.showDialog(stage);
			if(selectedFile!=null)
			{
				des.setText(selectedFile.getAbsolutePath());
			}
		});
		
				
		Button encrypt = new Button("Encrypt");
		Button decrypt = new Button("Decrypt");
		
		
		
		encrypt.setOnAction(event->{
						
			srcStr = src.getText();
		        desStr = des.getText();			
			encryptImage ei=new encryptImage();
						
			ei.executeEncryption(srcStr, desStr);
			
			l1.setText("Image Encrypted!!");
			gridPane.add(l1,0,3);
			
			l2.setText("Do You Want To Decrypt the Image?? ");
			gridPane.add(l2,0,4);
			gridPane.add(decrypt,1,4);
			
									 		
		});
		
		decrypt.setOnAction(event->{
		
			encryptImage ei=new encryptImage();
						
			ei.decrypt(desStr,desStr);
			l1.setText("Image Decrypted!!");
			l2.setText("Chech your destination image");
						
		});
		
		//borderPane.setAlignment(Pos.CENTER);
		bp.setTop(Qq);	
				
		gridPane.add(src,0,0);
		gridPane.add(srcBt,1,0);
				
		gridPane.add(des,0,1);
		gridPane.add(desBt,1,1);
		
		gridPane.add(encrypt,0,2);
	
	}
}
