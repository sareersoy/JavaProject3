public class Troll extends Zorde{

    public Troll(String name) {
        super(Constants.trollAP, 150, Constants.trollMaxMove,name,150);
    }

    @Override
    public String characterkind() {
        return "Troll";
    }
}
