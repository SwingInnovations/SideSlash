package levels;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class DemoLevel extends BasicGameState{
    private int m_id = 0;

    public DemoLevel(int id){
        m_id = id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta){

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g){

    }

    public int getID(){
        return m_id;
    }
}
