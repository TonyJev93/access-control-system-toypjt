package com.toy.accesscontrol.sms.adapter.in.proxy;

import com.toy.accesscontrol.sms.application.port.dto.ContentsVo;
import com.toy.accesscontrol.sms.application.port.dto.FromVo;
import com.toy.accesscontrol.sms.application.port.dto.ToVo;
import com.toy.accesscontrol.sms.application.port.in.SmsSenderUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@RequiredArgsConstructor
@Validated
@Slf4j
public class SmsSenderProxy {

    private final SmsSenderUseCase smsSenderUseCase;

    public void send(
            @Valid @NotNull From from,
            @Valid @NotNull To to,
            @Valid @NotNull Contents contents
    ) {
        smsSenderUseCase.send(
                new FromVo(from.value),
                new ToVo(to.value),
                new ContentsVo(contents.value)
        );
    }

    public record From(@NotEmpty String value) {
    }

    public record To(
            @NotEmpty
            @Pattern(regexp = REG_MOBILE_PHONE)
            String value
    ) {
        private static final String REG_MOBILE_PHONE = "01\\d{1}-\\d{4}-\\d{4}$";
    }

    public record Contents(
            @NotEmpty
            @Length(max = LENGTH_MAX)
            String value
    ) {
        public static final int LENGTH_MAX = 160;
    }
}
