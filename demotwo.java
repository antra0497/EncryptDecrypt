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

import java.io.*;

public class demotwo
{
	Integer shift=new Integer(0);
	
	GridPane gridPane = new GridPane();
	public demotwo(Stage stage)
	{
		
		gridPane.setAlignment(Pos.CENTER);
	
		TextField src = new TextField();
		TextField des = new TextField();
		TextField key = new TextField();
		
		Label label=new Label();
				
		src.setPromptText("--source--");
		des.setPromptText("--destination--");
		
		ComboBox<String> choice= new ComboBox<>();
		choice .setValue("--select--");
		choice.getItems().addAll("ceaserCipher","vigereneCipher","transPositionCipher");
		
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
			FileChooser fileChooser = new FileChooser();
			File selectedFile = fileChooser.showSaveDialog(stage);
			if(selectedFile!=null)
			{
				des.setText(selectedFile.getAbsolutePath());
			}
		});
		
		Button encrypt = new Button("Encrypt");
		Button decrypt = new Button("Decrypt");
		
		encrypt.setOnAction(e->{
			String srcSt = src.getText();
			String desSt = des.getText();
			
			if(choice.getValue().toString().equals("ceaserCipher"))
			{
				int shift = Integer.parseInt(key.getText());
				new caesarCipher().writeEncryptionToFile(srcSt, desSt, shift);
				label.setText("CeaserCipher Encryption Process Completed");
				gridPane.add(label,0,5);
				
			}
			
			if(choice.getValue().toString().equals("vigereneCipher"))
			{
				String keySt = key.getText();
				new vigenereCipher().writeEncryptionToFile(srcSt, desSt, keySt);
				label.setText("Vigerene Cipher Encryption Process Completed");
				gridPane.add(label,0,5);
			}
			
			if(choice.getValue().toString().equals("transPositionCipher"))
			{
				String k2 = key.getText();
				new transPosition().writeEncryptionToFile(srcSt, desSt, k2);
				label.setText("Transposition Encryption Process Completed");
				gridPane.add(label,0,5);
			}	
		});
		
		
		decrypt.setOnAction(e->{
			String srcSt = src.getText();
			String desSt = des.getText();
			
			if(choice.getValue().toString().equals("ceaserCipher"))
			{
				int shift = Integer.parseInt(key.getText());
				new caesarCipher().writeDecryptionToFile(srcSt, desSt, shift);
				label.setText("Ceaser Cipher Decryption Process Completed");
				gridPane.add(label,0,5);
			}
			
			if(choice.getValue().toString().equals("vigereneCipher"))
			{
				String keySt = key.getText();
				new vigenereCipher().writeDecryptionToFile(srcSt, desSt, keySt);
				label.setText(" Vigerene Cipher Decryption Process Completed");
				gridPane.add(label,0,5);
			}
			
			if(choice.getValue().toString().equals("transPositionCipher"))
			{
				String k2 = key.getText();
				label.setText("Process Can Not Be Completed");
				gridPane.add(label,0,5);
				
			}
		});
				
		gridPane.add(src,0,0);
		gridPane.add(srcBt,1,0);
		
		
		gridPane.add(des,0,1);
		gridPane.add(desBt,1,1);
		
		gridPane.add(choice,0,2);
		
		gridPane.add(key,0,3);
		
		gridPane.add(encrypt,0,4);
		gridPane.add(decrypt,1,4);
	}
}
