package P7_AutocompleteSystem;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        AutocompleteSystem system = new AutocompleteSystem();

        system.addQuery("java tutorial");
        system.addQuery("javascript");
        system.addQuery("java download");
        system.addQuery("java tutorial");
        system.addQuery("java interview questions");
        system.addQuery("javascript");

        List<String> suggestions = system.search("jav");

        System.out.println("Suggestions for 'jav':");
        for (String s : suggestions) {
            System.out.println(s);
        }
    }
}