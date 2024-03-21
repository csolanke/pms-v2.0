package com.learnwithchandra.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.learnwithchandra.entities.Stock;
import com.learnwithchandra.repository.StockRepository;

@ExtendWith(MockitoExtension.class)
class StockServiceTest {

    @Mock
    private StockRepository stockRepositoryMock;

    @InjectMocks
    private StockService stockService;

    @Rule
   public WireMockRule wireMockRule = new WireMockRule(8080); // Assuming WireMock is running on port 808

    @Test
    void testAddStock() {
        // Create a mock Stock object
        Stock stock = new Stock(/* constructor arguments */);

        // Mocking behavior of StockRepository
        when(stockRepositoryMock.save(stock)).thenReturn(stock);

        // Invoke the method under test
        Stock result = stockService.addStock(stock);

        // Verify that StockRepository's save method was called with correct argument
        verify(stockRepositoryMock, times(1)).save(stock);

        // Verify the result
        assertNotNull(result);
        // Add more assertions as needed
    }
}
