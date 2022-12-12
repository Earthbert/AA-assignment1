package trie;

import java.util.HashMap;

public class TrieNode {
    private final HashMap<Character, TrieNode> children = new HashMap<>();
    private String word = null;
    private final int depth;
    private final Character character;
    private int row;
    private final TrieNode parent;

    public TrieNode(final int depth, final Character character, final TrieNode parent) {
        this.depth = depth;
        this.character = character;
        this.parent = parent;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public int getDepth() {
        return depth;
    }

    public String getWord() {
        return word;
    }

    public void setWord(final String word) {
        this.word = word;
    }

    public Character getCharacter() {
        return character;
    }

    public int getRow() {
        return row;
    }

    public void setRow(final int row) {
        this.row = row;
    }

    public TrieNode getParent() {
        return parent;
    }
}
