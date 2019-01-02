package a08;

/**
 *
 * @author Travelle Barrett (A00380824)
 */
public class MyBookAccount {

    public int ID;
    private String name;
    private String location;
    private boolean loggedIn;

    public final int MAX_CHAR = 20;
    private MyBookAccount friend = null;
    private static int numAccounts = 0;
    public String WALL_POST = "(none)";
    public String LATEST_MESSAGE = "(none)";
    public static final String START_FRIEND = null;
    public static final String DEFAULT_LOCATION = "Halifax";
    public static final boolean DEFAULT_LOGGEDIN = false;

    /**
     *
     * @param name
     * @param location
     * @param loggedIn
     */
    public MyBookAccount(String name, String location, boolean loggedIn) {
        numAccounts++;
        this.ID = numAccounts;
        this.name = name;
        this.location = location;
        this.loggedIn = loggedIn;
    }

    /**
     *
     * @param name
     * @param loggedIn
     */
    public MyBookAccount(String name, boolean loggedIn) {
        this(name, DEFAULT_LOCATION, loggedIn);
    }

    /**
     *
     * @param name
     */
    public MyBookAccount(String name) {
        this(name, DEFAULT_LOGGEDIN);
    }

    /**
     *
     * @return
     */
    public static int getNumAccounts() {
        return numAccounts;
    }

    /**
     *
     * @return
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     *
     * @param isLoggedIn
     */
    public void setUserLoggedIn(boolean isLoggedIn) {
        this.loggedIn = isLoggedIn;
    }

    /**
     *
     * @return
     */
    public String getWallPost() {
        return WALL_POST;
    }

    /**
     *
     * @param newPost
     */
    public void setWallPost(String newPost) {
        if (newPost.length() > MAX_CHAR) {
            System.out.println("Cannot update wall post for " + name
                    + ". Post must be 20 characters or less.");
        } else {
            WALL_POST = newPost;
        }

    }

    /**
     *
     * @param to
     * @param message
     */
    public void sendMessage(MyBookAccount to, String message) {
        friend = to;
        if (to.loggedIn != true) {
            System.out.println("Could not post message from " + name
                    + ". " + to.name + " is not logged in!");
            LATEST_MESSAGE = "(none)";
        } else if (to.loggedIn == true) {
            LATEST_MESSAGE = message;
        }
    }

    /**
     *
     * @return
     */
    public MyBookAccount getFriend() {
        return friend;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param newName
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return LATEST_MESSAGE;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        if (friend == null) {
            return "MyBookAccount #" + ID + "{\n    "
                    + name + " in " + location + "\n    "
                    + "About me: " + WALL_POST + "\n    "
                    + "Logged In:" + loggedIn + "\n    ";

        } else {
            return "MyBookAccount #" + ID + "{\n    "
                    + name + " in " + location + "\n    "
                    + "About me: " + WALL_POST + "\n    "
                    + "Logged In:" + loggedIn + "\n    "
                    + "Message from " + friend.name + ": "
                    + LATEST_MESSAGE + ".\n";

        }

    }
}
