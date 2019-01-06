package org.springstudy.webapp.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springstudy.MessageCode;
import org.springstudy.entity.User;
import org.springstudy.repository.UserRepository;
import org.springstudy.webapp.vo.Resp;
import org.springstudy.webapp.vo.UserQueryVO;
import org.springstudy.webapp.vo.UserUpdateVO;
import org.springstudy.webapp.vo.UserVO;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author Eric.Mo
 * @since 2018/12/26
 */
@Slf4j
@Controller
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 创建用户
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/user/create", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Long> create(@RequestBody @Valid UserVO userVO) {
        log.info("health_check: ok");

        User user = new User();
        user.setUsername(userVO.getUsername());
        user.setUserMobileNo(userVO.getUserMobileNo());
        user.setUserEmail(userVO.getUserEmail());
        user.setRemark("");
        user.setRemark2("");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        userRepository.insertSelective(user);

        log.info("创建 {}, id={}", JSON.toJSONString(userVO), user.getId());
        return new ResponseEntity<Long>(user.getId(), HttpStatus.OK);
    }

    /**
     * 创建用户
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/user/queryById", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> queryById(@RequestBody @Valid UserQueryVO userVO) {
        log.info("health_check: ok");

        User user = userRepository.selectByPrimaryKey(userVO.getId());
        return prepareResp(user);

    }

    /**
     * 创建用户
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/user/deleteById", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Boolean> deleteById(@RequestBody @Valid UserQueryVO userVO) {
        log.info("health_check: ok");

        int result = userRepository.deleteByPrimaryKey(userVO.getId());
        return new ResponseEntity<Boolean>(result > 0, HttpStatus.OK);
    }

    /**
     * json 提交用@RequestBody
     *
     * @param userVO
     * @return result
     */
    @RequestMapping(value = "/user/updateById", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> updateById(@RequestBody @Valid UserUpdateVO userVO) {
        log.info("updateById: " + userVO.toString());

        User user = new User();
        user.setId(userVO.getId());
        user.setUsername(userVO.getUsername());
        user.setUserMobileNo(userVO.getUserMobileNo());
        user.setUserEmail(userVO.getUserEmail());
        user.setRemark(userVO.getRemark());
        user.setRemark2(userVO.getRemark2());

        int result = userRepository.updateByPrimaryKeySelective(user);

        return prepareResp(result > 0);
    }

    /**
     * form 表单提交@ModelAttribute
     *
     * @param userVO
     * @return result
     */
    @RequestMapping(value = "/user/updateByIdAsForm", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> updateByIdAsForm(@ModelAttribute @Valid UserUpdateVO userVO) {
        log.info("updateByIdAsForm: " + userVO.toString());

        User user = new User();
        user.setId(userVO.getId());
        user.setUsername(userVO.getUsername());
        user.setUserMobileNo(userVO.getUserMobileNo());
        user.setUserEmail(userVO.getUserEmail());
        user.setRemark(userVO.getRemark());
        user.setRemark2(userVO.getRemark2());

        int result = userRepository.updateByPrimaryKeySelective(user);

        return prepareResp(result > 0);
    }

    private ResponseEntity<Resp> prepareResp(Object result) {
        Resp resp = new Resp(MessageCode.success, result);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
