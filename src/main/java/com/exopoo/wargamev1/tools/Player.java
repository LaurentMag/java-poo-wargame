package com.exopoo.wargamev1.tools;

import com.exopoo.wargamev1.interfaces.SeBattre;
import com.exopoo.wargamev1.interfaces.SeDefendre;

public abstract class Player implements SeBattre, SeDefendre {
    private String nom;
    private Float force;
    private Float pv;
    private Float damage;
    private Float def;
    private Float coefDef;
    private Float superPouvoir;
    /* ------------------------------------------------------------------------------------------------- */

    public Player(String nom, Float force, Float pv, Float damage, Float def, Float coefDef, Float superPouvoir) {
        this.nom = nom;
        this.force = force;
        this.pv = pv;
        this.damage = damage;
        this.def = def;
        this.coefDef = coefDef;
        this.superPouvoir = superPouvoir;
    }
    /* ------------------------------------------------------------------------------------------------- */

    private int diceRoll() {
        return (int) Math.floor(Math.random() * 20 + 1);
    }

    @Override
    public void attaquer(Player defendeur) {
        // check if attack succeed
        Float degatsTot;
        Float superDamage = 0.0f;

        // ATTAQUE REUSSI :
        if (diceRoll() % 2 == 0) {
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("😤 L'attaque de " + this.nom + " réussi 😤");

            int superRoll = diceRoll();
            if (superRoll > 0 && superRoll < 5) {
                System.out.println("    🌪🌪💥💥Son super pouvoir se déclenche💥💥🌪🌪");
                superDamage = this.damage * this.superPouvoir;
            }
            degatsTot = this.damage + superDamage;
            System.out.println("    Dégâts potentiels :" + degatsTot);
            System.out.println("");

            // ATTAQUE SUCCESS TRIGGER DEFENSE PART
            defendeur.seDefendre(degatsTot);
            // ATTAQUE RATE
        } else {
            System.out.println("😵 L'attaque de " + this.nom + " à raté 😵");
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("");
        }

    }

    /* ------------------------------------------------------------------------------------------------- */
    @Override
    public void seDefendre(Float degats) {
        Float defenseTot;
        Float superDef = 0.0f;

        // DEFENSE REUSSITE
        if (diceRoll() % 2 == 0) {
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("😬" + this.nom + " réussi à se défendre 😬");
            System.out.println("        Avec : " + this.pv + " pv");

            int superDefRoll = diceRoll();
            if (superDefRoll > 0 && superDefRoll < 6) {
                System.out.println("        🛡🛡🛡🛡La super défense se déclenche🛡🛡🛡🛡");
                superDef = this.def * this.coefDef;
            }
            defenseTot = this.def + superDef;
            System.out.println("    defense finale : " + defenseTot);

            // LA DEFENSE RATE
        } else {
            System.out.println("😨 La défence de " + this.nom + " à échouée 😨");
            System.out.println("        Avec : " + this.pv + " pv");
            defenseTot = 0.0f;
        }

        // APPLICATION DES DEGATS ET CALCUL DES PV RESTANTS
        /* ---------------------------------------------------- */
        Float degatApplique;

        /* ---------------------------------------------------- */
        if (degats < defenseTot) {
            System.out.println(" " + defenseTot + " de defence de " + this.nom + " absorbent la totalité des " + degats + " dégâts");
            degatApplique = 0.0f;
        } else {
            degatApplique = degats - defenseTot;
            System.out.println("");
            System.out.println(" 🤯🤯" + this.nom + " subit " + degatApplique + " dégâts 🤯🤯");
        }
        /* ---------------------------------------------------- */
        this.pv = this.pv - degatApplique;
        if (this.pv > 0) {
            System.out.println(" 😮‍💨‍💨‍ Pv restant : " + this.pv + " ‍💨‍😮‍💨");
        } else {
            System.out.println(" " + this.nom + " est mort ☠️");
        }
        System.out.println("|--------------------------------------------------------------|");

    }

    /* ------------------------------------------------------------------------------------------------- */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPv() {
        return pv;
    }
}
