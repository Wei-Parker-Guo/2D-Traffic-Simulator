package TrafficSimTest;

import TrafficSim.Main;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    //test instances
    Main new_sim = new Main();

    @Test
    public void test_main(){
        Assert.assertNotNull(new_sim);
        System.out.println("\ntest main passed\n");
    }

    @Test
    public void test_initiate(){
        Assert.assertNotNull(new_sim);
        new_sim.verbose = true;
        new_sim.initiate();
        System.out.println("\ntest initiate passed\n");
    }

    @Test
    public void test_update() {
        Assert.assertNotNull(new_sim);
        new_sim.verbose = true;
        new_sim.update();
        System.out.println("\ntest update passed\n");
    }
}
