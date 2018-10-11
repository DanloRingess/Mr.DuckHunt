package org.academiadecodigo.codecadets.enums;

public enum WeaponTypes {

    SHOTGUN(15, 10, 2, 5);

    private int damage;
    private int clipBullets;
    private int clips;
    private int spread;

    WeaponTypes(int dmg, int spread, int clipBullets, int clips) {

        this.damage = dmg;
        this.clipBullets = clipBullets;
        this.clips = clips;
    }

    public int getDamage() {
        return damage;
    }

    public int getClipBullets() {
        return clipBullets;
    }

    public int getClips() {
        return clips;
    }

    public int getSpread() {
        return spread;
    }
}
