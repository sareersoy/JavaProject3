public class Dwarf extends Calliance{

    public Dwarf(String name) {
        super(Constants.dwarfAP, 120, Constants.dwarfMaxMove, name, 120);
    }

    @Override
    public String characterkind() { return "Dwarf"; }
}
