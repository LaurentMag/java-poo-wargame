package com.exopoo.test;

import com.exopoo.wargamev1.Elf;
import com.exopoo.wargamev1.Guerrier;
import com.exopoo.wargamev1.Magicien;
import com.exopoo.wargamev1.Orcq;
import com.exopoo.wargamev1.tools.Player;

public abstract class DepressiatedClassFactory {

    public static Player createWarrior() {
        return new Guerrier(
                "SuperKnightOfLightOfJustice",
                15.0f,
                120.0f,
                25.0f,
                35.0f,
                .45f,
                .25f);
    }

    public static Player createOrcq() {
        return new Orcq(
                "BooArhTapeDur",
                25.0f,
                145.0f,
                35.0f,
                20.0f,
                .25f,
                .4f);
    }

    public static Player createMagician() {
        return new Magicien(
                "WiizWazzIknowAll",
                5.0f,
                90.0f,
                30.0f,
                8.0f,
                .6f,
                .55f);
    }

    public static Player createElf() {
        return new Elf(
                "FellFromTree",
                10.0f,
                100.0f,
                15.0f,
                10.0f,
                .35f,
                .7f);
    }

}
