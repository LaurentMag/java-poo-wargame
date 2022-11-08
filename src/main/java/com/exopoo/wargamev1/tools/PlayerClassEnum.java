package com.exopoo.wargamev1.tools;

public enum PlayerClassEnum {
    WARRIOR("Guerrier"),
    ORCQ("Orcq"),
    MAGICIAN("Magicien"),
    ELF("Elf"),
    ;

    private String name;
    PlayerClassEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
