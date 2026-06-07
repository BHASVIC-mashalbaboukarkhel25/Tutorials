import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse extends Actor
{
    int speed=3;
    int collect=0;
    /**
     * Act - do whatever the Mouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Mouse()
    {
        getImage().scale(getImage().getWidth()/2,getImage().getHeight()/2);
    }
    public void act()
    {
       MoveAround();
       hitFood();
       hitTeleporter();
       hitEnemy();
       YouLose();
       youWin();
    }
    public void MoveAround()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-speed,getY());
            if(hitWall()==true)
            {
                setLocation(getX()+speed,getY());
            }
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+speed,getY());
            if(hitWall()==true)
            {
                setLocation(getX()-speed,getY());
            }
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-speed);
            if(hitWall()==true)
            {
                setLocation(getX(),getY()+speed);
            }
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+speed);
            if(hitWall()==true)
            {
                setLocation(getX(),getY()-speed);
            }
        }
    }
    public boolean hitWall()
    {
        if (isTouching(Walls.class))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void hitFood()
    {
        if(getOneIntersectingObject(Cheese.class)!=null)
        {
            getWorld().removeObject(getOneIntersectingObject(Cheese.class));
            speed++;
            collect++;
        }
    }
    public void hitTeleporter()
    {
        if(isTouching(Teleporter.class))
        {
            setLocation(24,613);
        }
    }
    public boolean hitEnemy()
    {
        if (isTouching(Enemy.class)||isTouching(Enemy2.class))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void YouLose()
    {
        if(hitEnemy())
        {
            getWorld().addObject(new YouLose(),350,350);
            Greenfoot.stop();
        }
    }
    public void youWin()
    {
        if(isTouching(WinningPlatform.class)&& collect==5)
        {
            getWorld().addObject(new YouWin(),350,350);
            Greenfoot.stop();
        }
    }
}
