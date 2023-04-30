package com.toy.accesscontrol.datacenter.adapter.in.api;


import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.in.DataCenterCreateUseCase;
import com.toy.accesscontrol.datacenter.application.port.in.DataCenterCreateUseCase.DataCenterCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/v1/data-center")
@RequiredArgsConstructor
public class DataCenterCreateController {

    private final DataCenterCreateUseCase dataCenterCreateUseCase;

    @PostMapping
    public DataCenterDto create(@RequestBody DataCenterCreateRequestDto request) {
        return dataCenterCreateUseCase.create(request);
    }
}
