//Basic Game Application
//Version 2
// Basic Object, Image, Movement

// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable, KeyListener, MouseListener {

   //Variable Definition Section
   //Declare the variables used in the program 
   //You can set their initial values too
   
   //Sets the width and height of the program window
	final int WIDTH = 1000;
	final int HEIGHT = 700;

   //Declare the variables needed for the graphics
	public JFrame frame;
	public Canvas canvas;
   public JPanel panel;
   
	public BufferStrategy bufferStrategy;
    public Image cloudPic;
    public Image missile;
    public Clouds[] clouds;
    public Image skyBack;
    int Cxpos = (int)(Math.random()*900);
    int Cypos = (int)(Math.random()*600);
    public Image Planes;
    public Rectangle pointHitbox;
    public boolean gameOn;
    public Image end;


   //Declare the objects used in the program
   //These are things that are made up of more than one variable type
    private Plane plane;
    private Missile missiles;


   // Main method definition
   // This is the code that runs first and automatically
	public static void main(String[] args) {
		BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
		new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method  
	}


   // Constructor Method
   // This has the same name as the class
   // This section is the setup portion of the program
   // Initialize your variables and construct your program objects here.
	public BasicGameApp() {
      
      setUpGraphics();
       
      //variable and objects
      //create (construct) the objects needed for the game and load up
        gameOn = true;
        end = Toolkit.getDefaultToolkit().getImage("crash.jpg");
        skyBack = Toolkit.getDefaultToolkit().getImage("SKYVG.jpeg");
        Planes = Toolkit.getDefaultToolkit().getImage("350.png");
        plane = new Plane(Cxpos, Cypos);
        cloudPic = Toolkit.getDefaultToolkit().getImage("CLOUD.png"); //clouds
        clouds = new Clouds[13];
        missile = Toolkit.getDefaultToolkit().getImage("Missile.png");
        missiles = new Missile((int)(Math.random()*900),(int)(Math.random()*659));
        for (int x = 0; x < clouds.length; x++){
            clouds[x] = new Clouds(Cxpos, Cypos);
            clouds[x].cloudDx = (int)(Math.random()*5)-5;
            clouds[x].cloudDy = (int)(Math.random()*5)-5;
        }

	}// BasicGameApp()

   
//*******************************************************************************
//User Method Section
//
// put your code to do things here.

   // main thread
   // this is the code that plays the game after you set things up
	public void run() {

      //for the moment we will loop things forever.
		while (true) {

         moveThings();  //move all the game objects
         render();  // paint the graphics
         pause(20); // sleep for 10 ms
		}
	}


	public void moveThings()
	{
      //calls the move( ) code in the objects
        for (int i = 0; i < clouds.length; i++){
            clouds[i].move();
        }
        missiles.move();

	}

    public void crashing(){
        if (plane.planebox.intersects(missiles.hitbox)){
            gameOn = false;
        }
    }
	
   //Pauses or sleeps the computer for the amount specified in milliseconds
   public void pause(int time ){
   		//sleep
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {

			}
   }

   //Graphics setup method
   private void setUpGraphics() {
      frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.
   
      panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
      panel.setLayout(null);   //set the layout
   
      // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
      // and trap input events (Mouse and Keyboard events)
      canvas = new Canvas();  
      canvas.setBounds(0, 0, WIDTH, HEIGHT);
      canvas.setIgnoreRepaint(true);
      canvas.addKeyListener(this);
      canvas.addMouseListener(this);
   
      panel.add(canvas);  // adds the canvas to the panel.
   
      // frame operations
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
      frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
      frame.setResizable(false);   //makes it so the frame cannot be resized
      frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!
      
      // sets up things so the screen displays images nicely.
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      canvas.requestFocus();
      System.out.println("DONE graphic setup");
   
   }


	//paints things on the screen using bufferStrategy
	private void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);

      //draw the image of the astronaut
        g.drawImage(skyBack, 0, 0, 1000, 700, null);
        g.drawImage(cloudPic, 790, 120, 100, 80, null);
       if (missiles.isAlive == true) {
           g.drawImage(missile, missiles.mxpos, missiles.mypos, 200, 160, null);
       }
        for (int y = 0; y < clouds.length; y++){
            g.drawImage(cloudPic, clouds[y].cloudXpos, clouds[y].cloudYpos, clouds[y].cloudWidth, clouds[y].cloudHeight, null);
        }
        g.drawImage(Planes, plane.Planexpos, plane.Planeypos, 70, 30, null);
        if (gameOn = false){
            g.drawImage(end, 0, 0, 1000, 700, null);
        }





		g.dispose();

		bufferStrategy.show();
	}


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 38){
            System.out.println("going up");
            plane.Planeypos = plane.Planeypos-10;
        }
        if (e.getKeyCode() == 37){
            System.out.println("going left");
            plane.Planexpos = plane.Planexpos-5;
        }
        if (e.getKeyCode() == 39){
            System.out.println("going right");
            plane.Planexpos = plane.Planexpos+5;
        }
        if(e.getKeyCode() == 40){
            System.out.println("going down");
            plane.Planeypos = plane.Planeypos+ 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        pointHitbox = new Rectangle(e.getX(),e.getY(),1,1);
        if (missiles.hitbox.intersects(pointHitbox)){
            missiles.isAlive = false;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}