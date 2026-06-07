import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Actor
{
    int speed=2;
    /**
     * Act - do whatever the Enemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
         moveAround();
    }
    public void moveAround()
    {
        setLocation(getX(),getY()+speed);
        if(isTouching(Walls.class))
        {
            speed=-speed;
        }
    }
}
