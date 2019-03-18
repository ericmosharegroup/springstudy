package org.springstudy.webapp.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springstudy.entity.Account;
import org.springstudy.entity.Dailybill;
import org.springstudy.enums.AccountTypeEnum;
import org.springstudy.enums.CardTypeEnum;
import org.springstudy.enums.TxTypeEnum;
import org.springstudy.repository.AccountRepository;
import org.springstudy.repository.DailybillRepository;
import org.springstudy.service.DailybillService;
import org.springstudy.utils.MoneyUtils;
import org.springstudy.webapp.dto.PageableReqVO;
import org.springstudy.webapp.dto.PageableRespDTO;
import org.springstudy.webapp.vo.*;

import javax.smartcardio.Card;
import javax.validation.Valid;

/**
 * @author Eric.Mo
 * @since 2018/12/26
 */
@Slf4j
@Controller
@RestController
public class DailybillController extends AbstractController {


    @Autowired
    private DailybillService dailybillService;

    /**
     * 创建账单,form表单提交
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/dailybill/create", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> create(@ModelAttribute @Valid DailybillVO vo) {
        log.info("创建账单: " + vo);


        Object result = dailybillService.addBill(vo);

        return prepareResp(result);
    }


    /**
     * 创建账单,form表单提交
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/dailybill/queryByPage", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> queryByPage(@ModelAttribute @Valid PageableReqVO<DailybillVO> vo) {
        log.info("创建账单: " + vo);

        PageableRespDTO<DailybillVO> respVO = null;
        respVO.setPageNumber(0);

        return prepareResp(respVO);
    }


}
