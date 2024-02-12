class KeyLogger:
    def getPwd(self, inputString):
        left = []
        right = []

        for char in inputString:
            if char == "<":
                if left :
                    right.append(left.pop())
            elif char == ">":
                if right :
                    left.append(right.pop())
            elif char == "-":
                if left:
                    left.pop()
            else:
                left.append(char)

        print(''.join(left)+''.join(reversed(right)))

keyLogger = KeyLogger()
t = int(input())
for i in range(t):
    inputString = input()
    keyLogger.getPwd(inputString)