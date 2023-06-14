package com.toy.accesscontrol.visit.application.port.dto.mapper;

import com.toy.accesscontrol.visit.application.port.dto.vo.*;

public interface VisitBaseMapper extends
        VisitIdVo.Mapper,
        VisitDataCenterIdVo.Mapper,
        ApplicantUserIdVo.Mapper,
        VisitReasonVo.Mapper,
        RequesterNameVo.Mapper,
        MobilePhoneNumberVo.Mapper,
        EmailAddressVo.Mapper,
        VisitorIdVo.Mapper,
        VisitorNameVo.Mapper,
        CompanyVo.Mapper {
}
