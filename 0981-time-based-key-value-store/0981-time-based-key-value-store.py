class TimeMap:
    def __init__(self):
        self.keyStore = {}  # key -> list of [val,timestamp]

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.keyStore:
            self.keyStore[key] = []
        self.keyStore[key].append([value,timestamp])

    def get(self, key: str, timestamp: int) -> str:
        res = ""
        values = self.keyStore.get(key, [])
        left = 0
        right = len(values)-1
        while left<=right:
            mid = (left+right)//2
            midVal, midTime = values[mid]
            if midTime==timestamp:
                return midVal
            elif midTime<timestamp:
                res = midVal
                left = mid + 1
            else:
                right = mid - 1
        return res


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)