package FacadePattern;

/**
 * Created by Oliver Coulson on 08/02/2016.
 */
public class FacadeScript {
    public static void main(String[] args) {
        ServerFacade serverFacade = new ServerFacadeImpl();

        serverFacade.startUp();
        serverFacade.shutdown();
    }
}
