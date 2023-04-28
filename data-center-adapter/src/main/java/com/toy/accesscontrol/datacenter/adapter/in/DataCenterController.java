package com.toy.accesscontrol.datacenter.adapter.in;


import com.toy.accesscontrol.datacenter.adapter.in.dto.DataCenterCreateRequestDto;
import com.toy.accesscontrol.datacenter.adapter.in.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.in.DataCenterCreateUseCase;
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
public class DataCenterController {

    private final DataCenterCreateUseCase dataCenterCreateUseCase;

    @PostMapping
    public DataCenterDto signUp(@RequestBody DataCenterCreateRequestDto request) {
        var dataCenter = dataCenterCreateUseCase.create(request.toPortRequest());
        return DataCenterDto.from(dataCenter);
    }
}
