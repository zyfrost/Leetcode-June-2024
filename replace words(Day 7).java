class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trieRoot = buildTrie(dictionary);
        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(getShortestReplacement(word, trieRoot)).append(" ");
        }

        // Remove the trailing space
        return result.toString().trim();
    }

    private static String getShortestReplacement(String word, TrieNode root) {
        TrieNode currentNode = root;
        StringBuilder prefix = new StringBuilder();

        for (char c : word.toCharArray()) {
            prefix.append(c);
            if (currentNode.children[c - 'a'] != null) {
                if (currentNode.children[c - 'a'].isWord) {
                    return prefix.toString();
                }
                currentNode = currentNode.children[c - 'a'];
            } else {
                return word;
            }
        }

        return word;
    }

    private static TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode currentNode = root;
            for (char c : word.toCharArray()) {
                if (currentNode.children[c - 'a'] == null) {
                    currentNode.children[c - 'a'] = new TrieNode();
                }
                currentNode = currentNode.children[c - 'a'];
            }
            currentNode.isWord = true;
        }
        return root;
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}
 
