public class Zorde extends Character{

    public Zorde(int AP, int HP, int maxMove, String name, int initialHP) {
        super(AP, HP, maxMove, name, initialHP);

    }

    @Override
    public String kind() { return "Zorde"; }
}
