import java.awt.*;

public class Clouds {
public int cloudWidth;
public int cloudHeight;
public int cloudXpos;
public int cloudYpos;
public int cloudDx;
public int cloudDy;
public Rectangle cloudbox;

public Clouds(int Cxpos, int Cypos){
    cloudWidth = 130;
    cloudHeight = 109;
    cloudDx = 2;
    cloudDy = 1;
    cloudXpos = Cxpos;
    cloudYpos = Cypos;
    Rectangle cloudbox = new Rectangle(cloudXpos,cloudYpos,cloudWidth,cloudHeight);
}
    public void move() {
        if(cloudYpos>700){//wrap when hitting the bottom wall
            cloudDy = -cloudDy;
        }
        if(cloudYpos<0){//wrap when hitting the top
            cloudDy = -cloudDy;
        }
        if(cloudXpos>1000){
            cloudDx = -cloudDx;
        }
        if(cloudXpos<0){
            cloudDx = -cloudDx;
        }
        cloudXpos = cloudXpos + cloudDx;
        cloudYpos = cloudYpos + cloudDy;
        Rectangle cloudbox = new Rectangle(cloudXpos,cloudYpos,cloudWidth,cloudHeight);
    }
}
