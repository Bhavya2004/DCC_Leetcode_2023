# the input will contain any combination of the words R and D, where R = radiant and D = Dire.
# now the question says that the first character has the right to ban all the rights of next character if 1st and 2nd charcter are different
# but if the 1st and 2nd character are equal,then 1st char cannot ban next's right
# for e.g in RDD,the R will ban right of next char(i.e D) and the last char(i.e D) has no further char present so it will ban the right of 1st char(i.e R) and hence only D remains and it will announce victory.
class Solution:
    def predictPartyVictory(self, senate: str) -> str:
# Define a lambda function that takes a character x ('R' or 'D') and returns a list of indices representing the positions of senators belonging to that party in the input string senate.
        f = lambda x: [i for i, c in enumerate(senate) if c == x]
# Initialize a list A containing two sub-lists.The first sub-list contains the indices of all senators belonging to the Radiant party, and the second sub-list contains the indices of all senators belonging to the Dire party.
        A = [f('R'), f('D')]

# Enter a while loop that continues as long as both sub-lists in A are non-empty.
        while A[0] and A[1]:
# Pop the first senator index from each of the two sub-lists in A and store them in a tuple B.
            B = A[0].pop(0), A[1].pop(0)
# Check whether the index of the Radiant senator in B is greater than the index of the Dire senator in B. If it is, the Radiant senator wins the vote and their index is appended to the Radiant sub-list in A with an offset equal to the length of the input string senate. If the Dire senator wins the vote, their index is appended to the Dire sub-list in A with the same offset.
            t = B[0] > B[1]
            A[t] += [B[t] + len(senate)]

# After all the rounds of voting have been completed, check which sub-list in A is non-empty and return the corresponding party as the winner.
        return "Radiant" if A[0] else "Dire"