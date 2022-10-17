public class Human extends Calliance{

    public Human(String name) {
        super(Constants.humanAP, 100, Constants.humanMaxMove, name,100);
    }

    @Override
    public String characterkind() {
        return "Human";
    }
}
