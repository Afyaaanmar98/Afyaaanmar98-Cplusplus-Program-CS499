/*************************
 * Name: 	Afyaa
 * Course: 	CS-320
 * Date: 	May 14, 2025
 * Description: This is the test class for Task.
 *************************/

package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Task.Task;

class TaskTest {

	/*
	 * These tests validate the Task class.
	 * - The first three tests ensure field length constraints are enforced:
	 *   - Task ID <= 10 characters
	 *   - Task Name <= 20 characters
	 *   - Task Description <= 50 characters
	 * - The final two tests ensure Task Name and Description are not null.
	 *   Task ID is not tested for null because it's generated automatically and not updateable.
	 */

	@Test
	@DisplayName("Task ID should not exceed 10 characters")
	void testTaskIDLength() {
		Task task = new Task("TestName", "Test description");
		assertTrue(task.getTaskID().length() <= 10, "Task ID exceeds 10 characters.");
	}

	@Test
	@DisplayName("Task Name should not exceed 20 characters")
	void testTaskNameLength() {
		Task task = new Task("OllyOllyOxenFreeOllyOllyOxenFree", "Test description");
		assertTrue(task.getTaskName().length() <= 20, "Task Name exceeds 20 characters.");
	}

	@Test
	@DisplayName("Task Description should not exceed 50 characters")
	void testTaskDescriptionLength() {
		String longDescription = "123456789123456789123456789123456789123456789123456789";
		Task task = new Task("TestName", longDescription);
		assertTrue(task.getTaskDesc().length() <= 50, "Task Description exceeds 50 characters.");
	}

	@Test
	@DisplayName("Task Name should not be null")
	void testTaskNameNotNull() {
		Task task = new Task(null, "Test description");
		assertNotNull(task.getTaskName(), "Task Name is null.");
	}

	@Test
	@DisplayName("Task Description should not be null")
	void testTaskDescriptionNotNull() {
		Task task = new Task("TestName", null);
		assertNotNull(task.getTaskDesc(), "Task Description is null.");
	}
}
