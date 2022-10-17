
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static int a=0;
    public static ArithmeticException BoundaryException = new ArithmeticException();
    public static IllegalArgumentException MoveCountException = new IllegalArgumentException();
    public static int b=0;
    public static int count=0;
    public static Character Temp = new Character(1, 1, 0, "  ",1); //defult board empty character
    public static Character DoubleStar = new Character(1, 1, 0, "**",1); //defult board adges character
    public static Character SingleStar = new Character(1, 1, 0, "*",1); //defult board adges character
    public static void PrintBoard(int a, Character[][] board,FileWriter writer) throws IOException {
        for (int i = 0; i < a + 2; i++) {
            for (int j = 0; j < a + 2; j++) {
                if (board[i][j].getStuation().equals("dead") || board[i][j].getHP()<=0 ) {
                    board[i][j] = Temp;
                }
                writer.write(String.valueOf(board[i][j]));
            }
            writer.write("\n"); }
    Text(writer);
    }



    //These Go methods checks some conditions.
    //If the target square has Empty character, the character that is moving can go to this square
    // If the target square has friendly character, the character that is moving stops
    // If the target square has enemy character, they fight to death.
    public static void GoUpward(Character ch, Character[][] board,FileWriter writer) throws Exception {
    int y2 = ch.getY();
    int x2 = ch.getX();
    if (y2>=2){
    if((board[y2-1][x2].kind().equals("Zorde") && board[y2][x2].kind().equals("Calliance"))||(board[y2-1][x2].kind().equals("Calliance") && board[y2][x2].kind().equals("Zorde"))){
                board[y2-1][x2]=FightToDeath(board[y2][x2],board[y2-1][x2],board,writer); }

    else if(board[y2-1][x2]==Temp){
            board[y2][x2]=Temp;
            board[y2-1][x2]=ch;
            ch.setY(y2-1);
        }
    else if((board[y2-1][x2].kind().equals("Zorde")) == (ch.kind().equals("Zorde"))){
        b=1; }
    else{
            throw BoundaryException;

        }}
    else{
        throw BoundaryException;
    }

    }
    public static void GoDownward(Character ch, Character[][] board,FileWriter writer) throws Exception {
        int y2 = ch.getY();
        int x2 = ch.getX();
        if (y2<=a-1){

            if((board[y2+1][x2].kind().equals("Zorde") && board[y2][x2].kind().equals("Calliance"))||(board[y2+1][x2].kind().equals("Calliance") && board[y2][x2].kind().equals("Zorde"))){
                board[y2+1][x2]=FightToDeath(board[y2][x2],board[y2+1][x2],board,writer);
            }
            else if(board[y2+1][x2]==Temp){
                board[y2][x2]=Temp;
                board[y2+1][x2]=ch;
                ch.setY(y2+1);
            }
            else if((board[y2+1][x2].kind().equals("Zorde")) == (ch.kind().equals("Zorde"))){
                b=1;
            }
            else{
                throw BoundaryException;
            }

        }
        else{
            throw BoundaryException;
        }
    }
    public static void GoLeftward(Character ch, Character[][] board,FileWriter writer) throws Exception {
        int y2 = ch.getY();
        int x2 = ch.getX();
        if (x2>=2){
                if((board[y2][x2-1].kind().equals("Zorde") && board[y2][x2].kind().equals("Calliance"))||(board[y2][x2-1].kind().equals("Calliance") && board[y2][x2].kind().equals("Zorde"))){
                    board[y2][x2-1]=FightToDeath(board[y2][x2],board[y2][x2-1],board,writer);
                }
                else if(board[y2][x2-1]==Temp ){
                    board[y2][x2]=Temp;
                    board[y2][x2-1]=ch;
                    ch.setX(x2-1);
                }
                else if((board[y2][x2-1].kind().equals("Zorde")) == (ch.kind().equals("Zorde"))){
                    b=1;
                }
                else{
                    throw BoundaryException;
                }
            }
        else{
            throw BoundaryException;
        }
    }
    public static void GoRightward(Character ch, Character[][] board,FileWriter writer) throws Exception {
        int y2 = ch.getY();
        int x2 = ch.getX();
        if (x2<=a-1){
                if((board[y2][x2+1].kind().equals("Zorde") && board[y2][x2].kind().equals("Calliance"))||(board[y2][x2+1].kind().equals("Calliance") && board[y2][x2].kind().equals("Zorde"))){
                    board[y2][x2+1]=FightToDeath(board[y2][x2],board[y2][x2+1],board,writer);
                }
                else if(board[y2][x2+1]==Temp ){
                    board[y2][x2]=Temp;
                    board[y2][x2+1]=ch;
                    ch.setX(x2+1);
                }
                else if((board[y2][x2+1].kind().equals("Zorde")) == (ch.kind().equals("Zorde"))){
                    b=1;
                }
                else{
                    throw BoundaryException;
                }
            }
        else{
            throw BoundaryException;
        }
    }
    public static void GoLeftUpCross(Character ch, Character[][] board,FileWriter writer) throws Exception {
        int y2 = ch.getY();
        int x2 = ch.getX();
        if (y2>=2 && x2>=2){
                 if((board[y2-1][x2-1].kind().equals("Zorde") && board[y2][x2].kind().equals("Calliance"))||(board[y2-1][x2-1].kind().equals("Calliance") && board[y2][x2].kind().equals("Zorde"))){
                    board[y2-1][x2-1]=FightToDeath(board[y2][x2],board[y2-1][x2-1],board,writer);
                }
                else if(board[y2-1][x2-1]==Temp){
                    board[y2][x2]=Temp;
                    board[y2-1][x2-1]=ch;
                    ch.setY(y2-1);
                    ch.setX(x2-1);
                }
                 else if((board[y2-1][x2-1].kind().equals("Zorde")) == (ch.kind().equals("Zorde"))){
                     b=1;
                 }
                 else{
                     throw BoundaryException;
                 }
            }
        else{
            throw BoundaryException;
        }}
    public static void GoRightUpCross(Character ch, Character[][] board,FileWriter writer) throws Exception {
        int y2 = ch.getY();
        int x2 = ch.getX();
        if (y2>=2 && x2<=a-1){
                if((board[y2-1][x2+1].kind().equals("Zorde") && board[y2][x2].kind().equals("Calliance"))||(board[y2-1][x2+1].kind().equals("Calliance") && board[y2][x2].kind().equals("Zorde"))){
                    board[y2-1][x2+1]=FightToDeath(board[y2][x2],board[y2-1][x2+1],board,writer);
                }
                else if(board[y2-1][x2+1]==Temp ){
                    board[y2][x2]=Temp;
                    board[y2-1][x2+1]=ch;
                    ch.setY(y2-1);
                    ch.setX(x2+1);
                }
                else if((board[y2-1][x2+1].kind().equals("Zorde")) == (ch.kind().equals("Zorde"))){
                    b=1;
                }
                else{
                    throw BoundaryException;
                }
            }
        else{
            throw BoundaryException;
        }}
    public static void GoLeftDownCross(Character ch, Character[][] board,FileWriter writer) throws Exception {
        int y2 = ch.getY();
        int x2 = ch.getX();
        if (y2<=a-1 && x2>=2){
                if((board[y2+1][x2-1].kind().equals("Zorde") && board[y2][x2].kind().equals("Calliance"))||(board[y2+1][x2-1].kind().equals("Calliance") && board[y2][x2].kind().equals("Zorde"))){
                    board[y2+1][x2-1]=FightToDeath(board[y2][x2],board[y2+1][x2-1],board,writer);
                }
                else if(board[y2+1][x2-1]==Temp ){
                    board[y2][x2]=Temp;
                    board[y2+1][x2-1]=ch;
                    ch.setY(y2+1);
                    ch.setX(x2-1);}
                else if((board[y2+1][x2-1].kind().equals("Zorde")) == (ch.kind().equals("Zorde"))){
                    b=1;
                }
                else{
                    throw BoundaryException;
                }
            }
        else{
            throw BoundaryException;
        }}
    public static void GoRightDownCross(Character ch, Character[][] board,FileWriter writer) throws Exception {
        int y2 = ch.getY();
        int x2 = ch.getX();
        if (y2<=a-1 && x2<=a-1){
                if((board[y2+1][x2+1].kind().equals("Zorde") && board[y2][x2].kind().equals("Calliance"))||(board[y2+1][x2+1].kind().equals("Calliance") && board[y2][x2].kind().equals("Zorde"))){
                    board[y2+1][x2+1]=FightToDeath(board[y2][x2],board[y2+1][x2+1],board,writer);
                }
                else if(board[y2+1][x2+1]==Temp ){
                    board[y2][x2]=Temp;
                    board[y2+1][x2+1]=ch;
                    ch.setY(y2+1);
                    ch.setX(x2+1);
                }
                else if((board[y2+1][x2+1].kind().equals("Zorde")) == (ch.kind().equals("Zorde"))){
                    b=1;
                }
                else{
                    throw BoundaryException;
                }
            }
        else{
            throw BoundaryException;
        }}


        //Text method writes the current HP values
    public static void Text(FileWriter writer) throws IOException {
        writer.write("\n");
        ArrayList<String> strings = new ArrayList<>();

        for(Character ch : CharacterArrayList){
            String a = "";
            if(((ch.kind().equals("Zorde"))||(ch.kind().equals("Calliance")))&&ch.getStuation().equals("alive")){
                a = ch.toString()+"\t"+ch.getHP()+"\t("+ch.getInitialHP()+")\n";
                strings.add(a); } }
                strings.sort(new TextSorter());
            for(String s:strings){
                writer.write(s);
            }


        writer.write("\n");
    }


    //This method for 3x3 square attacking
    public static void Attack(Character ch, Character[][] board){
        int x = ch.getX();
        int y = ch.getY();

        if(ch.characterkind().equals("Ork")){
            if(board[y+1][x].kind().equals("Calliance") && board[y+1][x].getStuation().equals("alive")){
                board[y+1][x].setHP(board[y+1][x].getHP()-Constants.orkAP); }
            if(board[y-1][x].kind().equals("Calliance") && board[y-1][x].getStuation().equals("alive")){
                board[y-1][x].setHP(board[y-1][x].getHP()-Constants.orkAP); }
            if(board[y][x+1].kind().equals("Calliance") && board[y][x+1].getStuation().equals("alive")){
                board[y][x+1].setHP(board[y][x+1].getHP()-Constants.orkAP);}
            if(board[y][x-1].kind().equals("Calliance") && board[y][x-1].getStuation().equals("alive")){
                board[y][x-1].setHP(board[y][x-1].getHP()-Constants.orkAP); }
            if(board[y+1][x+1].kind().equals("Calliance") && board[y+1][x+1].getStuation().equals("alive")){
                board[y+1][x+1].setHP(board[y+1][x+1].getHP()-Constants.orkAP); }
            if(board[y+1][x-1].kind().equals("Calliance") && board[y+1][x-1].getStuation().equals("alive")){
                board[y+1][x-1].setHP(board[y+1][x-1].getHP()-Constants.orkAP); }
            if(board[y-1][x+1].kind().equals("Calliance") && board[y-1][x+1].getStuation().equals("alive")){
                board[y-1][x+1].setHP(board[y-1][x+1].getHP()-Constants.orkAP); }
            if(board[y-1][x-1].kind().equals("Calliance") && board[y-1][x-1].getStuation().equals("alive")){
                board[y-1][x-1].setHP(board[y-1][x-1].getHP()-Constants.orkAP); }}
        else if(ch.characterkind().equals("Troll")){
            if(board[y+1][x].kind().equals("Calliance") && board[y+1][x].getStuation().equals("alive")){
            board[y+1][x].setHP(board[y+1][x].getHP()-Constants.trollAP); }
            if(board[y-1][x].kind().equals("Calliance") && board[y-1][x].getStuation().equals("alive")){
                board[y-1][x].setHP(board[y-1][x].getHP()-Constants.trollAP); }
            if(board[y][x+1].kind().equals("Calliance") && board[y][x+1].getStuation().equals("alive")){
                board[y][x+1].setHP(board[y][x+1].getHP()-Constants.trollAP);}
            if(board[y][x-1].kind().equals("Calliance") && board[y][x-1].getStuation().equals("alive")){
                board[y][x-1].setHP(board[y][x-1].getHP()-Constants.trollAP); }
            if(board[y+1][x+1].kind().equals("Calliance") && board[y+1][x+1].getStuation().equals("alive")){
                board[y+1][x+1].setHP(board[y+1][x+1].getHP()-Constants.trollAP); }
            if(board[y+1][x-1].kind().equals("Calliance") && board[y+1][x-1].getStuation().equals("alive")){
                board[y+1][x-1].setHP(board[y+1][x-1].getHP()-Constants.trollAP); }
            if(board[y-1][x+1].kind().equals("Calliance") && board[y-1][x+1].getStuation().equals("alive")){
                board[y-1][x+1].setHP(board[y-1][x+1].getHP()-Constants.trollAP); }
            if(board[y-1][x-1].kind().equals("Calliance") && board[y-1][x-1].getStuation().equals("alive")){
                board[y-1][x-1].setHP(board[y-1][x-1].getHP()-Constants.trollAP); }}

        else if(ch.characterkind().equals("Goblin")){
            if(board[y+1][x].kind().equals("Calliance") && board[y+1][x].getStuation().equals("alive")){
                board[y+1][x].setHP(board[y+1][x].getHP()-Constants.goblinAP); }
            if(board[y-1][x].kind().equals("Calliance") && board[y-1][x].getStuation().equals("alive")){
                board[y-1][x].setHP(board[y-1][x].getHP()-Constants.goblinAP); }
            if(board[y][x+1].kind().equals("Calliance") && board[y][x+1].getStuation().equals("alive")){
                board[y][x+1].setHP(board[y][x+1].getHP()-Constants.goblinAP);}
            if(board[y][x-1].kind().equals("Calliance") && board[y][x-1].getStuation().equals("alive")){
                board[y][x-1].setHP(board[y][x-1].getHP()-Constants.goblinAP); }
            if(board[y+1][x+1].kind().equals("Calliance") && board[y+1][x+1].getStuation().equals("alive")){
                board[y+1][x+1].setHP(board[y+1][x+1].getHP()-Constants.goblinAP); }
            if(board[y+1][x-1].kind().equals("Calliance") && board[y+1][x-1].getStuation().equals("alive")){
                board[y+1][x-1].setHP(board[y+1][x-1].getHP()-Constants.goblinAP); }
            if(board[y-1][x+1].kind().equals("Calliance") && board[y-1][x+1].getStuation().equals("alive")){
                board[y-1][x+1].setHP(board[y-1][x+1].getHP()-Constants.goblinAP); }
            if(board[y-1][x-1].kind().equals("Calliance") && board[y-1][x-1].getStuation().equals("alive")){
                board[y-1][x-1].setHP(board[y-1][x-1].getHP()-Constants.goblinAP); } }

        else if(ch.characterkind().equals("Human")){
            if(board[y+1][x].kind().equals("Zorde") && board[y+1][x].getStuation().equals("alive")){
                board[y+1][x].setHP(board[y+1][x].getHP()-Constants.humanAP); }
            if(board[y-1][x].kind().equals("Zorde") && board[y-1][x].getStuation().equals("alive")){
                board[y-1][x].setHP(board[y-1][x].getHP()-Constants.humanAP); }
            if(board[y][x+1].kind().equals("Zorde") && board[y][x+1].getStuation().equals("alive")){
                board[y][x+1].setHP(board[y][x+1].getHP()-Constants.humanAP);}
            if(board[y][x-1].kind().equals("Zorde") && board[y][x-1].getStuation().equals("alive")){
                board[y][x-1].setHP(board[y][x-1].getHP()-Constants.humanAP); }
            if(board[y+1][x+1].kind().equals("Zorde") && board[y+1][x+1].getStuation().equals("alive")){
                board[y+1][x+1].setHP(board[y+1][x+1].getHP()-Constants.humanAP); }
            if(board[y+1][x-1].kind().equals("Zorde") && board[y+1][x-1].getStuation().equals("alive")){
                board[y+1][x-1].setHP(board[y+1][x-1].getHP()-Constants.humanAP); }
            if(board[y-1][x+1].kind().equals("Zorde") && board[y-1][x+1].getStuation().equals("alive")){
                board[y-1][x+1].setHP(board[y-1][x+1].getHP()-Constants.humanAP); }
            if(board[y-1][x-1].kind().equals("Zorde") && board[y-1][x-1].getStuation().equals("alive")){
                board[y-1][x-1].setHP(board[y-1][x-1].getHP()-Constants.humanAP); }}
        else if(ch.characterkind().equals("Elf")){
            if(board[y+1][x].kind().equals("Zorde") && board[y+1][x].getStuation().equals("alive")){
                board[y+1][x].setHP(board[y+1][x].getHP()-Constants.elfAP); }
            if(board[y-1][x].kind().equals("Zorde") && board[y-1][x].getStuation().equals("alive")){
                board[y-1][x].setHP(board[y-1][x].getHP()-Constants.elfAP); }
            if(board[y][x+1].kind().equals("Zorde") && board[y][x+1].getStuation().equals("alive")){
                board[y][x+1].setHP(board[y][x+1].getHP()-Constants.elfAP);}
            if(board[y][x-1].kind().equals("Zorde") && board[y][x-1].getStuation().equals("alive")){
                board[y][x-1].setHP(board[y][x-1].getHP()-Constants.elfAP); }
            if(board[y+1][x+1].kind().equals("Zorde") && board[y+1][x+1].getStuation().equals("alive")){
                board[y+1][x+1].setHP(board[y+1][x+1].getHP()-Constants.elfAP); }
            if(board[y+1][x-1].kind().equals("Zorde") && board[y+1][x-1].getStuation().equals("alive")){
                board[y+1][x-1].setHP(board[y+1][x-1].getHP()-Constants.elfAP); }
            if(board[y-1][x+1].kind().equals("Zorde") && board[y-1][x+1].getStuation().equals("alive")){
                board[y-1][x+1].setHP(board[y-1][x+1].getHP()-Constants.elfAP); }
            if(board[y-1][x-1].kind().equals("Zorde") && board[y-1][x-1].getStuation().equals("alive")){
                board[y-1][x-1].setHP(board[y-1][x-1].getHP()-Constants.elfAP); }}

        else if(ch.characterkind().equals("Dwarf")){
            if(board[y+1][x].kind().equals("Zorde") && board[y+1][x].getStuation().equals("alive")){
                board[y+1][x].setHP(board[y+1][x].getHP()-Constants.dwarfAP); }
            if(board[y-1][x].kind().equals("Zorde") && board[y-1][x].getStuation().equals("alive")){
                board[y-1][x].setHP(board[y-1][x].getHP()-Constants.dwarfAP); }
            if(board[y][x+1].kind().equals("Zorde") && board[y][x+1].getStuation().equals("alive")){
                board[y][x+1].setHP(board[y][x+1].getHP()-Constants.dwarfAP);}
            if(board[y][x-1].kind().equals("Zorde") && board[y][x-1].getStuation().equals("alive")){
                board[y][x-1].setHP(board[y][x-1].getHP()-Constants.dwarfAP); }
            if(board[y+1][x+1].kind().equals("Zorde") && board[y+1][x+1].getStuation().equals("alive")){
                board[y+1][x+1].setHP(board[y+1][x+1].getHP()-Constants.dwarfAP); }
            if(board[y+1][x-1].kind().equals("Zorde") && board[y+1][x-1].getStuation().equals("alive")){
                board[y+1][x-1].setHP(board[y+1][x-1].getHP()-Constants.dwarfAP); }
            if(board[y-1][x+1].kind().equals("Zorde") && board[y-1][x+1].getStuation().equals("alive")){
                board[y-1][x+1].setHP(board[y-1][x+1].getHP()-Constants.dwarfAP); }
            if(board[y-1][x-1].kind().equals("Zorde") && board[y-1][x-1].getStuation().equals("alive")){
                board[y-1][x-1].setHP(board[y-1][x-1].getHP()-Constants.dwarfAP); }}
    }


    //This method for Elf's ranged attack. It checks 5x5 square to attack(itself not included)
    public static void RangeAttack(Character ch, Character[][] board){
        int x = ch.getX();
        int y = ch.getY();
        if(y>=2 && x>=2){ if(board[y-2][x-2].kind().equals("Zorde") && board[y-2][x-2].getStuation().equals("alive")){
            board[y-2][x-2].setHP(board[y-2][x-2].getHP()-Constants.elfRangedAP); }}
        if(y>=2 && x>=1){if(board[y-2][x-1].kind().equals("Zorde") && board[y-2][x-1].getStuation().equals("alive")){
            board[y-2][x-1].setHP(board[y-2][x-1].getHP()-Constants.elfRangedAP); }}
        if(y>=2){if(board[y-2][x].kind().equals("Zorde") && board[y-2][x].getStuation().equals("alive") ){
            board[y-2][x].setHP(board[y-2][x].getHP()-Constants.elfRangedAP);} }
        if(y>=2 && x<a){if(board[y-2][x+1].kind().equals("Zorde") && board[y-2][x+1].getStuation().equals("alive")){
            board[y-2][x+1].setHP(board[y-2][x+1].getHP()-Constants.elfRangedAP);} }
        if(y>=2 && x<a-1){if(board[y-2][x+2].kind().equals("Zorde") && board[y-2][x+2].getStuation().equals("alive")){
            board[y-2][x+2].setHP(board[y-2][x+2].getHP()-Constants.elfRangedAP); }}
        if(y>=1 && x>=2){if(board[y-1][x-2].kind().equals("Zorde") && board[y-1][x-2].getStuation().equals("alive")){
            board[y-1][x-2].setHP(board[y-1][x-2].getHP()-Constants.elfRangedAP); }}
        if(y>=1 && x>=1){if(board[y-1][x-1].kind().equals("Zorde") && board[y-1][x-1].getStuation().equals("alive")){
            board[y-1][x-1].setHP(board[y-1][x-1].getHP()-Constants.elfRangedAP); }}
        if(y>=1){if(board[y-1][x].kind().equals("Zorde") && board[y-1][x].getStuation().equals("alive")){
            board[y-1][x].setHP(board[y-1][x].getHP()-Constants.elfRangedAP); }}
        if(y>=1 && x<a){if(board[y-1][x+1].kind().equals("Zorde") && board[y-1][x+1].getStuation().equals("alive")){
            board[y-1][x+1].setHP(board[y-1][x+1].getHP()-Constants.elfRangedAP); }}
        if(y>=1 && x<a-1){if(board[y-1][x+2].kind().equals("Zorde") && board[y-1][x+2].getStuation().equals("alive")){
            board[y-1][x+2].setHP(board[y-1][x+2].getHP()-Constants.elfRangedAP); }}
        if(x>=2){if(board[y][x-2].kind().equals("Zorde") && board[y][x-2].getStuation().equals("alive") ){
            board[y][x-2].setHP(board[y][x-2].getHP()-Constants.elfRangedAP); }}
        if(x>=1){if(board[y][x-1].kind().equals("Zorde") && board[y][x-1].getStuation().equals("alive")){
            board[y][x-1].setHP(board[y][x-1].getHP()-Constants.elfRangedAP); }}
        if(x<a){if(board[y][x+1].kind().equals("Zorde") && board[y][x+1].getStuation().equals("alive")){
            board[y][x+1].setHP(board[y][x+1].getHP()-Constants.elfRangedAP); }}
        if(x<a-1){if(board[y][x+2].kind().equals("Zorde") && board[y][x+2].getStuation().equals("alive")) {
            board[y][x + 2].setHP(board[y][x + 2].getHP() - Constants.elfRangedAP); }}
        if(y<a && x>=2){if(board[y+1][x-2].kind().equals("Zorde") && board[y+1][x-2].getStuation().equals("alive")){
            board[y+1][x-2].setHP(board[y+1][x-2].getHP()-Constants.elfRangedAP); }}
       if(y<a && x>=1){if(board[y+1][x-1].kind().equals("Zorde") && board[y+1][x-1].getStuation().equals("alive")) {
           board[y + 1][x - 1].setHP(board[y + 1][x - 1].getHP() - Constants.elfRangedAP); }}
        if(y<a){if(board[y+1][x].kind().equals("Zorde") && board[y+1][x].getStuation().equals("alive")){
            board[y+1][x].setHP(board[y+1][x].getHP()-Constants.elfRangedAP); }}
        if(y<a && x<a){if(board[y+1][x+1].kind().equals("Zorde") && board[y+1][x+1].getStuation().equals("alive")){
            board[y+1][x+1].setHP(board[y+1][x+1].getHP()-Constants.elfRangedAP); }}
        if(y<a && x<a-1){if(board[y+1][x+2].kind().equals("Zorde") && board[y+1][x+2].getStuation().equals("alive")){
            board[y+1][x+2].setHP(board[y+1][x+2].getHP()-Constants.elfRangedAP); }}
        if(y<a-1 && x<a-1){if(board[y+2][x-2].kind().equals("Zorde") && board[y+2][x-2].getStuation().equals("alive")){
            board[y+2][x-2].setHP(board[y+2][x-2].getHP()-Constants.elfRangedAP); }}
        if(y<a-1 && x>=1){if(board[y+2][x-1].kind().equals("Zorde") && board[y+2][x-1].getStuation().equals("alive")){
            board[y+2][x-1].setHP(board[y+2][x-1].getHP()-Constants.elfRangedAP);} }
        if(y<a-1){if(board[y+2][x].kind().equals("Zorde") && board[y+2][x].getStuation().equals("alive")){
            board[y+2][x].setHP(board[y+2][x].getHP()-Constants.elfRangedAP); }}
        if(y<a-1 && x<a){if(board[y+2][x+1].kind().equals("Zorde") && board[y+2][x+1].getStuation().equals("alive")){
            board[y+2][x+1].setHP(board[y+2][x+1].getHP()-Constants.elfRangedAP);}}
        if(y<a-2 && x<a-2){if(board[y+2][x+2].kind().equals("Zorde") && board[y+2][x+2].getStuation().equals("alive")){
            board[y+2][x+2].setHP(board[y+2][x+2].getHP()-Constants.elfRangedAP);} }

    }

    //This method for Ork's heal power. It checks 3x3 area includes itself
    public static void Heal(Character ch, Character[][] board,FileWriter writer){
        int y2 = ch.getY();
        int x2 = ch.getX();
        if(ch.getHP()<ch.getInitialHP()-Constants.orkHealPoints){
            ch.setHP(ch.getHP()+Constants.orkHealPoints);
            }
        else{
            ch.setHP(ch.getInitialHP());
        }

        if(board[y2-1][x2].kind().equals("Zorde")){
            board[y2-1][x2].setHP(board[y2-1][x2].getHP()+Constants.orkHealPoints);
            if(board[y2-1][x2].getHP()>=board[y2-1][x2].getInitialHP()){
                board[y2-1][x2].setHP(board[y2-1][x2].getInitialHP());
            }
        }
        if(board[y2+1][x2].kind().equals("Zorde")){
            board[y2+1][x2].setHP(board[y2+1][x2].getHP()+Constants.orkHealPoints);
            if(board[y2+1][x2].getHP()>=board[y2+1][x2].getInitialHP()){
                board[y2+1][x2].setHP(board[y2+1][x2].getInitialHP());
            }
        }
        if(board[y2][x2-1].kind().equals("Zorde")){
            board[y2][x2-1].setHP(board[y2][x2-1].getHP()+Constants.orkHealPoints);
            if(board[y2][x2-1].getHP()>=board[y2][x2-1].getInitialHP()){
                board[y2][x2-1].setHP(board[y2][x2-1].getInitialHP());
            }
        }
        if(board[y2][x2+1].kind().equals("Zorde")){
            board[y2][x2+1].setHP(board[y2][x2+1].getHP()+Constants.orkHealPoints);
            if(board[y2][x2+1].getHP()>=board[y2][x2+1].getInitialHP()){
                board[y2][x2+1].setHP(board[y2][x2+1].getInitialHP());
            }
        }
        if(board[y2-1][x2-1].kind().equals("Zorde")){
            board[y2-1][x2-1].setHP(board[y2-1][x2-1].getHP()+Constants.orkHealPoints);
            if(board[y2-1][x2-1].getHP()>=board[y2-1][x2-1].getInitialHP()){
                board[y2-1][x2-1].setHP(board[y2-1][x2-1].getInitialHP());
            }
        }
        if(board[y2-1][x2+1].kind().equals("Zorde")){
            board[y2-1][x2+1].setHP(board[y2-1][x2+1].getHP()+Constants.orkHealPoints);
            if(board[y2-1][x2+1].getHP()>=board[y2-1][x2+1].getInitialHP()){
                board[y2-1][x2+1].setHP(board[y2-1][x2+1].getInitialHP());
            }
        }
        if(board[y2+1][x2-1].kind().equals("Zorde")){
            board[y2+1][x2-1].setHP(board[y2+1][x2-1].getHP()+Constants.orkHealPoints);
            if(board[y2+1][x2-1].getHP()>=board[y2+1][x2-1].getInitialHP()){
                board[y2+1][x2-1].setHP(board[y2+1][x2-1].getInitialHP());
            }}
        if(board[y2+1][x2+1].kind().equals("Zorde")){
            board[y2+1][x2+1].setHP(board[y2+1][x2+1].getHP()+Constants.orkHealPoints);
            if(board[y2+1][x2+1].getHP()>=board[y2+1][x2+1].getInitialHP()){
                board[y2+1][x2+1].setHP(board[y2+1][x2+1].getInitialHP());
            }}

    }

    //This method for finding the character related with the square in board
    public static Character FindCharacter(String name){
        Character a = Temp;
        for(Character character:CharacterArrayList){
            if(character.toString().equals(name)){
                a=character; }
        }
        return a;
    }

    public static ArrayList<Character> CharacterArrayList = new ArrayList<>();

    //This method call the related Go method according to command line argument
    public static void MOVE(String move, Character ch, Character[][] board,FileWriter writer) throws Exception {
        String[] moves = move.split(";");
        if(moves[0].equals("0") && moves[1].equals("1")){
            GoDownward(ch,board,writer);
        }
        else if(moves[0].equals("0") && moves[1].equals("-1")){
            GoUpward(ch,board,writer);
        }
        else if(moves[0].equals("1") && moves[1].equals("0")){
            GoRightward(ch,board,writer);
        }
        else if(moves[0].equals("-1") && moves[1].equals("0")){
            GoLeftward(ch, board,writer);
        }
        else if(moves[0].equals("1") && moves[1].equals("1")){
                GoRightDownCross(ch, board,writer);
        }
        else if(moves[0].equals("1") && moves[1].equals("-1")){
                GoRightUpCross(ch, board,writer);
        }
        else if(moves[0].equals("-1") && moves[1].equals("1")){
            GoLeftDownCross(ch, board,writer);
        }
        else if(moves[0].equals("-1") && moves[1].equals("-1")){
            GoLeftUpCross(ch, board,writer);
        }
    }
    //This method for fight to death
    public static Character FightToDeath(Character attacker, Character defender, Character[][] board,FileWriter writer){
        int HP1 = attacker.getHP();
        int HP2 = defender.getHP();
        Character ch=Temp;
        b = 1;
        HP2=HP2-attacker.getAP();
        int x = defender.getX();
        int y = defender.getY();
        if(HP1==HP2){
            board[attacker.getY()][attacker.getX()]=Temp;
            board[defender.getY()][attacker.getX()]=Temp;
            attacker.setStuation("dead");
            defender.setStuation("dead");
            CharacterArrayList.remove(attacker);
            CharacterArrayList.remove(defender);
            ch =  Temp; }
        else if(HP1<HP2){
            board[attacker.getY()][attacker.getX()]=Temp;
            CharacterArrayList.remove(attacker);
            attacker.setStuation("dead");
            attacker.setHP(0);
            ch =  defender;
            if(HP1>=0){
            defender.setHP(HP2-HP1);}
            else{
                defender.setHP(HP2);
            }
        }
        else if(HP1>HP2){
            board[defender.getY()][attacker.getX()]=Temp;
            CharacterArrayList.remove(defender);
            defender.setStuation("dead");
            defender.setHP(0);
            attacker.setX(x);
            attacker.setY(y);
            ch = attacker;
            if(HP2>=0){
            attacker.setHP(HP1-HP2);}
            else{
                attacker.setHP(HP1);
            }
        }
        return ch;}

    public static void main(String[] args) throws Exception {
        String[] lines = ReadFromFile.readFile(args[0]);
        String[] Clines = ReadFromFile.readFile(args[1]);
        assert lines != null;
        String[] size = lines[1].split("x");
        a = Integer.parseInt(size[0]);
        Character[][] board = new Character[a+2][a+2];


        FileWriter writer = new FileWriter(args[2]);
        for(int i = 0; i<a+2; i++){
            for(int j = 0; j<a+2; j++) {
                if(i==0 || i==a+1){
                    board[i][j] = DoubleStar; }
                else{
                    board[i][j] = Temp; }
                if(j == 0 || j == a+1){
                    board[i][j] = SingleStar; } }}
        for(String line: lines){
            if(line.startsWith("ELF")){
                Elf elf = new Elf(line.substring(4,6));
                int x=Integer.parseInt(line.substring(7,8));
                int y=Integer.parseInt(line.substring(9));
                elf.setX(x+1); elf.setY(y+1);
                board[y+1][x+1]=elf;
                CharacterArrayList.add(elf); }
            else if(line.startsWith("DWARF")){
                Dwarf dwarf = new Dwarf(line.substring(6,8));
                int x=Integer.parseInt(line.substring(9,10));
                int y=Integer.parseInt(line.substring(11));
                board[y+1][x+1]=dwarf;
                dwarf.setX(x+1); dwarf.setY(y+1);
                CharacterArrayList.add(dwarf); }
            else if(line.startsWith("HUMAN")){
                Human human = new Human(line.substring(6,8));
                int x=Integer.parseInt(line.substring(9,10));
                int y=Integer.parseInt(line.substring(11));
                board[y+1][x+1]=human;
                human.setX(x+1); human.setY(y+1);
                CharacterArrayList.add(human);}
            else if(line.startsWith("ORK")){
                Ork ork = new Ork(line.substring(4,6));
                int x=Integer.parseInt(line.substring(7,8));
                int y=Integer.parseInt(line.substring(9));
                board[y+1][x+1]=ork;
                ork.setX(x+1); ork.setY(y+1);
                CharacterArrayList.add(ork); }
            else if(line.startsWith("TROLL")){
                Troll troll = new Troll(line.substring(6,8));
                int x=Integer.parseInt(line.substring(9,10));
                int y=Integer.parseInt(line.substring(11));
                troll.setX(x+1); troll.setY(y+1);
                board[y+1][x+1]=troll;
                CharacterArrayList.add(troll); }
            else if(line.startsWith("GOBLIN")){
                Goblin goblin = new Goblin(line.substring(7,9));
                int x=Integer.parseInt(line.substring(10,11));
                int y=Integer.parseInt(line.substring(12));
                goblin.setX(x+1); goblin.setY(y+1);
                board[y+1][x+1]=goblin;
                CharacterArrayList.add(goblin); }
        }
        PrintBoard(a,board,writer);
        assert Clines != null;
        for(String cline: Clines){
            for(Character character:CharacterArrayList){
                if(character.toString().equals(cline.substring(0,2))){
                   try{

                    switch (cline.substring(0,1)){
                        case "O":{
                            b=0;
                            if(cline.split(";").length==2) {
                                Character ch = FindCharacter(cline.substring(0, 2));
                                int y2 = ch.getY();
                                int x2 = ch.getX();
                                String[] moves = cline.split(";");
                                String move = moves[0].substring(3)+";"+moves[1];
                                String movex =  moves[0].substring(3);
                                String movey = moves[1];
                                int movex2 = x2+(Integer.parseInt(movex));
                                int movey2 = y2+(Integer.parseInt(movey));

                                if((movex2<=a && movex2>=1 ) && (movey2 <= a && movey2 >= 1 )){
                                Heal(FindCharacter(cline.substring(0, 2)), board,writer);}
                                MOVE(move, FindCharacter(cline.substring(0,2)), board,writer); count++;
                            if(b==0){Attack(FindCharacter(cline.substring(0, 2)), board);}}
                            else{
                                throw MoveCountException;
                            }
                PrintBoard(a,board,writer);
                                break;}
                        case "T":{
                            b=0;
                            if(cline.split(";").length==2) {
                                String[] moves = cline.split(";");
                                String move = moves[0].substring(3)+";"+moves[1];
                                MOVE(move, FindCharacter(cline.substring(0,2)), board,writer); count++;
                            if(b==0){Attack(FindCharacter(cline.substring(0, 2)), board);}}
                            else{
                                throw MoveCountException;
                            }
                PrintBoard(a,board,writer);
                            break;}
                        case "G":{
                            b=0;
                            if(cline.split(";").length==8) {
                                String[] moves = cline.split(";");
                                String move1 = moves[0].substring(3) + ";" + moves[1];
                                String move2 = moves[2] + ";" + moves[3];
                                String move3 = moves[4] + ";" + moves[5];
                                String move4 = moves[6] + ";" + moves[7];
                                MOVE(move1, FindCharacter(cline.substring(0, 2)), board,writer); count++;
                                if(b==0){Attack(FindCharacter(cline.substring(0, 2)), board);}
                                if(b==0){ MOVE(move2, FindCharacter(cline.substring(0,2)), board,writer);}
                                    if(b==0){Attack(FindCharacter(cline.substring(0, 2)), board);}
                                if(b==0){MOVE(move3, FindCharacter(cline.substring(0,2)), board,writer);}
                                    if(b==0){Attack(FindCharacter(cline.substring(0, 2)), board);}
                                if(b==0){MOVE(move4, FindCharacter(cline.substring(0,2)), board,writer);}
                                if(b==0){Attack(FindCharacter(cline.substring(0, 2)), board);}}
                            else{
                                throw MoveCountException;
                            }
                PrintBoard(a,board,writer);
                            break; }
                        case "H":{
                            b=0;
                            if(cline.split(";").length==6) {

                                String[] moves = cline.split(";");
                                String move1 = moves[0].substring(3)+";"+moves[1];
                                String move2 = moves[2]+";"+moves[3];
                                String move3 = moves[4]+";"+moves[5];
                                MOVE(move1, FindCharacter(cline.substring(0,2)), board,writer); count++;
                                if(b==0){MOVE(move2, FindCharacter(cline.substring(0,2)), board,writer);}
                                    if(b==0){MOVE(move3, FindCharacter(cline.substring(0,2)), board,writer);}
                                if(b==0){ Attack(FindCharacter(cline.substring(0, 2)), board);}}
                            else{
                                throw MoveCountException;
                            }
                PrintBoard(a,board,writer);
                            break; }
                        case "E":{
                            b=0;
                            if(cline.split(";").length==8)  {
                            String[] moves = cline.split(";");
                            String move1 = moves[0].substring(3)+";"+moves[1];
                            String move2 = moves[2]+";"+moves[3];
                            String move3 = moves[4]+";"+moves[5];
                            String move4 = moves[6]+";"+moves[7];
                            MOVE(move1, FindCharacter(cline.substring(0,2)), board,writer); count++;
                                if(b==0){Attack(FindCharacter(cline.substring(0, 2)), board);}
                                if(b==0){MOVE(move2, FindCharacter(cline.substring(0,2)), board,writer);}
                                if(b==0){Attack(FindCharacter(cline.substring(0, 2)), board);}
                                    if(b==0){MOVE(move3, FindCharacter(cline.substring(0,2)), board,writer);}
                                if(b==0){Attack(FindCharacter(cline.substring(0, 2)), board);}
                                        if(b==0){MOVE(move4, FindCharacter(cline.substring(0,2)), board,writer);}
                                if(b==0){RangeAttack(FindCharacter(cline.substring(0,2)),board);} }
                            else{
                                throw MoveCountException;
                            }

                PrintBoard(a,board,writer);
                            break; }
                        case "D":{
                            b=0;
                            if(cline.split(";").length==4) {
                                String[] moves = cline.split(";");
                                String move1 = moves[0].substring(3) + ";" + moves[1];
                                String move2 = moves[2] + ";" + moves[3];
                                MOVE(move1, FindCharacter(cline.substring(0, 2)), board,writer); count++;
                                if(b==0){Attack(FindCharacter(cline.substring(0, 2)), board);}
                            if(b==0){MOVE(move2, FindCharacter(cline.substring(0,2)), board,writer);}
                                if(b==0){Attack(FindCharacter(cline.substring(0, 2)), board);}}
                            else{
                                throw MoveCountException;
                            }
                PrintBoard(a,board,writer);
                            break;
                        } }

                        break;
                   }
                        catch(ArithmeticException BoundaryException){

                           if(count!=0){
                               PrintBoard(a,board,writer);
                           }
                            writer.write("Error : Game board boundaries are exceeded. Input line ignored.\n\n");
                        }
                        catch(IllegalArgumentException MoveCountException){
                            writer.write("Error : Move sequence contains wrong number of move steps. Input line ignored. \n\n");
                   }
                  }}
            ArrayList<Character> ZordeArraylist = new ArrayList<>();
            ArrayList<Character> CallArraylist = new ArrayList<>();
            for (int i = 0; i < a + 2; i++) {
                for (int j = 0; j < a + 2; j++) {
                    if (board[i][j].getStuation().equals("alive")) {
                        if(board[i][j].kind().equals("Zorde")){
                            ZordeArraylist.add(board[i][j]);
                        }
                        else if(board[i][j].kind().equals("Calliance")){
                            CallArraylist.add(board[i][j]);
                        } } } }
            if(ZordeArraylist.size()==0){
                writer.write("\nGame Finished\nCalliance Wins\n"); break; }
            else if(CallArraylist.size()==0){
                writer.write("\nGame Finished\nZorde Wins\n"); break;}

        count = 0;}




writer.close();
    }
}

