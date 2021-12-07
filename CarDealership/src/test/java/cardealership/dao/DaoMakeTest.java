package cardealership.dao;

import cardealership.TestApplicationConfiguration;
import cardealership.dto.Contact;
import cardealership.dto.Make;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = TestApplicationConfiguration.class)
public class DaoMakeTest {

    @Autowired
    DaoMake makeDao;

    @Autowired
    DaoVehicle vehicleDao;


    public DaoMakeTest() {
    }

    @BeforeEach
    public void setUp() {
        List<Make> makes = makeDao.getAllMakes();
        for(Make make : makes) {
            makeDao.removeMake(make.getMakeID());
        }
    }


    @Test
    public void testAddGetMake() {
        Make make = new Make();
        make.setVehicleMake("test make");
        Make actualNotNull = makeDao.addMake(make);

        Make make2 = new Make();
        make2.setVehicleMake("test make 2");
        makeDao.addMake(make2);

        List<Make> actualList = makeDao.getAllMakes();
        Make actual = makeDao.getMake(make.getMakeID());

        List<Make> expectedList = new ArrayList<>();
        expectedList.add(make);
        expectedList.add(make2);

        Make expected = make;

        assertNotNull(actualNotNull, "object should not be null");
        assertEquals(expectedList, actualList, "expected and actual should be the same");
        assertEquals(expected, actual, "expected and actual should be the same");
    }


}
