# Task-Tracker-CLI
This is a simple Command Line Interface Application for keeping track of tasks. You can add, update, delete, change markings, and list all tasks directly from the terminal.

## Commands
* add: Adds a task with a description
* update: Updates a given task with a new description
* delete: Deletes a given task
* mark-in-progress: Marks a given task as in-progress
* mark-done: Marks a given task as done
* list: Lists either all tasks or tasks with a specified status (done, todo, in-progress)

## Running the Program
1. Download `taskcli.jar` to your machine.
2. In your terminal, navigate to where you downloaded the jar file.
   `cd <your file path>`
3. Run the application
   `java -jar taskcli.jar <your command(s)>`

## Usage
```
# Adding tasks
java -jar taskcli.jar add "go to the store"
#Output: Task added successfully (ID: 1)
java -jar taskcli.jar add "get a car wash"
#Output: Task added successfully (ID: 2)
java -jar taskcli.jar add "go to the gym"
#Output: Task added successfully (ID: 3)

# Marking tasks as done or in-progress
java -jar taskcli.jar mark-done 2
# Task marked as done
java -jar taskcli.jar mark-in-progress 1
# Task marked as in-progress

# Listing tasks
java -jar taskcli.jar list
# Output:
go to the store || ID: 1 || Status: in-progress || Created: 05-08-2025 || Last Updated: 05-08-2025
get a car wash || ID: 2 || Status: done || Created: 05-08-2025 || Last Updated: 05-08-2025
go to the gym || ID: 3 || Status: todo || Created: 05-08-2025 || Last Updated: 05-08-2025

java -jar taskcli.jar list done
# Output: get a car wash || ID: 2 || Status: done || Created: 05-08-2025 || Last Updated: 05-08-2025

# Updating a task
java -jar taskcli.jar update 1 "do laundry"
# Output: Task updated successfully

# Deleting a task
java -jar taskcli.jar delete 2
# Output: Task deleted successfully

```
