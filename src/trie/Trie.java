package trie;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Trie {
    TrieNode root = new TrieNode(0, '\0', null);
    private int numOfNodes = 1;

    public ArrayList<TrieNode> dfs() {
        ArrayList<TrieNode> trieNodes = new ArrayList<>(numOfNodes);
        Stack<TrieNode> stack = new Stack<>();
        TrieNode currentNode = root;
        stack.push(currentNode);
        while (!stack.isEmpty()) {
            for (Map.Entry<Character, TrieNode> entry : currentNode.getChildren().entrySet()) {
                stack.push(entry.getValue());
            }
            currentNode.setRow(trieNodes.size());
            trieNodes.add(currentNode);
            currentNode = stack.pop();
        }

        return trieNodes;
    }

    public int getNumOfNodes() {
        return numOfNodes;
    }

    public void insert(String s) {
        TrieNode current = root;

        for (char l : s.toCharArray()) {
            int depth = current.getDepth();
            TrieNode backup = current;
            current = current.getChildren().computeIfAbsent(l, c -> {
                this.numOfNodes++;
                return new TrieNode(depth + 1, l, backup);
            });
        }
        current.setWord(s);
    }

    public boolean search(String s) {
        TrieNode current = root;

        for (char l : s.toCharArray()) {
            current = current.getChildren().get(l);
            if (current == null)
                return false;
        }
        return true;
    }
}