package java_task_management_system;

import java.util.ArrayList;
import java.util.List;

enum Priority {
    HIGH, MEDIUM, LOW
}

class Task {
    private int id;
    private String description;
    private Priority priority;
    private boolean completed;

    public Task(int id, String description, Priority priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void completeTask() {
        completed = true;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Description: " + description + ", Priority: " + priority + ", Completed: " + completed;
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void completeTask(int taskId) {
        Task task = findTask(taskId);
        if (task != null && !task.isCompleted()) {
            task.completeTask();
        }
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private Task findTask(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }
}

public class task_management_system {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task1 = new Task(1, "Study algorithms and data structures", Priority.HIGH);
        Task task2 = new Task(2, "Create a new Java code", Priority.MEDIUM);
        Task task3 = new Task(3, "Create a new C# code", Priority.LOW);

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        taskManager.completeTask(1);

        taskManager.displayTasks();
    }
}