/*************************
 * Name: 	Afyaa
 * Course: 	CS-320
 * Date: 	May 20, 2025
 * Description: This is the TaskService class. It maintains tasks and has capabilities
 * for adding, updating, and deleting tasks.
 *************************/

package Task;

import java.util.ArrayList;

public class TaskService {

	// Private list of tasks to ensure encapsulation
	private ArrayList<Task> taskList = new ArrayList<>();

	// Display the full list of tasks to the console for error checking
	public void displayTaskList() {
		for (Task task : taskList) {
			System.out.println("\t Task ID: " + task.getTaskID());
			System.out.println("\t Task Name: " + task.getTaskName());
			System.out.println("\t Task Description: " + task.getTaskDesc());
		}
	}

	// Adds a new task using the Task constructor and assigns it to the list
	public void addTask(String taskName, String taskDesc) {
		Task task = new Task(taskName, taskDesc);
		taskList.add(task);
	}

	// Returns a task object based on the task ID. If not found, prints an error and returns a default task.
	public Task getTask(String taskID) {
		for (Task task : taskList) {
			if (task.getTaskID().equals(taskID)) {
				return task;
			}
		}
		System.out.println("Task ID: " + taskID + " not found.");
		return new Task(null, null);
	}

	// Deletes a task by task ID. If not found, prints an error.
	public void deleteTask(String taskID) {
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getTaskID().equals(taskID)) {
				taskList.remove(i);
				return;
			}
		}
		System.out.println("Task ID: " + taskID + " not found.");
	}

	// Updates the task name if the task is found. Prints an error otherwise.
	public void updateTaskName(String updatedString, String taskID) {
		for (Task task : taskList) {
			if (task.getTaskID().equals(taskID)) {
				task.setTaskName(updatedString);
				return;
			}
		}
		System.out.println("Task ID: " + taskID + " not found.");
	}

	// Updates the task description if the task is found. Prints an error otherwise.
	public void updateTaskDesc(String updatedString, String taskID) {
		for (Task task : taskList) {
			if (task.getTaskID().equals(taskID)) {
				task.setTaskDesc(updatedString);
				return;
			}
		}
		System.out.println("Task ID: " + taskID + " not found.");
	}
}

