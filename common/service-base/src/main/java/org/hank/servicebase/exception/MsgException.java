package org.hank.servicebase.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgException extends RuntimeException {

    @ApiModelProperty("状态码")
    private Integer code;

    private String msg;

    @Override
    public String toString() {
        return "MsgException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
