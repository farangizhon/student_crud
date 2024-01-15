package uz.pdp;

import uz.pdp.services.StudentService;
import uz.pdp.utils.Input;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome");
        while (true) {
            StudentService.printAll();
            System.out.println("""
                    1 - add
                    2 - delete
                    3 - update""");
        }
    }
}
