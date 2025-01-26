package com.feed.feedfinal.stark;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

@Service
public class AnalysisService {

    private final ExecutorService executorService;

    public AnalysisService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public List<AnalyzedData> analyzeData(List<DataAnalysisRequest> requests) {
        List<Callable<AnalyzedData>> tasks = new ArrayList<>();

        for (DataAnalysisRequest request : requests) {
            tasks.add(() -> performAnalysis(request));
        }

        try {
            List<Future<AnalyzedData>> futures = executorService.invokeAll(tasks);
            List<AnalyzedData> results = new ArrayList<>();
            for (Future<AnalyzedData> future : futures) {
                results.add(future.get());
            }
            return results;
        } catch (Exception e) {
            throw new RuntimeException("Error during data analysis", e);
        }
    }

    private AnalyzedData performAnalysis(DataAnalysisRequest request) {
        try {
            // Simula el análisis de datos
            Thread.sleep(2000); // Simula un procesamiento costoso
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return new AnalyzedData(request.getInput(), "Processed " + request.getInput());
    }
}

