from collections import defaultdict
from typing import List

class Solution:
    def groupAnagrams(self,strs:List[str])->List[List[str]]:
        anagrams = defaultdict(list)

        for word in strs:
            sorted_word = "".join(sorted(word))
            anagrams[sorted_word].append(word)

        answer = list(anagrams.values())
        return answer
