package com.toy.accesscontrol.visit.adapter.out.proxy;

import com.toy.accesscontrol.user.adapter.in.proxy.UserRetrieveProxy;
import com.toy.accesscontrol.user.adapter.in.proxy.UserRetrieveProxy.RetrieveId;
import com.toy.accesscontrol.visit.application.port.dto.vo.ApplicantUserIdVo;
import com.toy.accesscontrol.visit.application.port.out.LoadUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserClient implements LoadUserRepository {

    private final UserRetrieveProxy userRetrieveProxy;

    @Override
    public boolean isUserExist(ApplicantUserIdVo id) {
        return userRetrieveProxy.retrieve(RetrieveId.from(id.value()))
                .isPresent();
    }
}
