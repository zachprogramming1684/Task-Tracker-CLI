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
java -jar taskcli.jar add "go to the store"
java -jar taskcli.jar add "get a car wash"
java -jar taskcli.jar add "go to the gym"
java -jar taskcli.jar mark-done 2
java -jar taskcli.jar list
java -jar taskcli.jar list done
java -jar taskcli.jar update 1 "do laundry"
java -jar taskcli.jar delete 2

```
