package com.reportingSystem.controller;

import com.reportingSystem.dto.ReplayDto;
import com.reportingSystem.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report/{id}/replay")
public class ReplayController {

    @Autowired
    ReplayService replayService;

    @PreAuthorize("hasAuthority('ROLE_WORKER') or hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ReplayDto addReplay(@PathVariable String id, @RequestBody ReplayDto replayDto) {
        return replayService.addReplayToReport(id, replayDto);
    }

    @PreAuthorize("hasAuthority('ROLE_WORKER') or hasAuthority('ROLE_ADMIN')")
    @PutMapping("/{replayId}")
    public ReplayDto editReplay(@PathVariable String id, @RequestBody ReplayDto replayDto, @PathVariable String replayId) {
        return replayService.editReplay(id,replayId, replayDto);
    }
}
