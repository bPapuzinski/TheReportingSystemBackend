package com.reportingSystem.controller;

import com.reportingSystem.dto.ReplayDto;
import com.reportingSystem.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report/{id}/replay")
public class ReplayController {

    @Autowired
    ReplayService replayService;

    @PostMapping
    public ReplayDto addReplay(@PathVariable String id, @RequestBody ReplayDto replayDto) {
        return replayService.addReplayToReport(id, replayDto);
    }

    @PutMapping("/{replayId}")
    public ReplayDto editReplay(@PathVariable String id, @RequestBody ReplayDto replayDto, @PathVariable String replayId) {
        return replayService.editReplay(id,replayId, replayDto);
    }
}
