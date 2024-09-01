package ahmad.exceptions.event;

import ahmad.exceptions.AhmadException;

public class EventEmptyNameException extends AhmadException {
    public EventEmptyNameException() {
        super("Name should not be empty");
    }
}
