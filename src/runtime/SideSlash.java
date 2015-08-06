package runtime;

import levels.DemoLevel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class SideSlash extends StateBasedGame{

    private static final String GAME_NAME = "Side Slash";
    public static final int DEMO_LEVEL = 0;

    public SideSlash(String name){
        super(name);
        addState(new DemoLevel(DEMO_LEVEL));
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException{
        //initialize levels here
        getState(DEMO_LEVEL).init(gc, this);
        enterState(DEMO_LEVEL);
    }

    public static void main(String[] args){
        try{
            AppGameContainer app = new AppGameContainer(new SideSlash(GAME_NAME));
            app.setDisplayMode(1280, 720, false);
            app.setVSync(true);
            app.setTargetFrameRate(60);
            app.setShowFPS(false);
            app.start();
        }catch(SlickException e){
            e.printStackTrace();
        }
    }
}
