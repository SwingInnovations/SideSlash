package engine;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class PlayerEntity extends MoveableEntity{

    private int PLAYER_LEFT = -1;
    private int PLAYER_RIGHT = -1;
    private int PLAYER_JUMP = -1;
    private int PLAYER_BLOCK = -1;
    private int PLAYER_WEAPON_CYCLE = -1;
    private int PLAYER_WEAPON_1 = -1;
    private int PLAYER_WEAPON_2 = -1;
    private int PLAYER_FIRE = -1;
    private int PLAYER_SHIFT_DOWN = -1;
    private int PLAYER_SHIFT_UP = -1;
    private final float X_SPEED = 0.25f;
    private boolean m_isOnGround;

    public PlayerEntity(){
        super();
    }

    public PlayerEntity(Vector2f pos, Vector2f dim){
        super(pos, dim);
        setPLAYER_LEFT(Input.KEY_A);
        setPLAYER_RIGHT(Input.KEY_D);
        setPLAYER_SHIFT_DOWN(Input.KEY_S);
        setPLAYER_SHIFT_UP(Input.KEY_W);
        setPLAYER_BLOCK(Input.KEY_Q);
        setPLAYER_FIRE(Input.KEY_E);
        setPLAYER_JUMP(Input.KEY_SPACE);
        setPLAYER_WEAPON_CYCLE(Input.KEY_APOSTROPHE);
        setPLAYER_WEAPON_1(Input.KEY_1);
        setPLAYER_WEAPON_2(Input.KEY_2);
    }

    private void jump(int delta){
        if(m_isOnGround){

        }else{

        }
    }

    public void update(GameContainer gc, int delta){
        Input input = gc.getInput();
        if(input.isKeyPressed(PLAYER_JUMP)){
            //jump

        }else if(input.isKeyPressed(PLAYER_FIRE)){
            //fire
        }else if(input.isKeyPressed(PLAYER_WEAPON_CYCLE)){
            //cycle through weapons
        }else if(input.isKeyPressed(PLAYER_WEAPON_1)){
            //Goto weapon 1
        }else if(input.isKeyPressed(PLAYER_WEAPON_2)){
            //GOTO weapon 2
        }else if(input.isKeyPressed(PLAYER_SHIFT_DOWN)){
            //Shift down
            decreaseLane();
        }else if(input.isKeyPressed(PLAYER_SHIFT_UP)) {
            //Shift up
            increaseLane();
        }
        if(input.isKeyDown(PLAYER_LEFT)){
            //Move Left
            float _x = super.getPosition().getX();
            if(_x < 0){
                _x = 0;
            }else {
                _x -= X_SPEED * (float) delta;
            }
            super.setPosX(_x);
        }else if(input.isKeyDown(PLAYER_RIGHT)){
            float _x = super.getPosition().getX();
            _x += X_SPEED * (float)delta;
            super.setPosX(_x);
            //Move Right
        }else if(input.isKeyDown(PLAYER_BLOCK)){

            //Block
        }
    }

    public int getPLAYER_LEFT() {
        return PLAYER_LEFT;
    }

    public void setPLAYER_LEFT(int PLAYER_LEFT) {
        this.PLAYER_LEFT = PLAYER_LEFT;
    }

    public int getPLAYER_RIGHT() {
        return PLAYER_RIGHT;
    }
    public void setPLAYER_RIGHT
(int PLAYER_RIGHT) {
        this.PLAYER_RIGHT = PLAYER_RIGHT;
    }

    public int getPLAYER_JUMP() {
        return PLAYER_JUMP;
    }

    public void setPLAYER_JUMP(int PLAYER_JUMP) {
        this.PLAYER_JUMP = PLAYER_JUMP;
    }

    public int getPLAYER_BLOCK() {
        return PLAYER_BLOCK;
    }

    public void setPLAYER_BLOCK(int PLAYER_BLOCK) {
        this.PLAYER_BLOCK = PLAYER_BLOCK;
    }

    public int getPLAYER_WEAPON_CYCLE() {
        return PLAYER_WEAPON_CYCLE;
    }

    public void setPLAYER_WEAPON_CYCLE(int PLAYER_WEAPON_CYCLE) {
        this.PLAYER_WEAPON_CYCLE = PLAYER_WEAPON_CYCLE;
    }

    public int getPLAYER_WEAPON_1() {
        return PLAYER_WEAPON_1;
    }

    public void setPLAYER_WEAPON_1(int PLAYER_WEAPON_1) {
        this.PLAYER_WEAPON_1 = PLAYER_WEAPON_1;
    }

    public int getPLAYER_WEAPON_2() {
        return PLAYER_WEAPON_2;
    }

    public void setPLAYER_WEAPON_2(int PLAYER_WEAPON_2) {
        this.PLAYER_WEAPON_2 = PLAYER_WEAPON_2;
    }

    public int getPLAYER_FIRE() {
        return PLAYER_FIRE;
    }

    public void setPLAYER_FIRE(int PLAYER_FIRE) {
        this.PLAYER_FIRE = PLAYER_FIRE;
    }

    public int getPLAYER_SHIFT_DOWN() {
        return PLAYER_SHIFT_DOWN;
    }

    public void setPLAYER_SHIFT_DOWN(int PLAYER_SHIFT_DOWN) {
        this.PLAYER_SHIFT_DOWN = PLAYER_SHIFT_DOWN;
    }

    public int getPLAYER_SHIFT_UP() {
        return PLAYER_SHIFT_UP;
    }

    public void setPLAYER_SHIFT_UP(int PLAYER_SHIFT_UP) {
        this.PLAYER_SHIFT_UP = PLAYER_SHIFT_UP;
    }
}
