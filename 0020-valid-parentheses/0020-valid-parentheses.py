class Solution:
    def isValid(self, str: str) -> bool:
        stack = []
        for s in str:
            if s == '(' or s == '[' or s == '{':
                stack.append(s)
            else:
                if not stack:
                    return False
                if s == ')':
                    if stack.pop() != '(':
                        return False
                elif s == ']':
                    if stack.pop() != '[':
                        return False
                elif s == '}':
                    if stack.pop() != '{':
                        return False
        return len(stack)==0

          