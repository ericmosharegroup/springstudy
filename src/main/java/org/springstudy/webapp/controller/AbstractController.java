package org.springstudy.webapp.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springstudy.MessageCode;
import org.springstudy.webapp.vo.Resp;

/**
 * @author Eric.Mo
 * @since 2019/1/13
 */
@Slf4j
public abstract class AbstractController {

    protected ResponseEntity<Resp> prepareResp(Object result) {
        Resp resp = new Resp(MessageCode.success, result);

        log.info("return \n" + JSON.toJSONString(resp));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
