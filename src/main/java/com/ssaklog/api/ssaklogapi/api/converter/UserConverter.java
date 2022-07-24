package com.ssaklog.api.ssaklogapi.api.converter;

import com.ssaklog.api.ssaklogapi.api.dto.AddUserRequest;
import com.ssaklog.api.ssaklogapi.api.entity.User;
import com.ssaklog.api.ssaklogapi.util.CommonUtil;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    /**
     * 회원가입용 request를 User로 convert
     *
     * @param request
     * @return
     */
    public User signUpRequestToUser(AddUserRequest request) {
        User user = new User(request.getUserId()
                , request.getUserName()
                , CommonUtil.getSha512(request.getPassword())
                , "" // TODO : levelType
                , request.getEmail()
                , request.getBirthDate());
        return user;
    }

}
