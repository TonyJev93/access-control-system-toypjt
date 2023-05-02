package com.toy.accesscontrol.visit.application.service;

import com.toy.accesscontrol.visit.application.port.dto.VisitDataCenterDto;
import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;
import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.exception.VisitDataCenterNotFoundException;
import com.toy.accesscontrol.visit.application.port.exception.VisitNotFoundException;
import com.toy.accesscontrol.visit.application.port.in.VisitApplyAfterUseCase;
import com.toy.accesscontrol.visit.application.port.out.LoadDataCenterRepositoryPort;
import com.toy.accesscontrol.visit.application.port.out.LoadVisitRepositoryPort;
import com.toy.accesscontrol.visit.application.port.out.LoadVisitorRepositoryPort;
import com.toy.accesscontrol.visit.application.port.out.VisitSmsSender;
import com.toy.accesscontrol.visit.application.port.out.VisitSmsSender.VisitAppliedSmsSendRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VisitApplyAfterService implements VisitApplyAfterUseCase {

    private final LoadVisitRepositoryPort loadVisitRepositoryPort;
    private final LoadVisitorRepositoryPort loadVisitorRepositoryPort;
    private final LoadDataCenterRepositoryPort loadDataCenterRepositoryPort;
    private final VisitSmsSender visitSmsSender;

    @Override
    public void visitApplied(VisitIdVo visitId) {
        // 방문 조회
        var visit = loadVisitRepositoryPort.findBy(visitId)
                .orElseThrow(() -> new VisitNotFoundException(visitId));

        // 데이터 센터 조회
        var visitDataCenter = loadDataCenterRepositoryPort.findBy(visit.dataCenterId())
                .orElseThrow(() -> new VisitDataCenterNotFoundException(visit.dataCenterId()));

        // 방문자 조회
        var visitors = loadVisitorRepositoryPort.findAllByVisitId(visitId);

        // 방문 신청 완료 SMS 전송
        visitors.forEach(visitor -> sendVisitAppliedSmsWithExceptionIgnore(visitDataCenter, visitor));
    }

    private void sendVisitAppliedSmsWithExceptionIgnore(VisitDataCenterDto visitDataCenter, VisitorDto visitor) {
        try {
            visitSmsSender.sendVisitAppliedSms(
                    new VisitAppliedSmsSendRequest(visitDataCenter, visitor)
            );
        } catch (Exception exception) {
            log.error("SMS 전송 실패", exception);
        }
    }
}
