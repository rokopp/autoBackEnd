package com.example.auto24backend.Service;

import com.example.auto24backend.database.CarMark;
import com.example.auto24backend.repository.CarMarkRepository;
import com.example.auto24backend.service.CarMarkService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.junit.Assert.assertEquals;

public class CarMarksTest {

    @Mock
    private CarMarkRepository carMarkRepository;

    @Autowired
    private CarMarkService carMarkServiceUnderTest;

    private CarMark carMark;

    @Before
    public void setUp() {
        initMocks(this);
        carMark = CarMark.builder()
                .id(10L)
                .carMark("Audi")
                .build();

        Mockito.when(carMarkRepository.save(any()))
                .thenReturn(carMark);

        Mockito.when(carMarkRepository.findByCarMark(anyString()))
                .thenReturn(carMark);
    }

    @Test
    public void testSave() {
        String carMark = "Audi";

        CarMark result = carMarkServiceUnderTest.save(CarMark.builder().build());

        assertEquals(carMark, result.getCarMark());

    }




}
