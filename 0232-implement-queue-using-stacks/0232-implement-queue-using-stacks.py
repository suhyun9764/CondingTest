class MyQueue:

    def __init__(self):
        self.stack_for_push = []
        self.stack_for_pop = []

    def push(self, x: int) -> None:
        self.stack_for_push.append(x)

    def pop(self) -> int:
        if not self.stack_for_pop:
            while self.stack_for_push:
                self.stack_for_pop.append(self.stack_for_push.pop())

        return self.stack_for_pop.pop()

    def peek(self) -> int:
        if not self.stack_for_pop:
            while self.stack_for_push:
                self.stack_for_pop.append(self.stack_for_push.pop())

        return self.stack_for_pop[-1]

    def empty(self) -> bool:
        return not self.stack_for_push and not self.stack_for_pop

# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()