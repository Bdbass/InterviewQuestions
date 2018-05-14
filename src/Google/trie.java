package Google;

public class trie {
    // root node of trie
    Node root = new Node();

    // constructor
    trie(Node _root){
        root = _root;
    }

    //adds a word to the trie
    void Add(String word){
        Node temp = root;
        int i = 0;

        // iterates through nodes in the trie
        while (i < word.length() && temp.children.containsKey(word.charAt(i))){
            i++;
            temp = temp.children.get(word.charAt(i));
        }
        //if the word still has letters left, then we want to add those to the trie
        while(i < word.length()){
            Node newNode = new Node(word.charAt(i));
            temp.children.put(word.charAt(i), newNode);
            temp = newNode;
        }
        // now we are at the end of the word so set word to high
        temp.word = true;
    }

    // returns the node of a letter if it exists, or null if not
    Node SubString(Node start, char letter){
        if (start.children.containsKey(letter)) return start.children.get(letter);
        return null;
    }

    // Prints a trie
    void PrintTrie(Node root){
        StringBuilder word = new StringBuilder();
        PrintHelper(root, word);
    }

    //does all the hard work of printing a trie
    private void PrintHelper(Node current, StringBuilder stringSoFar){
        if (current.word){
            System.out.println(stringSoFar);
        }
        for (char child: current.children.keySet()){
            //choose & explore
            PrintHelper(current.children.get(child), stringSoFar.append(child));
            //unchoose
            stringSoFar.deleteCharAt(stringSoFar.length()-1);
        }
    }
}