import java.util.Scanner;

public class Main {
    private static final String DIR_LOADED = "City directory restored successfully.\n";
    private static final String DIR_NOT_EXIST = """
            City directory not found.
            Creating an empty city directory.
            """;

    //commands
    private static final String HELP_CMD = "help";
    private static final String ADD_CITY = "addCity";
    private static final String REM_CITY = "removeCity";
    private static final String POPULATION = "population";
    private static final String LIST_CITIES = "listCities";
    private static final String QUIT = "quit";

    //msgs
    private static final String HELP_MSG = """
            addCity: Adds a new city to the directory.
            removeCity: Removes an existing city from the directory.
            population: Returns the number of inhabitants of a city.
            listCities: Lists all cities currently stored in the directory.
            help: Displays the list of available commands.
            quit: Terminates the application.
            """;
    private static final String ADD_MSG = "City successfully added.\n";
    private static final String CITY_EXISTS = "City already exists.\n";
    private static final String REM_MSG = "City successfully removed.\n";
    private static final String CITY_NOT_FOUND = "City not found.\n";
    private static final String POP_MSG = "Population: %d\n";
    private static final String LIST_MSG = "%s - %s - %s\n";
    private static final String EMPTY = "No cities available.\n";
    private static final String QUIT_MSG = """
            City directory saved.
            Goodbye.
            """;
    private static final String UNKNOWN_CMD = "Unknown command. Type help to see available commands.\n" ;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        commands(in);
        in.close();
    }
    private static void commands(Scanner in) {
        CityDirectory cd = new CityDirectoryClass();
        String cmd;
        do{
            cmd = in.next();
            switch (cmd){
                case HELP_CMD -> System.out.println(HELP_MSG);
                case ADD_CITY -> addCity(in,cd);
                case REM_CITY -> removeCity(in,cd);
                case POPULATION -> populationCmd (in,cd);
                case LIST_CITIES -> listCitiesCmd (cd);
                case QUIT -> System.out.println(QUIT_MSG);
                default -> System.out.printf(UNKNOWN_CMD);
            }
        } while (!cmd.equals(QUIT));

    }

    private static void listCitiesCmd(CityDirectory cd) {
        System.out.printf(LIST_MSG, , , );
        System.out.println(EMPTY);
        
    }

    private static void populationCmd(Scanner in, CityDirectory cd) {
        String cityName = in.nextLine();
        String country = in.nextLine();
        if(cd.hasCity(cityName,country)){
            System.out.printf(POP_MSG,cd.getPopulation(cityName,country));
        }else
            System.out.printf(CITY_NOT_FOUND);
    }

    private static void removeCity(Scanner in, CityDirectory cd) {
        String cityName = in.nextLine();
        String country = in.nextLine();
        if(cd.hasCity(cityName,country)) {
            System.out.printf(REM_MSG);
            cd.removeCity(cityName,country);
        }else
            System.out.printf(CITY_NOT_FOUND);
    }

    private static void addCity(Scanner in, CityDirectory cd) {
        String cityName = in.nextLine();
        String country = in.nextLine();
        int population = in.nextInt();
        in.nextLine();
        if(!cd.hasCity(cityName,country)){
            System.out.printf(ADD_MSG);
            cd.addCity(cityName,country,population);
        }else
            System.out.printf(CITY_EXISTS);
    }
}
