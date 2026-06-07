import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Enemy
{
    int timeshit=6;
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Boss()
    {
        setRotation(90);
    }
    public void act()
    {
        moveEnemy();
        hitByProjectile();
    }
     public void hitByProjectile()
    {
        Actor projectile= getOneIntersectingObject(Projectile.class);
        if(projectile!=null)
        {
            getWorld().removeObject(projectile);
            timeshit--;
        }
        if(timeshit==0)
        {
            World world=getWorld();
            MyWorld myWorld=(MyWorld)world;
            Counter counter=myWorld.getCounter();
            counter.addScore();
            getWorld().removeObject(this);
        }
        else if(getY()==599)
        {
            World world=getWorld();
            MyWorld myWorld=(MyWorld)world;
            HealthBar healthbar=myWorld.getHealthBar();
            healthbar.loseHealth();
            healthbar.loseHealth();
            healthbar.loseHealth();
            healthbar.loseHealth();
            healthbar.loseHealth();
            healthbar.loseHealth();
            getWorld().removeObject(this);
        }
    }
    
}
