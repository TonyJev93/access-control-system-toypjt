package com.toy.accesscontrol.visit.adapter.out.event;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import com.toy.accesscontrol.visit.application.port.out.VisitAppliedEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VisitAppliedEventPublisherSpring implements VisitAppliedEventPublisher {
    private final ApplicationEventPublisher publisher;

    @Override
    public void publish(VisitIdVo visitId) {
        publisher.publishEvent(new VisitAppliedEvent(visitId));
    }
}
