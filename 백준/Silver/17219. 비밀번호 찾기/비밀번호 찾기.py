class Solution :
    def get_password(self, pwdList:list, target_url:list):
        pwd_collection = {}
        for line in pwdList :
            key, value = line.split(" ")
            pwd_collection[key] = value

        for url in target_url :
            print(pwd_collection[url])



n, m = map(int, input().split())
url_pwd_text = []

for i in range(n):
    url_pwd_text.append(input())

target_url = []
for i in range (m):
    target_url.append(input())

sol = Solution()
sol.get_password(url_pwd_text, target_url)