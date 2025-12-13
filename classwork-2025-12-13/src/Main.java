import cmd.repository.NoteRepository;
import cmd.repository.impl.NoteRepositoryInMemoryImpl;
import cmd.service.NoteService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NoteRepository repository = new NoteRepositoryInMemoryImpl();
        Scanner scanner = new Scanner(System.in);
        NoteService service = new NoteService(repository, scanner);

        while (true) {
            try {
                service.processCommand();
            } catch (Exception e) {
                System.err.println("Error during execution: " + e.getMessage());
            }
        }
    }
}