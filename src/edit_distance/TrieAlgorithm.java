package edit_distance;

import input.Input;
import trie.Trie;
import trie.TrieNode;

import java.util.ArrayList;

public class TrieAlgorithm {
    private static Trie createTrie(String[] dictionary) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        return trie;
    }

    public static ArrayList<EditDistanceOutput> calculateEditDistances(Input input) {
        ArrayList<EditDistanceOutput> foundWords = new ArrayList<>();
        Trie trie = createTrie(input.getDictionary());
        ArrayList<TrieNode> helperArray = trie.dfs();

        String target = input.getTargetWord();
        int[][] dm = new int[trie.getNumOfNodes()][target.length() + 1];

        for (int i = 0; i < trie.getNumOfNodes(); i++) {
            for (int j = 0; j <= target.length(); j++) {
                if (i == 0) {
                    dm[i][j] = j;
                } else if (j == 0) {
                    dm[i][j] = helperArray.get(i).getDepth();
                } else {
                    dm[i][j] = Utils.minEdits(
                            (dm[helperArray.get(i).getParent().getRow()][j - 1] +
                                    Utils.IfSame(helperArray.get(i).getCharacter(), target.charAt(j - 1))), // replace
                            (dm[helperArray.get(i).getParent().getRow()][j] + 1), // delete
                            (dm[i][j - 1] + 1) // insert
                    );
                }
            }
            if (helperArray.get(i).getWord() != null && dm[i][target.length()] <= input.getMaxDistance()) {
                foundWords.add(new EditDistanceOutput(dm[i][target.length()], helperArray.get(i).getWord()));
            }
        }

        return foundWords;
    }
}
