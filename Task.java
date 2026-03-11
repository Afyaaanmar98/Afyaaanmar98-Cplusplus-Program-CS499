/*************************
 * Name:    Afyaa
 * Course:  CS-320
 * Date:    May 20, 2025
 * Description: This is the Task class. It creates and stores task information.
 *************************/

package Task;

import java.util.concurrent.atomic.AtomicLong;

public class Task {
    private final String taskID;
    private String taskName;
    private String taskDesc;
    private static AtomicLong idGenerator = new AtomicLong();

    // Constructor
    public Task(String taskName, String taskDesc) {
        this.taskID = String.valueOf(idGenerator.getAndIncrement());

        if (taskName == null || taskName.isEmpty()) {
            this.taskName = "NULL";
        } else if (taskName.length() > 20) {
            this.taskName = taskName.substring(0, 20);
        } else {
            this.taskName = taskName;
        }

        if (taskDesc == null || taskDesc.isEmpty()) {
            this.taskDesc = "NULL";
        } else if (taskDesc.length() > 50) {
            this.taskDesc = taskDesc.substring(0, 50);
        } else {
            this.taskDesc = taskDesc;
        }
    }

    // Getters
    public String getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    // Setters
    public void setTaskName(String taskName) {
        if (taskName == null || taskName.isEmpty()) {
            this.taskName = "NULL";
        } else if (taskName.length() > 20) {
            this.taskName = taskName.substring(0, 20);
        } else {
            this.taskName = taskName;
        }
    }

    public void setTaskDesc(String taskDesc) {
        if (taskDesc == null || taskDesc.isEmpty()) {
            this.taskDesc = "NULL";
        } else if (taskDesc.length() > 50) {
            this.taskDesc = taskDesc.substring(0, 50);
        } else {
            this.taskDesc = taskDesc;
        }
    }
}
