package SingletonProtectedClass;

import java.io.Serializable;

/**
 * Created by Oliver Coulson on 21/01/2016.
 */
public class SingletonProtected implements Serializable, Cloneable {

    private SingletonProtected INSTANCE = null;

    private SingletonProtected() {

    }


}
