package FacadePattern;

/**
 * Created by Oliver Coulson on 08/02/2016.
 */
public interface Server {

    void startBooting();
    void readSystemConfigFile();
    void init();
    void initializeContext();
    void initializeListeners();
    void createSystemObjects();
    void releaseProcesses();
    void destroy();
    void destroySystemObjects();
    void destroyListeners();
    void destroyContext();
    void shutdown();
}