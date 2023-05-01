package com.toy.accesscontrol.sms.application.service;

import com.toy.accesscontrol.sms.application.port.dto.ContentsVo;
import com.toy.accesscontrol.sms.application.port.dto.FromVo;
import com.toy.accesscontrol.sms.application.port.dto.ToVo;
import com.toy.accesscontrol.sms.application.port.in.SmsSenderUseCase;
import com.toy.accesscontrol.sms.application.port.out.SmsSendClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsSenderService implements SmsSenderUseCase {

    private final SmsSendClient smsSendClient;

    @Override
    public void send(FromVo from, ToVo to, ContentsVo contents) {
        smsSendClient.send(from, to, contents);
    }
}
