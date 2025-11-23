package com.rad.personservice.model.dto.apiResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@SuperBuilder
@Getter
@Setter
public class GenericResponse<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Message")
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("StatusCode")
    private Integer statusCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Data")
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("accessToken")
    private String accessToken;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("ListData")
    private List<T> listData;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("refreshToken")
    private String refreshToken;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("role")
    private String role;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("userId")
    private Integer userId;

    // Helper method for successful responses
    public static <T> GenericResponse<T> success(String message) {
        return GenericResponse.<T>builder()
                .message(message)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    // Helper method for error responses
    public static <T> GenericResponse<T> error(String message, HttpStatus status) {
        return GenericResponse.<T>builder()
                .message(message)
                .statusCode(status.value())
                .build();
    }
}
