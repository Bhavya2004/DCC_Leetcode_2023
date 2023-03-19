class helperclass:
    def __init__(self):
        self.children = {}
        self.is_word = False

class WordDictionary:
    def __init__(self):
        # initialize the root node of the trie
        self.root = helperclass()

# traverse the trie to add each character of the word to the trie. We start at the root node, and for each character in the word, we check if there is a child node corresponding to that character. If not, we create a new child node for that character. We then move to the child node and repeat the process for the next character. After we have added all the characters, we mark the final node as the end of a word by setting its is_word attribute to True.
    def addWord(self, word: str) -> None:
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = helperclass()
            node = node.children[c]
        node.is_word = True

# perform a depth-first search (DFS) on the trie to find any words that match the search string. We start at the root node and recursively traverse the trie, checking each character of the search string against the corresponding child node of the current node. If the character is a ".", we check all the child nodes of the current node. If we reach the end of the search string and the final node is marked as the end of a word, we return True. Otherwise, we return False.
    def search(self, word: str) -> bool:
        def dfs(node, i):
            if i == len(word):
                return node.is_word
            if word[i] == ".":
                for child in node.children.values():
                    if dfs(child, i+1):
                        return True
            elif word[i] in node.children:
                return dfs(node.children[word[i]], i+1)
            return False
        return dfs(self.root, 0)



# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)