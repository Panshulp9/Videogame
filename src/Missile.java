import java.awt.*;

public class Missile {
    public int mdx;
    public int mdy;
    public int mxpos;
    public int mypos;
    public Rectangle hitbox;
    public boolean isAlive;
    public int mWidth;
    public int mHeight;


    public Missile(int MXPOS, int MYPOS){
        mdx = (int)(Math.random()*7)-7;
        isAlive = true;
        mdy = (int)(Math.random()*7)-7;
        mxpos = MXPOS;
        mypos = MYPOS;
        mHeight = 60;
        mWidth = 90;
        if (isAlive == true){
            hitbox = new Rectangle(mxpos,mypos,mWidth,mHeight);
        }

    }
    public void move() {
        if(mypos>700){//wrap when hitting the bottom wall
            mdy = -mdy;
        }
        if(mypos<0){//wrap when hitting the top
            mdy = -mdy;
        }
        if(mxpos>1000){
            mdx = -mdx;
        }
        if(mxpos<0){
            mdx = -mdx;
        }
        mxpos = mxpos + mdx;
        mypos = mypos + mdy;
        if (isAlive == true){
            hitbox = new Rectangle(mxpos,mypos,mWidth,mHeight);
        }

    }
}
