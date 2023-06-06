package com.toy.accesscontrol.visit.domain;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Visitors {
    private List<Visitor> values;

    public static Visitors from(List<Visitor> visitors) {
        return new Visitors(
                visitors
        );
    }
}
