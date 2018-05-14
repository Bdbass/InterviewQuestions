package Google;
import java.util.*;

public class Boggle {

    static void MakeDictionary(Set<String>Input) {
        Input.add("geeks");
        Input.add("for");
        Input.add("quiz");
        Input.add("go");
    }


    public static void main(String[] args) {
        //create board
        Set<String> input = new HashSet<>();
        MakeDictionary(input);
        char[][] BoggleBoard = {{'g', 'i', 'z'},
                                {'u', 'e', 'k'},
                                {'q', 's', 'e'}};

        //Create Trie based on dictonary
        Node root = new Node();
        trie myTrie = new trie(root);

        for (String i: input){
            myTrie.Add(i);
        }


    }
}
