package TrafficSimTest;

import TrafficSim.Bus;
import org.junit.Assert;
import org.junit.Test;

public class BusTest {

    @Test
    public void test_constr(){
        Bus new_bus = new Bus(1, 2);
        Assert.assertEquals("Bus1",new_bus.id);
        System.out.println(new_bus);
        Assert.assertEquals("Bus{position=null, id='Bus1', length=6, width=1, speed=1, acceleration=1, currentTerrain=null}", new_bus.toString());
        System.out.print("\ntest constructor passed\n");
    }
}
