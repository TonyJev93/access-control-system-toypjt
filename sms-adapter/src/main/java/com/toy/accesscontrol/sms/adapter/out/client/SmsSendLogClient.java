package com.toy.accesscontrol.sms.adapter.out.client;

import com.toy.accesscontrol.sms.application.port.dto.ContentsVo;
import com.toy.accesscontrol.sms.application.port.dto.FromVo;
import com.toy.accesscontrol.sms.application.port.dto.ToVo;
import com.toy.accesscontrol.sms.application.port.out.SmsSendClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsSendLogClient implements SmsSendClient {
    @Override
    public void send(FromVo from, ToVo to, ContentsVo contents) {
        log.info("Send SMS by SMS Send Log Client > from: {}, to: {}, contents: {}", from.value(), to.value(), contents.value());
    }
}
