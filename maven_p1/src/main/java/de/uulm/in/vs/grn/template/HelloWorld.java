package de.uulm.in.vs.grn.template;

public class HelloWorld {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Hello World");
        } else {
            System.out.printf("Hello %s!%n", String.join(" ", args));
        }
    }
}

