import string

s = input()
count_arr = [-1]*len(string.ascii_lowercase)
for i in range(len(s)):
    idx = ord(s[i])-ord('a')
    if count_arr[idx] == -1:
        count_arr[idx] = i

print(' '.join([str(num) for num in count_arr]))