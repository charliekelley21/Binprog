/**
 * The underlying data structure that will represent our cities
 * 
 * @author Barak Finnegan (bjfinn98)
 * @version 2020.07.25
 */
public class City {

    // Setting up private vars
    // Final for there is no edit option for cities in project spec.
    private final String cityName;
    private final int x;
    private final int y;

    /**
     * This is the version 1 of the constructor for the City class.
     * 
     * @param name
     *            name of city
     * @param x
     *            x coordinate of city
     * @param y
     *            y coordinate of city
     */
    public City(String name, int x, int y) {
        this.cityName = name;
        this.x = x;
        this.y = y;
    }


    /**
     * This is the version 2 of the constructor for the City class.
     * 
     * @param name
     *            name of city
     * @param x
     *            x coordinate of city
     * @param y
     *            y coordinate of city
     */
    public City(int x, int y, String name) {
        this(name, x, y);
    }


    /**
     * Needs the variables to be readable, but not writable
     * 
     * @return x coordinate of city
     */
    public int getX() {
        return x;
    }


    /**
     * Needs the variables to be readable, but not writable
     * 
     * @return y coordinate of city
     */
    public int getY() {
        return y;
    }


    /**
     * Needs the variables to be readable, but not writable
     * 
     * @return name of city
     */
    public String getName() {
        return cityName;
    }


    /**
     * The standard equals method for the City class
     * 
     * @return boolean based on whether the object in parameter is equal to this
     *         object
     * @param object
     *            the object to be compare to this object
     */
    public boolean equals(Object other) {
        // In order to invoke this method this object cannot be null
        if (other == null) {
            return false;
        }
        if (!(other instanceof City)) {
            return false;
        }
        City castedOther = (City)other;
        return (this.getX() == castedOther.getX() && this.getY() == castedOther
            .getY() && this.getName().contentEquals(castedOther.getName()));
    }


    /**
     * A standard toString method for the City object.
     * 
     * @return String a String representation of the city obj.
     */
    public String toString() {
        return String.format("%s %d %d", cityName, x, y);
    }


    /**
     * A standard toString method for the City object.
     * 
     * @param reverse
     *            depicts whether coordinates are first or not.
     * @param commas
     *            depicts whether commas or not
     * @return String a String representation of the city obj.
     */
    public String toString(boolean reverse, boolean commas) {
        if (reverse && commas) {
            return String.format("%d, %d, %s", x, y, cityName);
        }
        else if (reverse) {
            return String.format("%d %d %s", x, y, cityName);
        }
        else if (commas) {
            return String.format("%s, %d, %d", cityName, x, y);
        }
        else {
            return toString();
        }
    }
}
