package TrafficSimTest;

import TrafficSim.Car;
import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    @Test
    public void test_constr(){
        Car new_car = new Car(1, 2);
        Assert.assertEquals("Car1",new_car.id);
        System.out.println(new_car);
        Assert.assertEquals("Car{position=null, id='Car1', length=2, width=1, speed=1, acceleration=1, currentTerrain=null}", new_car.toString());
        System.out.print("\ntest constructor passed\n");
    }
}
