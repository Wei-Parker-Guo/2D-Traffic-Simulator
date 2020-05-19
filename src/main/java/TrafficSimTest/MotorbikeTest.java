package TrafficSimTest;

import TrafficSim.Motorbike;
import org.junit.Assert;
import org.junit.Test;

public class MotorbikeTest {

    @Test
    public void test_constr(){
        Motorbike new_bike = new Motorbike(1, 2);
        Assert.assertEquals("Motorbike1",new_bike.id);
        System.out.println(new_bike);
        Assert.assertEquals("Motorbike{position=null, id='Motorbike1', length=1, width=1, speed=1, acceleration=1, currentTerrain=null}", new_bike.toString());
        System.out.print("\ntest constructor passed\n");
    }
}
