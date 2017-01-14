package tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AutoComplete {
    public class Trie {

        private TrieNode rootNode;

        public Trie() {
            super();
            rootNode = new TrieNode(' ');
        }

        public void load(String phrase) {
            loadRecursive(rootNode, phrase + "$");
        }

        private void loadRecursive(TrieNode node, String phrase) {
            if (phrase == null || phrase.isEmpty()) {
                return;
            }
            char firstChar = phrase.charAt(0);
            node.add(firstChar);
            TrieNode childNode = node.getChildNode(firstChar);
            if (childNode != null) {
                loadRecursive(childNode, phrase.substring(1));
            }
        }

        public boolean matchPrefix(String prefix) {
            TrieNode matchedNode = matchPrefixRecursive(rootNode, prefix);
            return (matchedNode != null);
        }

        private TrieNode matchPrefixRecursive(TrieNode node, String prefix) {
            if (prefix == null || prefix.isEmpty()) {
                return node;
            }
            char firstChar = prefix.charAt(0);
            TrieNode childNode = node.getChildNode(firstChar);
            if (childNode == null) {
                // no match at this char, exit
                return null;
            } else {
                // go deeper
                return matchPrefixRecursive(childNode, prefix.substring(1));
            }
        }

        public List<String> findCompletions(String prefix) {
            TrieNode matchedNode = matchPrefixRecursive(rootNode, prefix);
            List<String> completions = new ArrayList<String>();
            findCompletionsRecursive(matchedNode, prefix, completions);
            return completions;
        }

        private void findCompletionsRecursive(TrieNode node, String prefix,
                                              List<String> completions) {
            if (node == null) {
                // our prefix did not match anything, just return
                return;
            }
            if (node.getNodeValue() == '$') {
                // end reached, append prefix into completions list. Do not
                // append
                // the trailing $, that is only to distinguish words like ann
                // and anne
                // into separate branches of the tree.
                completions.add(prefix.substring(0, prefix.length() - 1));
                return;
            }
            Collection<TrieNode> childNodes = node.getChildren();
            for (TrieNode childNode : childNodes) {
                char childChar = childNode.getNodeValue();
                findCompletionsRecursive(childNode, prefix + childChar,
                        completions);
            }
        }

        public String toString() {
            return "Trie:" + rootNode.toString();
        }
    }

    // TrieNode.java
    public class TrieNode {

        private Character character;
        private HashMap<Character, TrieNode> children;

        public TrieNode(char c) {
            super();
            this.character = new Character(c);
            children = new HashMap<Character, TrieNode>();
        }

        public char getNodeValue() {
            return character.charValue();
        }

        public Collection<TrieNode> getChildren() {
            return children.values();
        }

        public Set<Character> getChildrenNodeValues() {
            return children.keySet();
        }

        public void add(char c) {
            if (children.get(new Character(c)) == null) {
                // children does not contain c, add a TrieNode
                children.put(new Character(c), new TrieNode(c));
            }
        }

        public TrieNode getChildNode(char c) {
            return children.get(new Character(c));
        }

        public boolean contains(char c) {
            return (children.get(new Character(c)) != null);
        }

        public int hashCode() {
            return character.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof TrieNode)) {
                return false;
            }
            TrieNode that = (TrieNode) obj;
            return (this.getNodeValue() == that.getNodeValue());
        }

        public String toString() {
            return character + "";
        }
    }

    public Trie constrBigDict() {
        Trie t = new Trie();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./bigdict.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                t.load(line);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return t;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AutoComplete a = new AutoComplete();
        Trie t = a.constrBigDict();
        System.out.println(t.findCompletions("a"));
    }

}
