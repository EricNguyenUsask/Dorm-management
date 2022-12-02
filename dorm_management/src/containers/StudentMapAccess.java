package containers;

import entities.Student;

import java.util.TreeMap;

public class StudentMapAccess {
    private static TreeMap<String, Student> instance = null;

    private StudentMapAccess() {
    }

    public static TreeMap<String, Student> getInstance() {
        if (instance == null)
            instance = new TreeMap<String, Student>();
        return instance;
    }

}
