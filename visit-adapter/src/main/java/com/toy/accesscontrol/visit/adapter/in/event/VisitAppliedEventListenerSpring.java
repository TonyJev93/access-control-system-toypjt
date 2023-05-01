package com.toy.accesscontrol.visit.adapter.in.event;

import com.toy.accesscontrol.visit.adapter.out.event.VisitAppliedEvent;
import com.toy.accesscontrol.visit.application.port.in.VisitApplyAfterUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
@Slf4j
public class VisitAppliedEventListenerSpring {

    private final VisitApplyAfterUseCase visitApplyAfterUseCase;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async // Event 비동기 처리
    public void listenAsyncEventAfterCommit(VisitAppliedEvent event) {
        log.info("[방문 신청 완료 Event 발생] 방문 아이디 : {}", event.visitId().value());
        visitApplyAfterUseCase.visitApplied(event.visitId());
    }
}
