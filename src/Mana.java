public class Mana {
    float mana_Max;
    float manaCost;
    float mana;

    Mana() {
        mana_Max = 30;
        mana = mana_Max;
        manaCost = 10;
    }

    void manaRestore() {
        mana = mana_Max;
    }

    void manaLose() {
        mana = mana - manaCost;
    }
}