public class Elf extends Calliance{
    private final int elfRangedAP = Constants.elfRangedAP;

    public Elf(String name) {
        super(Constants.elfAP, 70, Constants.elfMaxMove, name,70);
    }

    public int getElfRangedAP() {
        return elfRangedAP;
    }
    @Override
    public String characterkind() {
        return "Elf";
    }

}
