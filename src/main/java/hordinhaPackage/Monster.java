package hordinhaPackage;

public class Monster {
    private String name;
    private boolean alive;
    private static int ca;
    private static int hpMax;
    private int hp;
    private int hpBonus;

    public Monster() {
        this("", 0, 0);
    }

    public Monster(String name, int ca, int hpMax){
        this.name = name;
        alive = true;
        this.ca = ca;
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.hpBonus = 0;
    }

    public void setHp(int value) {
        if (value > 0) {
            hp = Math.min(hp + value, hpMax);
        } else if (value < 0) {
            int dano = -value;

            if (hpBonus > 0) {
                int absorvido = Math.min(dano, hpBonus);
                hpBonus -= absorvido;
                dano -= absorvido;
            }

            hp -= dano;

            if (hp <= 0) {
                alive = false;
            }
        } else {
            hp = value;
        }
    }

    public String toString() {return getName() + " (CA: " + getCa() + ", HP MAX: " + getHpMax() + ", HP: " + ((alive) ?getHp() :"Morto! " + hp) + ", HP Bonus: " + getHpBonus() + ")";}
    public void setHpBonus(int hpBonus) {this.hpBonus += hpBonus;}
    public void setCa(int ca) {this.ca = ca;}
    public void setHpMax(int hpMax) {this.hpMax = hpMax; this.hp = Math.min(this.hp, hpMax);}
    public void setName(String name) {this.name = name;}
    public int getCa() {return ca;}
    public int getHp() {return hp;}
    public int getHpBonus() {return hpBonus;}
    public int getHpMax() {return hpMax;}
    public String getName() {return name;}
}
