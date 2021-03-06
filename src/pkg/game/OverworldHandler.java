package pkg.game;

import pkg.models.GameObject;

import java.awt.Graphics;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Zack (RealTutsGML)
 */
// Handler class holds, updates, and renders game objects
public class OverworldHandler implements Handler {

    private Queue<GameObject> objects = new LinkedBlockingQueue<>();


    private boolean up;
    private boolean down;
    private boolean right;
    private boolean left;

    // GameObjects all stored together in ArrayList
    public Queue<GameObject> getObjects() {
        return objects;
    }

    public void setObjects(Queue<GameObject> objects) {
        this.objects = objects;
    }

    // simple methods/setters used with key inputs to control movement in-game
    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * Tick() method is called to update/animate the game. Each execution of tick represents a new frame in the game.
     * Thus, it is an essential method for all elements of our game that must be updated.
     */
    public void tick() {
        for (GameObject tempObject : objects) {

            tempObject.tick();
        }


    }

    /**
     * Render() is called to draw objects into our game.
     *
     * @param g
     */
    public void render(Graphics g) {
        for (GameObject tempObject : objects) {
            tempObject.render(g);
        }
    }

    public void addObject(GameObject other) {
        objects.add(other);
    }

    public void removeObject(GameObject other) {
        objects.remove(other);
    }
}
