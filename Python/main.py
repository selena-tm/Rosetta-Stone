from Tasks.task import Task
from Tasks import tasklist

task_list = tasklist.TaskList()

def print_options():
    print("(l)ist all tasks")
    print("(n)ew task")
    print("(e)dit existing task")
    print("(d)elete task")
    print("(m)ark task as complete")
    print("\n")
    print("(c)lose the program")
    print("\n")
    print("enter the letter of your selection: ")

def get_option():
    option = ""
    while option != "c":
        print_options()
        option = input().strip().lower()
        evaluate_option(option)

def list_tasks(): 
    tasks = task_list.get_tasks()
    
    for index, task in enumerate(task_list.tasks):
        print(f"{index+1}. {task}")

def add_task():
    print("new task creation...")
    name = input("enter the name of your task: ")
    new_task = Task(name)
    task_list.add_task(new_task)

def edit_task():
    pass

def delete_task():
    pass

def complete_task():
    pass


def evaluate_option(option):
    match option:
        case 'l': list_tasks()
        case 'n': add_task()
        case 'e': edit_task()
        case 'd': delete_task()
        case 'm': complete_task()
        case 'c': print('closing program...')
        case _: print('invalid option')

if __name__ == "__main__":
    get_option()

