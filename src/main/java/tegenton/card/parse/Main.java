package tegenton.card.parse;

import tegenton.card.parse.lexicon.Word;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Lexer lex = new Lexer();
        System.out.print("Card text: ");
        for (Word token : lex.lex(in.nextLine())) {
            System.out.print(token.getWord());
        }
    }
}
