package com.packt.cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


// Instead of the @SpringBootTest annotation,
// the @DataJpaTest can be used if the test focuses only on JPA components.

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    //TestEntityManager is used to handle the persist entities and it is designed to be used in testing.
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    //A new car object is created and saved to the database
    // with the persistAndFlush method provided by TestEntityManager.
    // Then, we check that the car ID cannot be null if it is saved successfully.
    // The following source code shows the test case method.

    @Test
    public void saveCar(){
        Owner owner = new Owner("Alex", "Johnson");
        ownerRepository.save(owner);
        Car car = new Car("Tesla", "Model X", "White", "ABC-1234", 2017, 86000,owner);
        entityManager.persistAndFlush(car);
        assertThat(car.getId()).isNotNull();
    }
    @Test
    public void deleteCars(){
        Owner owner = new Owner("Alex", "Johnson");
        ownerRepository.save(owner);
        entityManager.persistAndFlush(new Car("Tesla", "Model X", "White",
                "ABC-1234", 2017, 86000,owner));
        entityManager.persistAndFlush(new Car("Mini", "Cooper", "Yellow",
                "BWS-3007", 2015, 24500,owner));
        carRepository.deleteAll();
        assertThat(carRepository.findAll()).isEmpty();
    }
}
