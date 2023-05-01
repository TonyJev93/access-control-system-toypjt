package com.toy.accesscontrol.visit.application.port.in;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface VisitApplyAfterUseCase {
    void visitApplied(@Valid @NotNull VisitIdVo visitId);
}
