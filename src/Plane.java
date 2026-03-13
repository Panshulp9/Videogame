import java.awt.*;

public class Plane {
    public int Planexpos;
    public int Planeypos;
    public int DX;
    public int DY;
    public Rectangle planebox;


    public Plane(int XPOS, int YPOS){
        Planexpos = XPOS;
        Planeypos = YPOS;
        DX = 2;
        DY = 1;
        Rectangle planebox = new Rectangle(Planexpos,Planeypos,70,30);
    }
    public void move() {
       Planexpos = Planexpos + DX;
        Planeypos = Planeypos + DY;
        Rectangle planebox = new Rectangle(Planexpos,Planeypos,70,30);

    }
}
