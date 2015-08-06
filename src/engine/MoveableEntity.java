package engine;

import org.newdawn.slick.geom.Vector2f;

public class MoveableEntity extends BasicEntity{
    public static int LEFT = 0;
    public static int RIGHT = 1;
    private static int LANE_LIMIT = 5;
    private int m_lane;
    private int m_direction;
    private int m_health;

    public MoveableEntity(){
        super();
    }

    public MoveableEntity(Vector2f pos, Vector2f dim){
        super(pos, dim);
    }

    public void setDirection(int dir){
        m_direction = dir;
    }

    public void setHealth(int h){
        m_health = h;
    }

    public void setLane(int lane){ m_lane = lane; }

    public void increaseLane(){
        if(m_lane > LANE_LIMIT){
            m_lane = LANE_LIMIT;
        }else{
            m_lane++;
        }
    }

    public void decreaseLane(){
        if(m_lane < 1){
            m_lane = 0;
        }else{
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
}
