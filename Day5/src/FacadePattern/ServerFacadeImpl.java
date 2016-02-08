package FacadePattern;

/**
 * Created by Oliver Coulson on 08/02/2016.
 */
public class ServerFacadeImpl implements ServerFacade {
    Server server = new ScheduleServer();
    @Override
    public void startUp() {
        server.startBooting();
        server.readSystemConfigFile();
        server.init();
        server.initializeContext();
        server.initializeListeners();
        server.createSystemObjects();
        System.out.println("Start working......");
        System.out.println("After work done.........");
    }

    @Override
    public void shutdown() {
        server.releaseProcesses();
        server.destroy();
        server.destroySystemObjects();
        server.destroyListeners();
        server.destroyContext();
        server.shutdown();
    }
}
