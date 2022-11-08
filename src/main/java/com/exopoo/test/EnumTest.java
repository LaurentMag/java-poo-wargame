package com.exopoo.test;


public enum EnumTest {
    WARRIOR("Guerrier"),
    ORCQ("Orcq"),
    MAGICIAN("Magicien"),
    ELF("Elf"),
    ;

    /* --------------------------- */
    private String name;


    EnumTest(String namep) {
        this.name = namep;
    }
    /* --------------------------- */

    public String getName() {
        return name;
    }
    /* --------------------------- */

    public static EnumTest valueOfLabel(String value) {
        for (EnumTest e : values()) {
            if (e.name.equals(value)) {
                return e;
            }
        }
        return null;
    }
}
