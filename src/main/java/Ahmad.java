import exceptions.AhmadException;
import processor.Processor;
import response.Response;

import java.util.Scanner;

public class Ahmad {

  private static void startInteraction() {
    final Scanner scanner = new Scanner(System.in);
    while (true) {
      try {
        final String prompt = scanner.nextLine();

        final Processor inst = Parser.parse(prompt);

        final Response response = inst.process(prompt);

        response.getResponse().forEach(Ui::print);

        if (response.shouldExit()) {
          break;
        }

        if (response.checkShouldRecord()) {
          Storage.save(prompt);
        }
      } catch (AhmadException e) {
        Ui.print(e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    final String welcomeMsg = "Hello! I'm Ahmad\nWhat can I do for you?\n\nEnjoy!";
    Ui.print(welcomeMsg);

    Storage.load();

    startInteraction();
  }
}
