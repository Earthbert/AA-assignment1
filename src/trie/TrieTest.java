package trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TrieTest {
    Trie trie = new Trie();

    @BeforeEach
    public void insert() {
        trie.insert("Ana");
        trie.insert("Andrei");
        trie.insert("Andrei");
        trie.insert("Bucur");
        trie.insert("3239102");
        trie.insert("dsd");
        trie.insert("dsd");
    }

    @Test
    public void dfs() {
        ArrayList<TrieNode> trieNodes = trie.dfs();
    }
}
