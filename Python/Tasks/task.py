class Task: 
    def __init__ (self, name):
        self.name = name
        self.completed = False

    def change_name(self, new_name):
        self.name = new_name
    
    def complete(self):
        self.completed = True

    def __str__(self):
        status = "✓" if self.completed else "✗"
        return f"{self.name} [{status}]"
