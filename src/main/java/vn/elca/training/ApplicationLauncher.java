package vn.elca.training;

import org.springframework.boot.SpringApplication;

/**
 * @author vlp
 *
 */
public class ApplicationLauncher {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationWebConfig.class, args);
        // Get current size of heap in bytes
        long heapSize = Runtime.getRuntime().totalMemory();

        // Get maximum size of heap in bytes. The heap cannot grow beyond this size.// Any attempt will result in an OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        // Get amount of free memory within the heap in bytes. This size will increase // after garbage collection and decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        System.out.println("Heap size: " + heapSize);
        System.out.println("Max heap size: " + heapMaxSize);
        System.out.println("Free heap size: " + heapFreeSize);
    }
}
