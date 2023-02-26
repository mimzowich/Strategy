import java.util.HashMap;
//Name:Anshu Patil
public class Kobold extends Monster{


    public Kobold(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        super(maxHP, xp, items);
    }

    @Override
    public String toString() {
        return "Kobold has" +  super.toString();
    }
}
