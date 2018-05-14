package Google;
import java.util.*;

public class Node {
    boolean word;
    char letter;
    Map<Character, Node> children = new HashMap<>();

    //default constructor
    Node(){
        letter = '0';
        word = false;
        children = null;
    }

    //overloaded constructor
    Node(char let){
        word = false;
        letter = let;
        children = null;
    }
}
