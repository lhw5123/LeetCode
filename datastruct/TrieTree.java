package datastruct;

public class TrieTree {
    private int[][] trie; 
    private boolean[] end;
    private int tot;

    public TrieTree() {

    }

    public void insert(String s) {
        int len = s.length(), p = 1;
        for (int i = 0; i < len; i++) {
            int ch = s.charAt(i) - 'a'; // convert character to number
            if (trie[p][ch] == 0) {
                trie[p][ch] = ++tot;    // save index of current character
            }
            p = trie[p][ch];
        }
        end[p] = true;  // mark word end
    }

    public boolean search(String s) {
        int len = s.length(), p = 1;
        for (int i = 0; i < len; i++) {
            p = trie[p][s.charAt(i) - 'a'];
            if (p == 0) {
                return false;
            }
        }
        return end[p];
    }
}