class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        visiting = set()
        graph = {i:[] for i in range(numCourses)}
        for course, pre in prerequisites:
            graph[course].append(pre)

        def dfs(i):
            if i in visiting:
                return False

            visiting.add(i)
            for pre in graph[i]:
                if not dfs(pre):
                    return False
            visiting.remove(i)
            graph[i] = []
            return True
        
        for i in range(numCourses):
            if not dfs(i):
                return False

        return True