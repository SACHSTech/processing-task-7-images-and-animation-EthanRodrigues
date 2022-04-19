import processing.core.PApplet;
import processing.core.PImage;

  /** 
   * This program draws three moving objects: a circle, a spaceship and an asteroid. The spaceship never leaves the screen, the asteroid moves non-linearly and the circle moves linearly, on an angle.
   * Author: Ethan Rodrigues 
   */

public class Sketch extends PApplet {
	// set variables spaceship
	PImage imgSpaceship;
  float fltSpaceshipX = 200;
  float fltSpaceshipY = 200;
  float fltSpaceshipXSpeed = 1;
  float fltSpaceshipYSpeed = 1;

  // set background
  PImage imgSpace;

  // set variables for asteroid
  PImage imgAsteroid;
  float fltAsteroidX = -50;
  float fltAsteroidY = 200;
  float fltAsteroidXSpeed = 1;
  float fltAsteroidYSpeed = 20;

  // set variables for circle
  float fltCircleX = 0;
  float fltCircleY = 400;
  float fltCircleXSpeed = 1;
  float fltCircleYSpeed = 1;
  
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0);
    imgSpaceship = loadImage("XWing.png");
    imgSpaceship.resize(imgSpaceship.width / 8 , imgSpaceship.height / 8);
    
    imgSpace = loadImage("space.jpg");

    imgAsteroid = loadImage("Asteroid.png");
    imgAsteroid.resize(imgAsteroid.width / 4, imgAsteroid.height / 4);
  }

  public void draw() {
   image(imgSpace, 0, 0);

   // draw and animate spaceship 
	 image(imgSpaceship, fltSpaceshipX, fltSpaceshipY);
   fltSpaceshipX +=fltSpaceshipXSpeed;
   fltSpaceshipY +=fltSpaceshipYSpeed;
   // if statements to prevent spaceship from exiting the screen area
   if (fltSpaceshipX < 0 || fltSpaceshipX > width - imgSpaceship.width){
     fltSpaceshipXSpeed *= -1;
   }
   if (fltSpaceshipY < 0 || fltSpaceshipY > height - imgSpaceship.height){
     fltSpaceshipYSpeed *= -1;
   }

   // draw and animate circle
   ellipse(fltCircleX, fltCircleY, 20, 20); 
   fltCircleX +=fltCircleXSpeed;
   fltCircleY -=fltCircleYSpeed;
    
   // draw and animate Asteroid with a non linear motion
   image(imgAsteroid, fltAsteroidX, fltAsteroidY);
   fltAsteroidX +=(fltAsteroidXSpeed);
   fltAsteroidY += 10 * (Math.sin(fltAsteroidX) * 0.5 );    
  }
  
}