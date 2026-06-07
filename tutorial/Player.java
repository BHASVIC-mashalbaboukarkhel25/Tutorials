import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int speed=2;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
        hitEnemy();
        youWin();
    }
    public void moveAround()
    {
        move(speed);
        if(Greenfoot.isKeyDown("right"))
        {
            turn(4);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-4);
        }
        if(Greenfoot.isKeyDown("space"))
        {
            speed=speed+2;
        }
        else
        {
            speed=1;
        }
    }
    public void hitEnemy()
    {
        if(isTouching(Enemy.class))
        {
            getWorld().addObject(new YouLose(),400,300);
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
    public void youWin()
    {
        if(getY()==599)
        {
            getWorld().addObject(new YouWin(),400,300);
            Greenfoot.stop();
        }
    }
}
