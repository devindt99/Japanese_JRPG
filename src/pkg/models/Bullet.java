package pkg.models;

import pkg.game.OverworldHandler;
import pkg.view.SpriteSheet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author Zack (RealTutsGML), Devin
 */
public class Bullet extends GameObject {


    /**
     * Argumented constructor
     *
     * @param x
     * @param y
     * @param overworldHandler
     * @param mx
     * @param my
     * @param ss
     */
    public Bullet(int x, int y, OverworldHandler overworldHandler, int mx, int my, SpriteSheet ss) {
        super(x, y, overworldHandler, ss);

        int speed = 10;

        double bulletAngle = Math.toDegrees(Math.atan2(my - y, mx - x));
        velX = (float) (Math.cos(Math.toRadians(bulletAngle)) * speed);
        velY = (float) (Math.sin(Math.toRadians(bulletAngle)) * speed);

    }

    /**
     * Tick() method is called to update/animate the game. Each execution of tick represents a new frame in the game.
     * Thus, it is an essential method for all GameObjects.
     */
    public void tick() {
        x += velX;
        y += velY;

        handleCollisions();
    }

    private void handleCollisions() {
        for (GameObject tempObject : overworldHandler.getObjects()) {

            if (tempObject instanceof Block) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    overworldHandler.removeObject(this);
                }
            }

        }
    }

    /**
     * Render() is called to draw objects into our game.
     *
     * @param Graphics g
     */
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y, 8, 8);
    }

    //We can use the methods below to specify multiple differential bounds for our GameObjects.
    //However, for the demonstrative purposes of this template, this functionality is only used by our Player and Enemy objects.
    public Rectangle getTopBounds() {

        return null;
    }


    @Override
    public Rectangle getBotBounds() {

        return null;
    }


    @Override
    public Rectangle getLeftBounds() {

        return null;
    }


    @Override
    public Rectangle getRightBounds() {

        return null;
    }

    /**
     * getBounds() represents the actual space an object takes up.
     * It is used for object collision to tell us when objects intersect each other.
     *
     * @return new Rectangle (x position, y position, width, height);
     */
    @Override
    public Rectangle getBounds() {

        return new Rectangle(x, y, 8, 8);
    }

    /**
     * Unused animation method inherited from GameObject superclass
     *
     * @param Graphics object g
     */
    @Override
    public void animation(Graphics g) {
    }

}
