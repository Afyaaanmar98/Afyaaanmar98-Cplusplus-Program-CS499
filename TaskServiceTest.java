/*************************
 * Name: 	Afyaa
 * Course: 	CS-320
 * Date: 	May 14, 2025
 * Description: This is the test class for TaskService.
 *************************/

package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Task.Task;
import Task.TaskService;

class TaskServiceTest {

	/*
	 * These tests validate core functionalities of the TaskService class:
	 * - Adding a task and confirming it's stored.
	 * - Updating task name and description.
	 * - Deleting a task.
	 * 
	 * Each task has a unique taskID, so tests retrieve the task ID dynamically
	 * rather than hardcoding it.
	 */

	@Test
	@DisplayName("Service should add a new task successfully")
	void testAddTask() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");

		Task addedTask = service.taskList.get(0); // Get the newly added task
		assertNotNull(addedTask, "Task was not added.");
		assertEquals("Task Name", addedTask.getTaskName());
		assertEquals("Description", addedTask.getTaskDesc());
	}

	@Test
	@DisplayName("Service should update task name correctly")
	void testUpdateTaskName() {
		TaskService service = new TaskService();
		service.addTask("Initial Name", "Initial Description");

		String taskID = service.taskList.get(0).getTaskID();
		service.updateTaskName("Updated Name", taskID);

		assertEquals("Updated Name", service.getTask(taskID).getTaskName(), "Task name was not updated.");
	}

	@Test
	@DisplayName("Service should update task description correctly")
	void testUpdateTaskDescription() {
		TaskService service = new TaskService();
		service.addTask("Initial Name", "Initial Description");

		String taskID = service.taskList.get(0).getTaskID();
		service.updateTaskDesc("Updated Description", taskID);

		assertEquals("Updated Description", service.getTask(taskID).getTaskDesc(), "Task description was not updated.");
	}

	@Test
	@DisplayName("Service should delete a task successfully")
	void testDeleteTask() {
		TaskService service = new TaskService();
		service.addTask("Name", "Desc");

		String taskID = service.taskList.get(0).getTaskID();
		service.deleteTask(taskID);

		assertNull(service.getTask(taskID), "Task was not deleted.");
		assertTrue(service.taskList.isEmpty(), "Task list is not empty after deletion.");
	}
}
