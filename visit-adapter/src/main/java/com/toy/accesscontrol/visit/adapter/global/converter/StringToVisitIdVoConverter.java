package com.toy.accesscontrol.visit.adapter.global.converter;

import com.toy.accesscontrol.visit.application.port.dto.vo.VisitIdVo;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;

public class StringToVisitIdVoConverter implements Converter<String, VisitIdVo> {

    @Override
    public VisitIdVo convert(@NonNull String value) {
        return VisitIdVo.from(Long.valueOf(value));
    }
}
