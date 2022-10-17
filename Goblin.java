public class Goblin extends Zorde{

    public Goblin(String name) {
        super(Constants.goblinAP, 80, Constants.goblinMaxMove ,name,80);
    }

    @Override
    public String characterkind() { return "Goblin"; }

}
