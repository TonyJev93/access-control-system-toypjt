package com.toy.accesscontrol.visit.adapter.out.persistence.mapper;

import com.toy.accesscontrol.visit.adapter.out.persistence.entity.VisitEntity;
import com.toy.accesscontrol.visit.application.port.dto.VisitDto;
import com.toy.accesscontrol.visit.application.port.dto.mapper.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VisitEntityMapper extends VisitIdVoMapper, VisitDataCenterIdVoMapper, ApplicantUserIdVoMapper, VisitReasonVoMapper, RequesterNameVoMapper, MobilePhoneNumberVoMapper, EmailAddressVoMapper {
    @Mapping(source = "visitPeriod.startDateTime", target = "visitStartDateTime")
    @Mapping(source = "visitPeriod.endDateTime", target = "visitEndDateTime")
    @Mapping(source = "reason", target = "visitReason")
    @Mapping(source = "requester.name", target = "requesterName")
    @Mapping(source = "requester.mobilePhoneNumber", target = "requesterMobilePhoneNumber")
    @Mapping(source = "requester.emailAddress", target = "requesterEmailAddress")
    VisitEntity toEntity(VisitDto dto);

    @Mapping(source = "visitStartDateTime", target = "visitPeriod.startDateTime")
    @Mapping(source = "visitEndDateTime", target = "visitPeriod.endDateTime")
    @Mapping(source = "visitReason", target = "reason")
    @Mapping(source = "requesterName", target = "requester.name")
    @Mapping(source = "requesterMobilePhoneNumber", target = "requester.mobilePhoneNumber")
    @Mapping(source = "requesterEmailAddress", target = "requester.emailAddress")
    VisitDto toDto(VisitEntity entity);
}
