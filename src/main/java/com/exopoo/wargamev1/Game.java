package com.exopoo.wargamev1;

import com.exopoo.wargamev1.tools.ClassFactory;
import com.exopoo.wargamev1.tools.Player;
import com.exopoo.wargamev1.tools.PlayerClassEnum;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    int tours = 0;
    Scanner scanner = new Scanner(System.in);
    int selectedClass;
    int classQuantity;
    Player winner;
    Player character1;
    Player character2;

    /* -------------------------------------------------------- */
    List<PlayerClassEnum> ListEnumClass = new ArrayList<>(
            Arrays.asList(
                    PlayerClassEnum.WARRIOR,
                    PlayerClassEnum.ORCQ,
                    PlayerClassEnum.MAGICIAN,
                    PlayerClassEnum.ELF
            ));
    List<Player> characterList = new ArrayList<>();


    /* ------------------------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------------------------- */
    // UTIL
    public int randomNumber(int limit) {
        return (int) Math.floor(Math.random() * limit);
    }

    /* ------------------------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------------------------- */

    public void startGame() {
        this.selectClass();
        this.selectClassCount();
        this.addNClassToList();
        this.resumeSelection();
        this.keepAddClass();

        this.handleRound();

    }

    /* ------------------------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------------------------- */

    public int selectClass() {
        System.out.println("");
        System.out.println("        Choisir une class :");
        System.out.println("            1 - Guerrier ");
        System.out.println("            2 - Orcq");
        System.out.println("            3 - Magicien");
        System.out.println("            4 - Elf");

        int choice = 0;

        try {
            choice = scanner.nextInt();
            while (choice < 0 || choice > ListEnumClass.size()) {
                System.out.println("choix incorrect, recommencez :");
                System.out.println("");
                this.selectClass();
                scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("choix incorrect, recommencez :");
            System.out.println("");
            this.selectClass();
        }
       /* catch (InputMismatchException e) {
            scanner.next();
            System.out.println("Faut un chiffre baka, recommencez :");
            System.out.println("");
            this.selectClass();
        }*/
        return this.selectedClass = choice;
    }

    /* -------------------------------------------------------- */
    public void selectClassCount() {
        System.out.println("                    Classe sélectionnée : ");
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|------------------------ " + ListEnumClass.get(this.selectedClass - 1).getName() + " ---------------------------|");
        System.out.println("|--------------------------------------------------------------|");
        // it select the "class" in the classList composed of Enum ( here will only display the "enum key" )
        System.out.println("        Combien voulez vous en ajouter ? :");
        this.classQuantity = this.scanner.nextInt();
    }

    /* -------------------------------------------------------- */
    public void addNClassToList() {
        ClassFactory classfacto = new ClassFactory();
        if (this.classQuantity > 0) {
            for (int i = 0; i < this.classQuantity; i++) {
                characterList.add(classfacto.createRole(ListEnumClass.get(this.selectedClass - 1)));
                String name = characterList.get(i).getNom();
                characterList.get(i).setNom(name + i);
            }
        }
    }

    /* -------------------------------------------------------- */
    public void keepAddClass() {
        System.out.println(" ");
        System.out.println("        Ajouter une autre class ?");
        System.out.println("            Oui - O");
        System.out.println("            Non - N");
        System.out.println(" ");

        try {
            String choice = String.valueOf(scanner.next().charAt(0)).toLowerCase();
            if (choice.equals("o")) {
                this.startGame();
            } else if (choice.equals("n")) {
            } else {
                throw new Exception("Choix incorrect recommencez : ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("");
            this.keepAddClass();
        }
    }

    /* -------------------------------------------------------- */
    private void resumeSelection() {
        HashMap<String, Integer> hashClassCount = new HashMap<>();

        for (int i = 0; i < characterList.size(); i++) {
            // hash setup with others class, set class/value if doesnt exist
            // or increment count if already exist
            String className = characterList.get(i).getClass().getSimpleName();
            if (hashClassCount.containsKey(className)) {
                hashClassCount.put(className, hashClassCount.get(className) + 1);
            } else {
                hashClassCount.put(className, 1);
            }
        }
        System.out.println(" ");
        System.out.println("|--------------------------------------------------------------| ");
        System.out.println("|------------------- Vous avez séléctionné : ------------------| ");
        System.out.println("");
        for (String i : hashClassCount.keySet()) {
            System.out.println("                        " + i + " : " + hashClassCount.get(i));
        }
        System.out.println("");
        System.out.println("|--------------------------------------------------------------| ");
        System.out.println("|--------------------------------------------------------------| ");
    }

    /* ------------------------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------------------------- */


    public void handleRound() {
        // AT EACH ROUND START GENERATE LIST WITH ONLY ALIVE CHARACTER
        List<Player> alive = this.characterList.stream()
                .filter((element) -> element.getPv() > 0).toList();

        // check for winner at each round
        if ( alive.size() == 1) {
           winner = alive.get(0);
        }

        while (alive.size() > 1) {
            fightersSelection(alive);

        }
    }
    /* -------------------------------------------------------- */
    public void fightersSelection(List<Player> alive) {
        System.out.println("        selection de 2 personnages aléatoire : ");
        this.character1 = selectARandomCharacter(alive);
        this.character2 = selectARandomCharacter(alive);

        if (this.character1.getNom().equals(this.character2.getNom())) {
            this.fightersSelection(alive);
        }
        /*if (this.character1.getPv() < 0 || this.character2.getPv() <0 ){
            this.fightersSelection(alive);
        }*/
    }
    /* -------------------------------------------------------- */
    public Player selectARandomCharacter(List<Player> liste) {
        int randomIndex = randomNumber(liste.size());
        return liste.get(randomIndex);
    }

    /* -------------------------------------------------------- */
    public void fightHandling() {
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("        Le combat sera entre : : ");
        System.out.println("    " +this.character1.getNom() + " -- VS -- " + this.character2.getNom());
        System.out.println("|--------------------------------------------------------------|");

        character1.attaquer(character2);
    }

    /* ------------------------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------------------------- */
    private void endgame() {

    }
}

