package org.academiadecodigo.codecadets.enums;

public enum WeaponTypes {
    SHOTGUN(15, 4, 5);

    private int damage;
    private int clipBullets;
    private int clips;

    WeaponTypes(int dmg, int clipBullets, int clips) {
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
}
