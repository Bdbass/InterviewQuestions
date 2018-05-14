package Google;
import java.util.*;

// based off a google question, where you have to find all words from a boggle game given a dictionary
public class Boggle {

    public static void main(String[] args) {
        //create dictionary of words
        Set<String> input = new HashSet<>();
        MakeDictionary(input);
        //create board
        char[][] BoggleBoard = {{'g', 'i', 'z'},
                                {'u', 'e', 'k'},
                                {'q', 's', 'e'}};

        //Create Trie based on dictonary
        Node root = new Node();
        trie myTrie = new trie(root);

        for (String i: input){
            myTrie.Add(i);
        }

        //Create string var to be passed to DFS
        StringBuilder outputWords = new StringBuilder();

        // performs a DFS on each letter in the boggle board
        for (int i = 0; i < BoggleBoard.length; i++){
            for (int j = 0; j < BoggleBoard.length; j++){
                DFS(BoggleBoard, root, i, j , outputWords);
            }
        }

    }

    // fills set with words, creating the dictionary
    static private void MakeDictionary(Set<String>Input) {
        Input.add("geeks");
        Input.add("for");
        Input.add("quiz");
        Input.add("go");
    }

    // performs a dfs on the node, using the trie for verification
    static private void DFS(char[][] board, Node TrieNode, int i, int j, StringBuilder stringSoFar){

        char temp = board[i][j]; //save current char

        // only go through here if this letter is in the trie in the right order
        if (TrieNode.children.containsKey(temp)) {

            board[i][j] = '0'; //mark as visited
            TrieNode = TrieNode.children.get(temp); // update trie node
            stringSoFar.append(temp); //add letter to string we're forming

            // if we have made a word print it out
            if (TrieNode.word) {
                System.out.println(stringSoFar);
            }
            // loops through a square around each letter looking for the correct next letter
            for (int k = i - 1; k < i + 2 && k < board.length; k++) {
                for (int l = j - 1; l < j + 2 && l < board.length; l++) {
                    if (k >= 0 && l >= 0 ) {
                        //DFS on new char
                        DFS(board, TrieNode, k, l, stringSoFar);
                    }
                }
            }
            // add char back to board and erase char from stringSoFar
            board[i][j] = temp;
            stringSoFar.deleteCharAt(stringSoFar.length() - 1);
        }
    }
}
