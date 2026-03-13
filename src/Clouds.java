public class Clouds {
public int cloudWidth;
public int cloudHeight;
public int cloudXpos;
public int cloudYpos;
public int cloudDx;
public int cloudDy;

public Clouds(int Cxpos, int Cypos){
    cloudWidth = 130;
    cloudHeight = 109;
    cloudDx = 2;
    cloudDy = 1;
    cloudXpos = Cxpos;
    cloudYpos = Cypos;

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
    }
}
