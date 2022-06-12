package effectivejava.chapter8.item55;

import java.util.Optional;
import java.util.stream.Stream;

// Избегайте ненужного использования дополнительного метода isPresent
public class ParentPid {
    public static void main(String[] args) {
        ProcessHandle ph = ProcessHandle.current();

        // Неправильное использование isPresent
        Optional<ProcessHandle> parentProcess = ph.parent();
        System.out.println("Parent PID: " + (parentProcess.isPresent() ?
                String.valueOf(parentProcess.get().pid()) : "N/A"));

        // Эквивалентный (и превосходящий) код с использованием orElse
        System.out.println("Parent PID: " +
                ph.parent().map(h -> String.valueOf(h.pid())).orElse("N/A"));
    }
}