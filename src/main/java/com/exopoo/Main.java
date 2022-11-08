package com.exopoo;

import com.exopoo.wargamev1.*;
import com.exopoo.wargamev1.tools.PlayerClassEnum;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        //System.out.println(EnumTest.WARRIOR.getName());
        //System.out.println(EnumTest.ELF.getName());
        //System.out.println(EnumTest.valueOfLabel("Elf"));
        // Player nv = PlayerClassEnum.valueOf("WARRIOR").createClass();


        Game game = new Game();
        game.startGame();
    }
}