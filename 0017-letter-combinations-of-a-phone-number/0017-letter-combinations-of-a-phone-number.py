class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []

        diction = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        combinations = []

        def dfs(index, path):
            if index == len(digits):
                combinations.append(''.join(path))
                return

            current_digit = digits[index]
            chars = diction[current_digit]
            for char in chars:
                path.append(char)
                dfs(index + 1, path)
                path.pop()


        dfs(0,[])
        return combinations
