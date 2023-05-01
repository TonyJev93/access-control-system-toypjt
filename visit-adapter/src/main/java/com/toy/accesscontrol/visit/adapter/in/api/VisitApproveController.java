package com.toy.accesscontrol.visit.adapter.in.api;

import com.toy.accesscontrol.visit.adapter.in.api.dto.VisitResponse;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.in.VisitApproveUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/visit")
@RequiredArgsConstructor
public class VisitApproveController {

    private final VisitApproveUseCase visitApproveUseCase;

    @PostMapping("/approve/{id}")
    public VisitResponse visitApply(@Valid @PathVariable VisitIdVo id) {
        var response = visitApproveUseCase.visitApprove(id);
        return VisitResponse.from(response);
    }
}