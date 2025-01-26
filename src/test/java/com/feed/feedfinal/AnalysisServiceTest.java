package com.feed.feedfinal;

import com.feed.feedfinal.stark.AnalysisService;
import com.feed.feedfinal.stark.AnalyzedData;
import com.feed.feedfinal.stark.DataAnalysisRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalysisServiceTest {

    @InjectMocks
    private AnalysisService analysisService;

    @Mock
    private ExecutorService executorService;

    @BeforeEach
    void setUp() {
        // Inicia los mocks
        MockitoAnnotations.openMocks(this);
        executorService = Executors.newFixedThreadPool(5); // Simula el ExecutorService real
        analysisService = new AnalysisService(executorService);
    }

    @Test
    void testAnalyzeData() {
        // Datos de prueba
        List<DataAnalysisRequest> requests = Arrays.asList(
                new DataAnalysisRequest("Test1"),
                new DataAnalysisRequest("Test2"),
                new DataAnalysisRequest("Test3")
        );

        // Llamada al método a probar
        List<AnalyzedData> results = analysisService.analyzeData(requests);

        // Validación
        assertEquals(3, results.size());
        assertEquals("Processed Test1", results.get(0).getResult());
        assertEquals("Processed Test2", results.get(1).getResult());
        assertEquals("Processed Test3", results.get(2).getResult());
    }
}
