public class Calliance extends Character{

    public Calliance(int AP, int HP, int maxMove, String name,int initialHP) {
        super(AP, HP, maxMove, name, initialHP);
    }

    @Override
    public String kind() {
        return "Calliance";
    }
}

