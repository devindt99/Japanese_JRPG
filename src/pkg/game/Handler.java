package pkg.game;

import pkg.models.GameObject;

import java.awt.*;
import java.util.Queue;

public interface Handler {

    Queue<GameObject> getObjects();
    void tick();
    void render(Graphics g);
    void addObject(GameObject other);
    void removeObject(GameObject other);

}
