package pkg.models;

import pkg.game.OverworldHandler;
import pkg.view.SpriteSheet;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class AmmoCrate extends GameObject {


    private final BufferedImage ammoCrate_image;

    /**
     * Argumented constructor for AmmoCrate
     *
     * @param int x, int y, ID id, Handler handler, Spritesheet ss
     */
    public AmmoCrate(int x, int y, OverworldHandler overworldHandler, SpriteSheet ss) {
        super(x, y, overworldHandler, ss);
        ammoCrate_image = ss.grabImage(6, 2, 32, 32);
    }

    /**
     * Tick() method is called to update/animate the game. Each execution of tick represents a new frame in the game.
     * Thus, it is an essential method for all GameObjects.
     */
    @Override
    public void tick() {
    }

    /**
     * Render() is called to draw objects into our game.
     *
     * @param Graphics g
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(ammoCrate_image, x, y, null);
    }

    /**
     * getBounds() represents the actual space an object takes up.
     * It is used for object collision to tell us when objects intersect each other.
     *
     * @return new Rectangle (x position, y position, width, height);
     */
    @Override
    public Rectangle getBounds() {

        return new Rectangle(x, y, 32, 32);
    }

    //We can use the methods below to specify multiple differential bounds for our GameObjects.
    //However, for the demonstrative purposes of this template, this functionality is only used by our Player and Enemy objects.
    @Override
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
     * Unused animation method inherited from GameObject superclass
     *
     * @param Graphics object g
     */
    @Override
    public void animation(Graphics g) {
    }
}
