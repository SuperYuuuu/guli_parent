package org.hank.servicebase.execptionhandler;


import lombok.extern.slf4j.Slf4j;
import org.hank.commonutils.R;
import org.hank.commonutils.util.ExceptionUtil;
import org.hank.servicebase.exception.MsgException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e) {
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message("执行了顶第异常");
    }

    @ExceptionHandler(MsgException.class)
    @ResponseBody
    public R error(MsgException e) {
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}
