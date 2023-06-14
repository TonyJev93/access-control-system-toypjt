package com.toy.accesscontrol.visit.adapter.in.api;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.in.VisitGetDetailUseCase;
import com.toy.accesscontrol.visit.application.port.in.VisitGetDetailUseCase.VisitDetailView;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/visit")
@RequiredArgsConstructor
public class VisitSearchController {

    private final VisitGetDetailUseCase visitGetDetailUseCase;

    @GetMapping("/{visitId}")
    public VisitDetailView getDetail(@PathVariable VisitIdVo visitId) {
        return visitGetDetailUseCase.getDetail(visitId);
    }
}
