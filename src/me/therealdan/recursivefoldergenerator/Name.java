package me.therealdan.recursivefoldergenerator;

import java.util.Random;

public class Name {

    private static Random RANDOM = new Random();

    private String name;

    public Name() {
        this(randomLetter());
    }

    public Name(char firstLetter) {
        this(4, 8, firstLetter);
    }

    public Name(int minLength, int maxLength) {
        this(minLength, maxLength, randomLetter());
    }

    public Name(int minLength, int maxLength, char firstLetter) {
        int length = RANDOM.nextInt(maxLength - minLength + 1) + minLength;
        this.name = String.valueOf(firstLetter);

        while (this.name.length() < length) {
            this.name += getRandomFollowing(this.name.toCharArray()[this.name.length() - 1]);

            if (this.name.length() > 2 &&
                    this.name.substring(this.name.length() - 1).matches(this.name.substring(this.name.length() - 2, this.name.length() - 1)) &&
                    this.name.substring(this.name.length() - 1).matches(this.name.substring(this.name.length() - 3, this.name.length() - 2))) {
                this.name = this.name.substring(this.name.length() - 1);
            }
        }
    }

    public String get() {
        return name;
    }

    private static char getRandomFollowing(char previous) {
        String potentialOptions;
        switch (previous) {
            case 'A':
                potentialOptions = "BCDEFGHIJKLMNPQRSTVWXYZ";
                break;
            case 'B':
                potentialOptions = "AEILOUY";
                break;
            case 'C':
                potentialOptions = "AEHIORUY";
                break;
            case 'D':
                potentialOptions = "AEIORUY";
                break;
            case 'E':
                potentialOptions = "BCDFGHJKLMNPQRSTVWXYZ";
                break;
            case 'F':
                potentialOptions = "AEILORUWY";
                break;
            case 'G':
                potentialOptions = "AEHINORUY";
                break;
            case 'H':
                potentialOptions = "AEIOUY";
                break;
            case 'I':
                potentialOptions = "BCDEFGHJKLMNPQRSTVWZ";
                break;
            case 'J':
                potentialOptions = "AEILOUY";
                break;
            case 'K':
                potentialOptions = "AEILNOUY";
                break;
            case 'L':
                potentialOptions = "AEILOUYZ";
                break;
            case 'M':
                potentialOptions = "AEIORUY";
                break;
            case 'N':
                potentialOptions = "AEIOTU";
                break;
            case 'O':
                potentialOptions = "ABCDEFGHKLMNOPRSTUVWXZ";
                break;
            case 'P':
                potentialOptions = "AEHILORUY";
                break;
            case 'Q':
                potentialOptions = "AEIOU";
                break;
            case 'R':
                potentialOptions = "AEIO";
                break;
            case 'S':
                potentialOptions = "AEHILNOPQRSTUVWY";
                break;
            case 'T':
                potentialOptions = "AEHIOTUY";
                break;
            case 'U':
                potentialOptions = "BCDFGHKLMNPQRSTV";
                break;
            case 'V':
                potentialOptions = "AEIOU";
                break;
            case 'W':
                potentialOptions = "AEHIORUY";
                break;
            case 'X':
                potentialOptions = "AEIOTUY";
                break;
            case 'Y':
                potentialOptions = "AEIKLNOPX";
                break;
            case 'Z':
                potentialOptions = "AEIOUVY";
                break;
            default:
                potentialOptions = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
        }
        return potentialOptions.toCharArray()[RANDOM.nextInt(potentialOptions.length())];
    }

    private static char randomLetter() {
        return (char) (RANDOM.nextInt(26) + 'A');
    }
}