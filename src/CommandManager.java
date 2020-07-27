/**
 * The underlying data structure that handles logic of commands and their
 * arguments.
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 */
public class CommandManager {
    private CityTree ctr;
    
    CommandManager() {
        ctr = new CityTree();
    }

    public String[] evaluate(String command) {
        return new String[0];
    }
}
