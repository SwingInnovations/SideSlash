package engine;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Color;

public class BasicEntity implements Entity{
    private Vector2f m_Pos;
    private Vector2f m_Dim;
    private Rectangle m_bounds;
    private boolean m_debugMode;
    private SpriteSheet m_spriteSheet;
    private Image m_masterImage;
    private float m_time;
    private float m_timeSinceLastChange;
    private int m_Row;
    private int m_currentFrame;
    private int m_totalFrameCount;
    private Color m_Color;

    public BasicEntity(){
        m_Pos = new Vector2f(0, 0);
        m_Dim = new Vector2f(0, 0);
        initBounds();
        m_debugMode = false;
    }

    public BasicEntity(Vector2f pos, Vector2f dim){
        m_Pos = pos;
        m_Dim = dim;
        initBounds();
        m_debugMode = false;
    }

    @Override
    public void setPosition(Vector2f pos){
        m_Pos = pos;
    }
    @Override
    public void setPosX(float _x){
        m_Pos.x = _x;
        m_bounds.setX(_x);
    }

    public void setPosY(float _y){
        m_Pos.y = _y;
        m_bounds.setY(_y);
    }

    public Vector2f getPosition(){ return m_Pos; }

    @Override
    public void setDimension(Vector2f dim){
        m_Dim = dim;
    }

    public void setWidth(float _w){
        m_Dim.x = _w;
    }

    public void setHeight(float _h){
        m_Dim.y = _h;
    }

    public void setColor(Color col){ m_Color = col; }

    public Vector2f getDimension(){ return m_Dim; }

    public void setRow(int row){
        m_Row = row;
    }

    public void setCurrentFrame(int curFrame){
        m_currentFrame = curFrame;
    }

    public void setTotalFrameCount(int tfcnt){
        m_totalFrameCount = tfcnt;
    }

    public int getRow() {
        return m_Row;
    }

    public int getCurrentFrame(){
        return m_currentFrame;
    }

    public int getM_totalFrameCount(){
        return m_totalFrameCount;
    }

    public Shape getBounds(){
        return (Shape)m_bounds;
    }

    public Color getColor(){ return m_Color; }

    public boolean intersects(Entity other){
        return m_bounds.intersects(other.getBounds());
    }

    public void updateSpriteSheet(int delta){
        m_time += (float)delta/1000.0;
        if(m_time > m_timeSinceLastChange + 0.1f){
            m_timeSinceLastChange = m_time;
            nextFrame();
        }
    }

    public void nextFrame(){
        m_currentFrame++;
        if(m_currentFrame > m_totalFrameCount - 1){
            m_currentFrame = 0;
        }
        m_masterImage = m_spriteSheet.getSprite(m_currentFrame, m_Row);
    }

    public void draw(Graphics g){
        if(is_debugMode()){
            g.setColor(m_Color);
            g.draw(m_bounds);
        }
        if(m_masterImage != null) g.drawImage(m_masterImage, m_Pos.getX(), m_Pos.getY());
    }

    private void initBounds(){
        m_bounds = new Rectangle(m_Pos.getX(), m_Pos.getY(), m_Dim.getX(), m_Dim.getY());
    }

    public boolean is_debugMode() {
        return m_debugMode;
    }

    public void setDebugMode(boolean m_debugMode) {
        this.m_debugMode = m_debugMode;
    }

    public SpriteSheet getSpriteSheet() {
        return m_spriteSheet;
    }

    public void setM_spriteSheet(SpriteSheet m_spriteSheet) throws SlickException {
        this.m_spriteSheet = m_spriteSheet;
    }

    public Image getMasterImage() {
        return m_masterImage;
    }

    public void setMasterImage(Image m_masterImage) throws SlickException{
        this.m_masterImage = m_masterImage;
    }
}
