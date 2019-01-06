package org.springstudy.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric.Mo
 * @since 2018/12/26
 */
@Slf4j
@Controller
@RestController
public class HelloController {

    @RequestMapping(value = "/health_check", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> healthCheck() {
        log.info("health_check: ok");
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @RequestMapping(value = "/2/health_check", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> healthCheck2() {
        log.info("health_check: ok");
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @RequestMapping(value = "/log", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<String> log() {
        log.debug("debug: ok");
        log.info("info: ok");
        log.warn("warn: ok");
        log.error("error: ok");
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }
}
