package Encryption_Methods;

/**
 * Created by Nutrient on 02/02/2017.
 */
public class Alphabet {

    private int alphabet;
    private char[] english_alphabet = { 'a','b','c','d','e',
            'f','g','h','i','j',
            'k','l','m','n','o',
            'p','q','r','s','t',
            'u','v','w','x','y',
            'z'
    };

    private char[] currentAlphabet;


    protected void setCurrentAlphabet(int index){
        switch (index){
            case 0:{
                currentAlphabet = english_alphabet;
                break;
            }
            default:{
                currentAlphabet = english_alphabet;
            }
        }
    }

    protected char getAlphabetChar(char ASCII_letter){
        return currentAlphabet[ASCII_letter - 97];
    }

    protected char getAlphabetChar(int alphabet_index){
        return currentAlphabet[alphabet_index];
    }

    protected void setAlphabetChar(char ASCII_letter){
        currentAlphabet[ASCII_letter - 97] = '0';
    }

    protected int getAlphabetLength(){
        return currentAlphabet.length;
    }


}
