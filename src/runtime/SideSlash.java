package runtime;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class SideSlash extends StateBasedGame{

    private static final String GAME_NAME = "Side Slash";

    public SideSlash(String name){
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException{
        //Add Levels here
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
