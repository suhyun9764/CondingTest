class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        def check_height(node):
            if not node:
                return 0
            
            left_height = check_height(node.left)
            right_height = check_height(node.right)
            
            # 높이 차이가 1을 초과하면 -1을 반환하여 이진 트리가 높이 균형이 아님을 표시
            if left_height == -1 or right_height == -1 or abs(left_height - right_height) > 1:
                return -1
            
            # 높이 균형이 맞으면 더 높은 서브트리의 높이에 1을 더한 값을 반환
            return max(left_height, right_height) + 1
        
        return check_height(root) != -1
