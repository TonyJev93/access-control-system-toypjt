package com.toy.accesscontrol.sms.application.port.out;

import com.toy.accesscontrol.sms.application.port.dto.ContentsVo;
import com.toy.accesscontrol.sms.application.port.dto.FromVo;
import com.toy.accesscontrol.sms.application.port.dto.ToVo;

public interface SmsSendClient {
    void send(FromVo from, ToVo to, ContentsVo contents);
}
