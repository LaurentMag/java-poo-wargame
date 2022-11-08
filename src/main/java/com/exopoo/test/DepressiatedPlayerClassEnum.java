package com.exopoo.test;


import com.exopoo.wargamev1.tools.Player;

public enum DepressiatedPlayerClassEnum {
    WARRIOR(DepressiatedClassFactory.createWarrior()),
    ORCQ(DepressiatedClassFactory.createOrcq()),
    MAGICIAN(DepressiatedClassFactory.createMagician()),
    ELF(DepressiatedClassFactory.createElf()),
    ;

    /* --------------------------- */
    private final Player newClass;

    DepressiatedPlayerClassEnum(Player generateClass) {
        this.newClass = generateClass;
    }
    /* --------------------------- */

    public Player createClass() {
        return newClass;
    }
    /* --------------------------- */

}
