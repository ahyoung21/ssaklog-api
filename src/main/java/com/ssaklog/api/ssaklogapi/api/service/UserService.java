package com.ssaklog.api.ssaklogapi.api.service;

import com.ssaklog.api.ssaklogapi.api.dto.AddUserRequest;
import com.ssaklog.api.ssaklogapi.api.dto.AddUserTempRequest;
import com.ssaklog.api.ssaklogapi.api.dto.CheckUserOverlapIdRequest;
import com.ssaklog.api.ssaklogapi.api.entity.User;
import com.ssaklog.api.ssaklogapi.api.enums.ErrorCode;
import com.ssaklog.api.ssaklogapi.api.exception.CustomException;
import com.ssaklog.api.ssaklogapi.api.repository.UserRepository;
import com.ssaklog.api.ssaklogapi.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.regex.Pattern;

@Service(value = "userService")
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /* 유효성 검사용 key TODO : 따로 관리해야 할 것 같음 */
    private final String USER_ID_REGEX = "^[a-z0-9_-]{5,20}$";
    private final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$";
    private final String USER_NAME_REGEX = "^(?=.*[가-힣a-zA-z])[가-힣a-zA-z]+$";
    private final String EMAIL_REGEX = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    private final Pattern patternUserId = Pattern.compile(USER_ID_REGEX);
    private final Pattern patternPassword = Pattern.compile(PASSWORD_REGEX);
    private final Pattern patternUserName = Pattern.compile(USER_NAME_REGEX);
    private final Pattern patternEmail = Pattern.compile(EMAIL_REGEX);

    private final String patternDate = "yyyy-MM-dd";

    public User tempAdd(AddUserTempRequest request) {
        return userRepository.save(User
                .builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .userName("test")
                .joinDate(LocalDateTime.now())
                .dormantYn("N")
                .withdrawYn("N")
                .build());
    }

    public User add(AddUserRequest request) {
        validateSignUp(request);
        return null;
    }

    private void validateSignUp(AddUserRequest request) {
        /* 아이디 */
        if (!Optional.ofNullable(request.getUserId()).isPresent()) {
            throw new CustomException(ErrorCode.EMPTY_USER_ID);
        }
        if (!patternUserId.matcher(request.getUserId()).find()) {
            throw new CustomException(ErrorCode.REGEX_USER_ID);
        }
        if (!checkOverlapId(
                CheckUserOverlapIdRequest.builder().userId(request.getUserId()).build())) {
            throw new CustomException(ErrorCode.ALREADY_EXIST_USER_ID);
        }
        /* 비밀번호 */
        if (!Optional.ofNullable(request.getPassword()).isPresent()) {
            throw new CustomException(ErrorCode.EMPTY_PASSWORD);
        }
        if (!Optional.ofNullable(request.getCheckPassword()).isPresent()) {
            throw new CustomException(ErrorCode.EMPTY_CHECK_PASSWORD);
        }
        if (!request.getPassword().equals(request.getCheckPassword())) {
            throw new CustomException(ErrorCode.DISCORD_PASSWORD);
        }
        if (!patternPassword.matcher(request.getPassword()).find()) {
            throw new CustomException(ErrorCode.REGEX_PASSWORD);
        }
        /* 이름 */
        if (!Optional.ofNullable(request.getUserName()).isPresent()) {
            throw new CustomException(ErrorCode.EMPTY_USER_NAME);
        }
        if (!patternUserName.matcher(request.getUserName()).find()) {
            throw new CustomException(ErrorCode.REGEX_USER_NAME);
        }
        /* 생년월일 */
        if (Optional.ofNullable(request.getBirthDate()).isPresent()) {
            if (!CommonUtil.checkDate(request.getBirthDate(), patternDate)) {
                throw new CustomException(ErrorCode.REGEX_BIRTHDATE);
            }
        }
        /* 이메일 */
        if (!Optional.ofNullable(request.getEmail()).isPresent()) {
            throw new CustomException(ErrorCode.EMPTY_EMAIL);
        }
        if (!patternEmail.matcher(request.getEmail()).find()) {
            throw new CustomException(ErrorCode.REGEX_EMAIL);
        }
        if (!checkOverlapEmail(request.getEmail())) {
            throw new CustomException(ErrorCode.ALREADY_EXIST_EMAIL);
        }
    }

    /**
     * 회원 아이디 중복 체크
     *
     * @param request
     * @return
     */
    public boolean checkOverlapId(CheckUserOverlapIdRequest request) {
        return userRepository.countAllByUserId(request.getUserId()) <= 0;
    }

    /**
     * 회원 이메일 중복 체크
     *
     * @param email
     * @return
     */
    public boolean checkOverlapEmail(String email) {
        return userRepository.countAllByEmail(email) <= 0;
    }

    /**
     * TODO
     * 1. 인증 생성
     * 2. 유효성 테스트
     * 3. 회원 생성
     */

}
