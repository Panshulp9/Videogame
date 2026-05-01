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
        isAlive = false;
        mdy = (int)(Math.random()*7)-7;
        mxpos = MXPOS;
        mypos = MYPOS;
        mHeight = 60;
        mWidth = 90;
            hitbox = new Rectangle(mxpos,mypos,mWidth,mHeight);

    }
    public void move() {
        if(mypos > 700){ //wrap when hitting the bottom wall
            mypos = 1;
        }
        if(mypos < 0){ //wrap when hitting the top
            mypos = 699;
        }
        if(mxpos > 1000){
            mxpos = 1;
        }
        if(mxpos < 0){
            mxpos = 999;
        }
        mxpos = mxpos + mdx;
        mypos = mypos + mdy;
        hitbox = new Rectangle(mxpos,mypos,mWidth,mHeight);


    }
}
