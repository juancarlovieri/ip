package ahmad.exceptions.todo;

import ahmad.exceptions.AhmadException;

public class TodoInvalidArgsException extends AhmadException {
  public TodoInvalidArgsException() {
    super("That is not a valid \"todo\" command");
  }
}
