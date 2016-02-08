package FacadePattern;

/**
 * Created by Oliver Coulson on 08/02/2016.
 */
public class ScheduleServer implements Server {
    @Override
    public void startBooting() {
        System.out.println("Booting...");
    }

    @Override
    public void readSystemConfigFile() {
        System.out.println("Reading System Config File...");
    }

    @Override
    public void init() {
        System.out.println("Initializing...");
    }

    @Override
    public void initializeContext() {
        System.out.println("Initializing context...");
    }

    @Override
    public void initializeListeners() {
        System.out.println("Initializing listeners...");
    }

    @Override
    public void createSystemObjects() {
        System.out.println("Creating system objects...");
    }

    @Override
    public void releaseProcesses() {
        System.out.println("Releasing processes...");
    }

    @Override
    public void destroy() {
        System.out.println("Destroying...");
    }

    @Override
    public void destroySystemObjects() {
        System.out.println("Destroying system objects...");
    }

    @Override
    public void destroyListeners() {
        System.out.println("Destroying listeners...");
    }

    @Override
    public void destroyContext() {
        System.out.println("Destroying context...");
    }

    @Override
    public void shutdown() {
        System.out.println("Shutting down...");
    }
}
