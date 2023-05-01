package com.toy.accesscontrol.sms.application.port.in;

import com.toy.accesscontrol.sms.application.port.dto.ContentsVo;
import com.toy.accesscontrol.sms.application.port.dto.FromVo;
import com.toy.accesscontrol.sms.application.port.dto.ToVo;

public interface SmsSenderUseCase {
    void send(FromVo from, ToVo to, ContentsVo contents);
}
