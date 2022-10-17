public class Character {
    private final int AP;
    private int HP;
    private final int MaxMove;
    private String name;
    private int x;
    private int y;
    private final int InitialHP;
    private String stuation = "alive";

    public void setStuation(String stuation) {
        this.stuation = stuation;
    }

    public String getStuation() {
        return stuation;
    }

    public Character(int AP, int HP, int maxMove, String name, int initialHP) {
        this.AP = AP;
        this.HP = HP;
        MaxMove = maxMove;
        this.name = name;
        InitialHP = initialHP;
    }

    public int getAP() {
        return AP;
    }

    public int getInitialHP() {
        return InitialHP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        if(HP>0 && HP < this.getInitialHP()){


        this.HP = HP;}
        else if(HP <=0){
            this.setStuation("Dead");
            this.HP = 0;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return this.name;
    }
    public String kind(){return "Character"; } //default
    public String characterkind(){ return "";} //default

    }

