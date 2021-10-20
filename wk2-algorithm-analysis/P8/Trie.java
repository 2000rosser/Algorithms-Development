package P8;

public class Trie{

    // Alphabet size (# of symbols) we pick 26 for English alphabet
    static final int ALPHABET_SIZE = 26;


    // class for P8.Trie node
    public static class TrieNode {
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    // isEndOfWord is true if the node represents end of a word i.e. leaf node
    boolean isEndOfWord;

    public TrieNode(){
        isEndOfWord = false;

        for (int i = 0; i < ALPHABET_SIZE; i++)
            children[i] = null;
        }
        TrieNode getChild(char letter) {
            return children[letter - 'a'];
        }

        // Make a new node in the P8.Trie for a given letter
        void createChild(char letter) {
            children[letter - 'a'] = new TrieNode();
        }

        // Get the flag which checks if a node marks the end of a key
        boolean getIsEndOfWord() {
            return isEndOfWord;
        }

        // Sets the end of word flag for the calling node
        void setEndOfWord(boolean isEndOfWord) {
            this.isEndOfWord = isEndOfWord;
        }
    }

    public static TrieNode root;
    // If not key present, inserts into trie
    // If the key is prefix of P8.Trie node, 
    //  marks leaf node
    public static void insert(String key){

        TrieNode current = root;

        for(char x:key.toCharArray()){
            if(current.getChild(x)==null){
                current.createChild(x);
            }
            current=current.getChild(x);
        }
        current.setEndOfWord(true);

    }

    // Returns true if key presents in trie, else false
    public static boolean search(String key) {
        int level, index;
        int length = key.length();

        TrieNode p = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';

            if (p.children[index] == null) {
                return false;
            }

            p = p.children[index];
        }

        return (p != null && p.isEndOfWord);
    }


    // Driver
    public static void main(String args[]) {

        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};


        String output[] = {"Not present in trie", "Present in trie"};

        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
        insert(keys[i]);


        if(search("book") == true) {
            System.out.println("book --- " + output[1]);
        }
        else{
            System.out.println("book --- " + output[0]);
        }

    // Search for different keys


    }

//end of class
} 