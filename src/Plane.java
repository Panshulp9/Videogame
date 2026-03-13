public class Plane {
    public int Planexpos;
    public int Planeypos;
    public int DX;
    public int DY;

    public Plane(int XPOS, int YPOS){
        Planexpos = XPOS;
        Planeypos = YPOS;
        DX = 2;
        DY = 1;
    }
    public void move() {
       Planexpos = Planexpos + DX;
        Planeypos = Planeypos + DY;

    }
}
