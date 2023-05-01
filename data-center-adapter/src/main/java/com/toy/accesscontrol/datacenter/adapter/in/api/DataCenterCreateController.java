package com.toy.accesscontrol.datacenter.adapter.in.api;


import com.toy.accesscontrol.datacenter.adapter.global.api.DataCenterApiResponse;
import com.toy.accesscontrol.datacenter.application.port.dto.DataCenterDto;
import com.toy.accesscontrol.datacenter.application.port.in.DataCenterCreateUseCase;
import com.toy.accesscontrol.datacenter.application.port.in.DataCenterCreateUseCase.DataCenterCreateRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/data-center")
@RequiredArgsConstructor
public class DataCenterCreateController {

    private final DataCenterCreateUseCase dataCenterCreateUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DataCenterApiResponse<DataCenterDto> create(@Valid @RequestBody DataCenterCreateRequestDto request) {
        return DataCenterApiResponse.of(
                dataCenterCreateUseCase.create(request)
        );
    }
}
