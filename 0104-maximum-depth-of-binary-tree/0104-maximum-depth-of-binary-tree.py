# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        que = deque([root])
        maxDepth = 0
        while que:
            maxDepth += 1
            for _ in range(len(que)):
                current = que.popleft()
                if current.left :
                    que.append(current.left)

                if current.right:
                    que.append(current.right)


        return maxDepth

        