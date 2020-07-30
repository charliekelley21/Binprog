/**
 * The underlying data structure that handles logic of commands and their
 * arguments.
 * 
 * @author Charlie Kelley (charlk21)
 * @version 2020.07.25
 */
public class CommandManager {
    private CityTree ctr;

    /**
     * constructor for the CommandManager class. initializes an empty tree.
     */
    CommandManager() {
        ctr = new CityTree();
    }


    /**
     * Evaluates a command from an input file and utilizes the internal CityTree
     * to store city information.
     * 
     * @param command
     *            command to be evaluated
     * @return a string array of the CommandManager's script response to a given
     *         command
     */
    public String[] evaluate(String command) {
        String[] ans = new String[2];
        ans[0] = ">" + command;
        String[] cmd = command.split(" ");
        int x;
        int y;
        switch (cmd[0]) {
            case "insert":
                x = Integer.parseInt(cmd[1]);
                y = Integer.parseInt(cmd[2]);
                ans[1] = (ctr.insert(new City(cmd[3], x, y)))
                    ? ""
                    : "Record could not be inserted. Invalid location.";
                break;
            case "remove":
                x = Integer.parseInt(cmd[1]);
                y = Integer.parseInt(cmd[2]);
                ans[1] = (ctr.remove(x, y))
                    ? ""
                    : "Record could not be removed. It does not exist.";
                break;
            case "find":
                x = Integer.parseInt(cmd[1]);
                y = Integer.parseInt(cmd[2]);
                City found = ctr.find(x, y);
                ans[1] = (found == null)
                    ? "Record could not be printed.  It does not exist."
                    : found.toString();
                break;
            case "regionsearch":
                x = Integer.parseInt(cmd[1]);
                y = Integer.parseInt(cmd[2]);
                int w = Integer.parseInt(cmd[3]);
                int h = Integer.parseInt(cmd[4]);
                SearchResult sr = ctr.regionSearch(x, y, w, h);
                if (sr == null) {
                    ans[1] = "The specified region is outside the known world.";
                    return ans;
                }
                City[] cities = sr.answers();
                ans = new String[cities.length + 2];
                ans[0] = ">" + command;
                for (int i = 0; i < cities.length; i++) {
                    // need special string formatting, true for reverse, false
                    // for commas
                    ans[i + 1] = cities[i].toString();
                }
                ans[ans.length - 1] = String.format("%d Nodes visited.", sr
                    .nodesVisited());
                break;
            case "print":
                ans[1] = ctr.printTree();
                break;
            default:
                ans[1] = "ERROR! Unrecognized command: " + command;
                break;
        }
        return ans;
    }


    /**
     * Returns the internal cityTree of the CommandManager. Helper method for
     * testing the CommandManager class
     * 
     * @return internal CItyTree
     */
    public CityTree getTree() {
        return ctr;
    }
}
