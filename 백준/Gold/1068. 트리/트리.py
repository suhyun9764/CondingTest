from collections import defaultdict, deque




class Solution:
    def make_tree(self, num):
        input_list = list(map(int,input().split(" ")))
        dict = {}
        for i in range (len(input_list)):
            if i == -1:
                continue
            if input_list[i] in dict:
                dict[input_list[i]].append(i)
            else :
                dict[input_list[i]] = [i]

        for i in range (num):
            if i not in dict:
                dict[i] = []
        return dict

    def delete_child(self,i,tree,delete_nums):
        delete_nums.append(i)
        if tree[i] not in delete_nums:
            for child in tree[i]:
                if child not in delete_nums:
                    self.delete_child(child,tree,delete_nums)

        return delete_nums

    def get_result(self,tree,target,total_num):
        queue = deque()
        delete_list = []
        for i in range (0,total_num):
            queue.append(i)

        for i in range(total_num):
            if i == target:
                delete_list = self.delete_child(i, tree, [])
                break

        for i in delete_list:
            if i in tree :
                del tree[i]
            for key, value in tree.items():
                if isinstance(value, list) and i in value:
                    value.remove(i)

        for i in range(total_num):

            if i in tree and len(tree[i])>=1:
                del tree[i]


        answer = len(tree)-1
        return answer








num = int(input())
sol = Solution()
tree = sol.make_tree(num)
delete_node = int(input())
print(sol.get_result(tree,delete_node,num))
