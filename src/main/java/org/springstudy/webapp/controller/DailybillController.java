package org.springstudy.webapp.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springstudy.entity.Account;
import org.springstudy.entity.AccountExample;
import org.springstudy.entity.Dailybill;
import org.springstudy.enums.AccountTypeEnum;
import org.springstudy.enums.CardTypeEnum;
import org.springstudy.enums.TxTypeEnum;
import org.springstudy.repository.AccountRepository;
import org.springstudy.repository.DailybillRepository;
import org.springstudy.utils.MoneyUtils;
import org.springstudy.webapp.vo.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eric.Mo
 * @since 2018/12/26
 */
@Slf4j
@Controller
@RestController
public class DailybillController extends AbstractController {

    @Autowired
    private DailybillRepository dailybillRepository;

    /**
     * 创建账户,form表单提交
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/dailybill/create", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> create(@ModelAttribute @Valid DailybillVO vo) {
        log.info("创建账单: " + vo);

        Dailybill db = new Dailybill();
        db.setUserId(vo.getUserId());
        db.setTxYear(vo.getTx_year());
        db.setTxMonth(vo.getTx_month());
        db.setTxDate(vo.getTx_date());
        db.setTxType(TxTypeEnum.valueOf(vo.getTx_type()));
        db.setRemark(vo.getRemark());
        db.setAccountId(vo.getAccount_id());
        db.setDrAmount(vo.getDr_amount());
        db.setCrAmount(vo.getCr_amount());

        dailybillRepository.insertSelective(db);

        log.info("创建 {}, id={}", JSON.toJSONString(vo), db.getId());
        return prepareResp(db);
    }


}
