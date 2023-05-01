package com.toy.accesscontrol.visit.application.port.dto.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import com.toy.accesscontrol.visit.application.port.dto.VisitorDto;

import java.util.List;

public record Visitors(@JsonValue List<VisitorDto> values) {
    public static Visitors from(List<VisitorDto> visitors) {
        return new Visitors(visitors);
    }
}
