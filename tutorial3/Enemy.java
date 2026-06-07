import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
         moveEnemy();
    }
    public void moveEnemy()
    {
        setLocation(getX(),getY()+3);
    }
    public void removeEnemy()
    {
        if(getY()==599)
        {
            getWorld().removeObject(this);
        }
    }
}
