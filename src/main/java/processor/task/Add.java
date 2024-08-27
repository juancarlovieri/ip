package processor.task;

import exceptions.deadline.DeadlineEmptyNameException;
import exceptions.deadline.DeadlineInvalidArgsException;
import exceptions.deadline.DeadlineInvalidTimeException;
import exceptions.event.EventEmptyNameException;
import exceptions.event.EventInvalidArgsException;
import exceptions.event.EventInvalidTimeException;
import exceptions.todo.TodoEmptyNameException;
import response.Response;

import java.util.Arrays;
import java.util.List;

public class Add {
  private static Response process(Task newTask) {
    processor.task.TaskList.addTask(newTask);
    return new Response(java.util.List.of("Got it! I have added:\n  " + newTask + "\n" + "You now have " + TaskList.getTaskCount() + " tasks!"), false, true);
  }

  public static Response todo(String prompt) throws TodoEmptyNameException, DeadlineInvalidArgsException, DeadlineEmptyNameException, EventEmptyNameException, EventInvalidArgsException, DeadlineInvalidTimeException, EventInvalidTimeException {
    final List<String> prompts = Arrays.asList(prompt.split("todo "));
    if (prompts.size() < 2) {
      throw new TodoEmptyNameException();
    }
    final Task newTask = Task.of(TaskType.Todo, prompts.get(1));
    return Add.process(newTask);
  }

  public static Response deadline(String prompt) throws DeadlineEmptyNameException, DeadlineInvalidArgsException, EventEmptyNameException, EventInvalidArgsException, TodoEmptyNameException, DeadlineInvalidTimeException, EventInvalidTimeException {
    final List<String> prompts = Arrays.asList(prompt.split("deadline "));
    if (prompts.size() < 2) {
      throw new DeadlineEmptyNameException();
    }
    final Task newTask = Task.of(TaskType.Deadline, prompts.get(1));
    return Add.process(newTask);
  }

  public static Response event(String prompt) throws DeadlineInvalidArgsException, DeadlineEmptyNameException, EventEmptyNameException, EventInvalidArgsException, TodoEmptyNameException, DeadlineInvalidTimeException, EventInvalidTimeException {
    final List<String> prompts = Arrays.asList(prompt.split("event "));
    if (prompts.size() < 2) {
      throw new EventEmptyNameException();
    }
    final Task newTask = Task.of(TaskType.Event, prompts.get(1));
    return Add.process(newTask);
  }
}
