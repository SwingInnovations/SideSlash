package engine;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.geom.Shape;

public interface Entity {
    //Position
    void setPosition(Vector2f pos);
    void setPosX(float _x);
    void setPosY(float _y);

    void setDimension(Vector2f dim);
    void setWidth(float _w);
    void setHeight(float _h);

    Shape getBounds();
    boolean intersects(Entity other);

    void draw(Graphics g);
}
