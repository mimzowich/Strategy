package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
//Name:Anshu Patil

public abstract class Monster {
    // instance variables
    private Integer hp;
    private Integer xp;

    Integer agi = 10;
    Integer def = 10;
    Integer str = 10;
    Attack attack;


    public Attack getAttack() {
        return attack;
    }
    boolean takeDamage(Integer damage) {
        if (damage > 0) {
            hp -= damage;
            System.out.println("The creature was hit for " + damage + " damage.");

            if (hp <= 0) {
                System.out.println("Oh no! The creature has perished.");
                hp = 0;
            }

            System.out.println(toString());
            return hp > 0;
        }
        return true;
    }

    public Integer attackTarget(Monster target) {
        int damage = attack.attack(target);

        if (this.getHp() <= 0) {
            System.out.println(target.toString());
            return 0;
        }

        target.takeDamage(damage);
        return damage;
    }




    Integer getAttribute(Integer min,Integer max){
        Random rand = new Random();
        if(min>max){
            Integer temp = min;
            min = max;
            max = temp;
        }
        //returns a random number between min and max inclusive
        return rand.nextInt(max-min) + min;
    }

    private Integer maxHP;
    private HashMap<String, Integer> items;

    public Monster(Integer maxHP, Integer xp, HashMap<String,Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
    }

    // getters and setters
    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getXp() {
        return xp;
    }
    public HashMap<String, Integer> getItems() {
        return items;
    }
    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }
    public Integer getMaxHP() {
        return maxHP;
    }

    public Integer getAgi() {
        return agi;
    }

    public Integer getDef() {
        return def;
    }

    public Integer getStr() {
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return hp == monster.hp && xp == monster.xp && maxHP == monster.maxHP && Objects.equals(items, monster.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, xp, maxHP, items);
    }

    @Override
    public String toString() {
        return " :hp=" + hp +
                "/" + maxHP;
    }
}
