package org.springstudy.webapp.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springstudy.entity.Account;
import org.springstudy.enums.AccountTypeEnum;
import org.springstudy.repository.AccountRepository;
import org.springstudy.webapp.vo.AccountVO;
import org.springstudy.webapp.vo.Resp;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author Eric.Mo
 * @since 2018/12/26
 */
@Slf4j
@Controller
@RestController
public class AccountController extends AbstractController {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * 创建账户,form表单提交
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/account/create", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> create(@ModelAttribute @Valid AccountVO vo) {
        log.info("创建账户: " + vo);

        Account entity = new Account();
        entity.setAccountName(vo.getAccountName());
        entity.setBalance(vo.getBalance());
        entity.setAccountType(AccountTypeEnum.valueOf(vo.getAccountType()));
        entity.setRemark(vo.getRemark());
        entity.setRemark2("");
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());

        accountRepository.insertSelective(entity);

        log.info("创建 {}, id={}", JSON.toJSONString(vo), entity.getId());
        return prepareResp(entity);
    }

}
