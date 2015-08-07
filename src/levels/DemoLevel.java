package levels;

import engine.PlayerEntity;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class DemoLevel extends BasicGameState{
    private int m_id = 0;
    private PlayerEntity m_testPlayer;

    public DemoLevel(int id){
        m_id = id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        m_testPlayer = new PlayerEntity(new Vector2f(20, 620), new Vector2f(32, 64));
        m_testPlayer.initFoot(new Vector2f(32, 10));
        m_testPlayer.setDebugMode(true);
        m_testPlayer.setColor(Color.yellow);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta){
        m_testPlayer.update(gc, delta);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
        m_testPlayer.draw(g);
    }

    public int getID(){
        return m_id;
    }
}
