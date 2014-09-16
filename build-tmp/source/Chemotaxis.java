import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {


 Bacteria [] colony;
 public void setup()   
 {    
 	frameRate(20); 
 	size(700,700);
 	colony = new Bacteria[500];
 	for (int i=0; i<colony.length; i++)
 	{
 		colony[i] = new Bacteria(250,250);
 	}
 }   
 public void draw()   
 {    
 	background(100);
 	for (int i=0; i<colony.length; i++)
 	{
 	colony[i].show();
 	colony[i].move();
 	}
 	textAlign(CENTER,CENTER);
 	textSize(15);
 	fill(0,255,0,50);
 	ellipse(mouseX, mouseY, 50,50);
 	fill(0);
 	text("FOOD",mouseX, mouseY);
 }  
 class Bacteria    
 {
 	int myX, myY, col,scal;
 	Bacteria(int x,int y)
 	{
 		myX=x;
 		myY=y;
 		col = color(0,255,255);
 		scal = (int)(Math.random()*11);

 	}
 	public void move()
 	{
 		if (myX<mouseX)
 		{
 			myX = myX + ((int)(Math.random()*5)-1)*scal;
 		}
 		if (myX>mouseX)
 		{
 			myX = myX + ((int)(Math.random()*5)-3)*scal;
 		}
 		if (myY>mouseY)
 		{
 			myY = myY + ((int)(Math.random()*5)-3)*scal;
 		}
 		if (myY<mouseY)
 		{
 			myY = myY + ((int)(Math.random()*5)-1)*scal;
 		}
 		if (myY==mouseY)
 		{
 			myY = myY + ((int)(Math.random()*21)-10)*scal;
 		}
 		if (myX==mouseX)
 		{
 			myX = myX + ((int)(Math.random()*21)-10)*scal;
 		}
 	}
 	public void show()
 	{
 		fill(col,20);
 		stroke(col,100);
 		ellipse(myX, myY, scal, scal);

 	}
 }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
