package com.example.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode { //에러 코드는 Enum으로 관리

    //jwt
    EXPIRED_TOKEN(401 , "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),

    //donation
    DONATION_NOT_FOUNT(404, "Donation not found"),

    //user
    USER_NOT_FOUND(404,"User not found"),
    USER_ALREADY_EXISTS(409,"User already exists"),
    PASSWORD_MISMATCH(401,"Password mismatch"),
    WRITER_MISMATCH(403, "Writer mismatch"),

    //admin
    CODE_MISMATCH(401,"Code mismatch"),
    NOT_ADMIN(403, "Not admin"),

    //image
    IMAGE_UPLOAD_FAIL(400, "Image upload fail"),
    WRONG_IMAGE(400, "Wrong Image"),

    //general
    BAD_REQUEST(400, "Bad request"),
    //잘못된 요청으로써 문법상 오류가 있어서 서버가 요청사항을 이해하지 못하는 경우
    INTERNAL_SERVER_ERROR(500, "Internal server error");
    //서버 내부 오류는 웹 서버가 요청사항을 수행할 수 없을 경우에 발생함

    private final int statusCode;
    private final String message;
}
