class ListNode:
    def __init__(self, value=0, next=None):
        self.value = value
        self.next = next
    def __repr__(self):
        return f"ListNode({self.value})"
    def __str__(self):
        return str(self.value)
    def to_list(self):

        result = []
        current = self
        while current:
            result.append(current.value)
            current = current.next
        return result
    
    