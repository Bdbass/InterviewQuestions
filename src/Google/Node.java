package Google;
import java.util.*;

// Node of trie class has a letter, a Hashmap of children, and a bool to indicate if its a word
public class Node {
    boolean word;
    char letter;
    Map<Character, Node> children = new HashMap<>();

    //default constructor
    Node(){
        letter = '0';
        word = false;
    }

    //overloaded constructor
    Node(char let){
        word = false;
        letter = let;
    }
}
