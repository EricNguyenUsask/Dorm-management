package containers;

import entities.Manager;

import java.util.TreeMap;

public class ManagerMapAccess {
    private static TreeMap<String, Manager> instance = null;

    private ManagerMapAccess() {
    }

    public static TreeMap<String, Manager> getInstance() {
        if (instance == null)
            instance = new TreeMap<String, Manager>();
        return instance;
    }

}
