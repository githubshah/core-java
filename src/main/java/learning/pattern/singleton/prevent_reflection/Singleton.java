package learning.pattern.singleton.prevent_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;
import java.security.Permission;

public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Other methods and fields as needed

    public static void main(String[] args) {
        // Install a SecurityManager
        System.setSecurityManager(new MySecurityManager());
        
        // Attempt to use reflection to access the private constructor
        try {
            Class<Singleton> clazz = Singleton.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true); // Allow access to private constructor
            Singleton newInstance = (Singleton) constructor.newInstance(); // Attempt to create a new instance
            System.out.println("New instance created via reflection: " + newInstance);
        } catch (Exception e) {
            System.out.println("Reflection access denied: " + e);
        }

        // Attempt to access the getInstance() method using reflection
        try {
            Class<Singleton> clazz = Singleton.class;
            Method method = clazz.getDeclaredMethod("getInstance");
            Object result = method.invoke(null); // Invoke static method on null object (since it's static)
            System.out.println("Singleton instance obtained via reflection: " + result);
        } catch (Exception e) {
            System.out.println("Reflection access denied: " + e);
        }
    }
}

// Custom SecurityManager to restrict reflection access
class MySecurityManager extends SecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        // Deny access to reflection API
        if (perm instanceof ReflectPermission) {
            throw new SecurityException("Reflection access is not allowed.");
        }
    }
}
