package com.ankur.inventory.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

@ApiModel
public  class ServiceErrorResponse {
    private static final long serialVersionUID = 3460393119449453747L;

    @ApiModelProperty(dataType = "string", allowableValues = "200,400", value = "description", notes = "notes", allowEmptyValue = false)
    private HttpStatus httpStatus = null;
    private String applicationErrorCode = null;
    private String applicationErrorMessage = null;

    public ServiceErrorResponse() {
    }

    public ServiceErrorResponse(HttpStatus httpStatus, String applicationErrorCode,
                                String applicationErrorMessage) {
        this.httpStatus = httpStatus;
        this.applicationErrorCode = applicationErrorCode;
        this.applicationErrorMessage = applicationErrorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getApplicationErrorCode() {
        return applicationErrorCode;
    }

    public void setApplicationErrorCode(String applicationErrorCode) {
        this.applicationErrorCode = applicationErrorCode;
    }

    public String getApplicationErrorMessage() {
        return applicationErrorMessage;
    }

    public void setApplicationErrorMessage(String applicationErrorMessage) {
        this.applicationErrorMessage = applicationErrorMessage;
    }

}
