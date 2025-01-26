package com.feed.feedfinal.stark;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stark/analysis")
public class AnalysisController {

    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping
    public List<AnalyzedData> analyzeData(@RequestBody List<DataAnalysisRequest> requests) {
        return analysisService.analyzeData(requests);
    }
}

