package com.toy.accesscontrol.visit.adapter.in.api;

import com.toy.accesscontrol.visit.adapter.in.api.dto.VisitResponse;
import com.toy.accesscontrol.visit.application.port.in.VisitApplyUseCase;
import com.toy.accesscontrol.visit.application.port.in.VisitApplyUseCase.VisitApplyRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/visit")
@RequiredArgsConstructor
public class VisitApplyController {

    private final VisitApplyUseCase visitApplyUseCase;

    @PostMapping("/apply")
    public VisitResponse visitApply(@Valid @RequestBody VisitApplyRequestDto request) {
        var response = visitApplyUseCase.visitApply(request);
        return VisitResponse.from(response);
    }
}