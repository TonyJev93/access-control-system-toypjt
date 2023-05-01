package com.toy.accesscontrol.visit.adapter.out.proxy;

import com.toy.accesscontrol.sms.adapter.in.proxy.SmsSenderProxy;
import com.toy.accesscontrol.visit.application.port.out.VisitSmsSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.toy.accesscontrol.sms.adapter.in.proxy.SmsSenderProxy.*;

@Component
@RequiredArgsConstructor
public class VisitSmsSenderClient implements VisitSmsSender {

    private final SmsSenderProxy smsSenderProxy;

    @Override
    public void sendVisitAppliedSms(VisitAppliedSmsSendRequest request) {
        var from = "NHN Cloud 대표번호";
        var to = request.visitor().mobilePhoneNumber().value();
        var contents = "%s님의 방문 신청이 정상적으로 등록 되었습니다.".formatted(request.visitor().name().value());

        smsSenderProxy.send(
                new From(from),
                new To(to),
                new Contents(contents)
        );
    }
}
