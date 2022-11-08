package com.exopoo.wargamev1.tools;

import com.exopoo.wargamev1.*;

public class ClassFactory {

    public Player createRole(PlayerClassEnum role) {
        if(role.equals(PlayerClassEnum.WARRIOR)) {
            return new Guerrier(
                    "SuperKnightOfLightOfJustice",
                    15.0f,
                    120.0f,
                    25.0f,
                    35.0f,
                    .45f,
                    .25f);
        } else if (role.equals(PlayerClassEnum.ORCQ)) {
            return new Orcq(
                    "BooArhTapeDur",
                    25.0f,
                    145.0f,
                    35.0f,
                    20.0f,
                    .25f,
                    .4f);
        } else if (role.equals(PlayerClassEnum.MAGICIAN)) {
            return new Magicien(
                    "WiizWazzIknowAll",
                    5.0f,
                    90.0f,
                    30.0f,
                    8.0f,
                    .6f,
                    .55f);
        } else if (role.equals(PlayerClassEnum.ELF)) {
            return new Elf(
                    "FellFromTree",
                    10.0f,
                    100.0f,
                    15.0f,
                    10.0f,
                    .35f,
                    .7f);
        }
        return null;
    }
}
