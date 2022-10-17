public class Ork extends Zorde{

    private final int orkHealPoints = Constants.orkHealPoints;
    public Ork(String name) {
        super(Constants.orkAP, 200, Constants.orkMaxMove, name,200);
    }
    public int getOrkHealPoints() {
        return orkHealPoints;
    }

    @Override
    public String characterkind() { return "Ork"; }
}
