package observer;

/**
 *
 * @author Yugo
 */
public enum Tipo {
    CLIENTE,
    SERVIDOR;
    
    public static Tipo Integer(int x) {
        switch(x) {
        case 0:
            return CLIENTE;
        case 1:
            return SERVIDOR;
        }
        return null;
    }
};
