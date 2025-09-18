import heapq

class TaskManager:

    def __init__(self, tasks: List[List[int]]):
        self.tasks = {}
        self.task_heap = []
        for task in tasks:
            userID, taskID, priority = task
            self.add(userID, taskID, priority)

    def add(self, userId: int, taskId: int, priority: int) -> None:
        self.tasks[taskId] = (priority, userId)
        heapq.heappush(self.task_heap, (-priority, -taskId, userId))

    def edit(self, taskId: int, newPriority: int) -> None:
        if taskId in self.tasks:
            _, userId = self.tasks[taskId]
            self.tasks[taskId] = (newPriority, userId)
            heapq.heappush(self.task_heap, (-newPriority, -taskId, userId))

    def rmv(self, taskId: int) -> None:
        if taskId in self.tasks:
            del self.tasks[taskId]

    def execTop(self) -> int:
        while self.task_heap:
            priority, taskId, userId = heapq.heappop(self.task_heap)
            # check if the task at heap top is a valid task.
            taskId = -taskId
            priority = -priority
            if taskId not in self.tasks:
                continue
            current_priority, current_userId = self.tasks[taskId]
            if current_userId == userId and current_priority == priority:
                del self.tasks[taskId]
                return userId
        
        return -1


# Your TaskManager object will be instantiated and called as such:
# obj = TaskManager(tasks)
# obj.add(userId,taskId,priority)
# obj.edit(taskId,newPriority)
# obj.rmv(taskId)
# param_4 = obj.execTop()