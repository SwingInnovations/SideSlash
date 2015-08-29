package engine;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

import java.util.Vector;

public class MoveableEntity extends BasicEntity{
    public static int LEFT = 0;
    public static int RIGHT = 1;
    private static int LANE_LIMIT = 5;
    private final int[] m_LaneDist = new int[LANE_LIMIT];
    private boolean changingLanes;
    private int m_lane;
    private int m_direction;
    private int m_health;
    private Rectangle m_Foot;
    public enum v_DirType{
        UP,
        DOWN,
        STAY
    }

    v_DirType m_dirType;

    public boolean inRange(int num, int range){
        return (num >= -range || num <= range);
    }

    public boolean inRange(float num, float range){
        return (num >= -range || num <= range);
    }

    public MoveableEntity(){
        super();
        initLaneDistances();
        changingLanes = false;
        m_dirType = v_DirType.STAY;
    }

    public MoveableEntity(Vector2f pos, Vector2f dim){
        super(pos, dim);
        initLaneDistances();
        changingLanes = false;
        m_dirType = v_DirType.STAY;
    }

    private void initLaneDistances(){
        m_LaneDist[0] = 480;
        m_LaneDist[1] = 512;
        m_LaneDist[2] = 596;
        m_LaneDist[3] = 628;
        m_LaneDist[4] = 700;
    }

    public void initFoot(Vector2f dim){
        Vector2f pos = new Vector2f(super.getPosition().x, super.getPosition().getY() - dim.y);
        m_Foot = new Rectangle(pos.x, pos.y, dim.x, dim.y);
    }

    public void setDirection(int dir){
        m_direction = dir;
    }

    public void setHealth(int h){
        m_health = h;
    }

    public void setLane(int lane){ m_lane = lane; }

    public void setLanesChanging(boolean v){
        changingLanes = v;
    }

    public void increaseLane(){
        if(m_lane > LANE_LIMIT){
            m_lane = LANE_LIMIT;
        }else{
            setLanesChanging(true);
            m_dirType = v_DirType.UP;
            m_lane++;
        }
    }

    public int[] getLanesList(){
        return m_LaneDist;
    }

    public int getLaneDist(int index){
        if(index < m_LaneDist.length && index > -1){
            return m_LaneDist[index];
        }else{
            return -1;
        }
    }

    public void decreaseLane(){
        if(m_lane < 1){
            m_lane = 0;
        }else{
            setLanesChanging(true);
            m_dirType = v_DirType.DOWN;
            m_lane--;
        }
    }

    public int getLane(){
        return m_lane;
    }

    public int getDirection(){
        return m_direction;
    }

    public boolean intersects(MoveableEntity other){
        if(m_lane == other.getLane()){
            if (super.intersects(other)) return true;
            else return false;
        }
        return false;
    }

    public int getHealth() {
        return m_health;
    }

    public Rectangle getFootBounds(){
        return m_Foot;
    }

    public boolean isLaneChanging(){
        return changingLanes;
    }

    public v_DirType getDirType(){
        return m_dirType;
    }

}
