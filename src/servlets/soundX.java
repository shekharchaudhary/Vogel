package servlets;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class soundX extends JFrame {

   public soundX() {
      

      try {
         // Open an audio input stream.
    	 URL url = this.getClass().getClassLoader().getResource("cello.wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         
         for (int i =1;i<500;i++)
         
         
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   
   public static void main(String[]args){
	   new soundX();
   }
}

   