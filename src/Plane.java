import java.awt.*;

public class Plane {
    public int Planexpos;
    public int Planeypos;
    public int DX;
    public int DY;
    public Rectangle planebox;
    public boolean isFlying;


    public Plane(int XPOS, int YPOS) {
        Planexpos = XPOS;
        Planeypos = YPOS;
        DX = 2;
        DY = 1;
        isFlying = true;
        planebox = new Rectangle(Planexpos,Planeypos,100,45);
    }
    public void move() {
        planebox = new Rectangle(Planexpos,Planeypos,100,45);

    }
}
