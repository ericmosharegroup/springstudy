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
import org.springstudy.entity.DailybillExample;
import org.springstudy.entity.MonthlySummary;
import org.springstudy.enums.AccountTypeEnum;
import org.springstudy.enums.CardTypeEnum;
import org.springstudy.enums.TxTypeEnum;
import org.springstudy.repository.AccountRepository;
import org.springstudy.repository.DailybillRepository;
import org.springstudy.service.DailybillService;
import org.springstudy.utils.MoneyUtils;
import org.springstudy.utils.page.Pageable;
import org.springstudy.webapp.dto.PageableReqVO;
import org.springstudy.webapp.dto.PageableRespDTO;
import org.springstudy.webapp.vo.*;
import sun.rmi.runtime.Log;

import javax.smartcardio.Card;
import javax.validation.Valid;
import java.security.PrivateKey;
import java.util.List;

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

    @Autowired
    private DailybillRepository dailybillRepository;

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
    public ResponseEntity<Resp> queryByPage(@ModelAttribute @Valid DailybillVO vo) {
        log.info("创建账单: " + vo);

        PageableRespDTO<DailybillVO> respVO = null;
        respVO.setPageNumber(0);

        return prepareResp(respVO);
    }

    /**
     * 根据账户类型查询所有账户名,form表单提交
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/account/queryMonthlyBill", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> queryMonthlyBill(@ModelAttribute @Valid MonthQueryVO vo) {
        log.info("查询每月账单:" + vo);


        DailybillExample example = new DailybillExample();

        example.createCriteria()
                .andUserIdEqualTo(vo.getUserId())
                .andAccountIdEqualTo(Long.valueOf(vo.getAccountId()));


        Pageable pageable = vo.getPageable();
        List<MonthlySummary> list = dailybillRepository.selectMonthlyByPage(example, pageable);


        PageableRespDTO<MonthlySummary> pageableRespDTO = new PageableRespDTO<>();
        pageableRespDTO.setResults(list);

        int count = dailybillRepository.countMonthlyByExample(example);

        //总数目
        pageableRespDTO.setPageNumber(pageable.getPageNumber());
        pageableRespDTO.setPageSize(pageable.getPageSize());

        pageableRespDTO.setCount((long) count);
        pageableRespDTO.setTotalPage(getTotalPage(count, pageable.getPageSize()));

        return prepareResp(pageableRespDTO);
    }


    private Integer getTotalPage(Integer count, Integer pageSize) {

        if (count % pageSize == 0) {
            return count / pageSize;
        }

        return (count / pageSize) + 1;
    }

    /**
     * 根据账户类型查询所有账户名,form表单提交
     * Integer 是 int 包装类. Integer = int
     * Long 是 long 的包装类
     *
     * @return 用户 id
     */
    @RequestMapping(value = "/account/queryBillByPage", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Resp> queryBillByPage(@ModelAttribute @Valid QueryEachMonthBillVO vo) {
        log.info("查询每日账单:" + vo);


        DailybillExample example = new DailybillExample();

        example.createCriteria()
                .andUserIdEqualTo(vo.getUserId())
                .andAccountIdEqualTo(Long.valueOf(vo.getAccountId()))
                .andTxDateGreaterThanOrEqualTo(vo.getTxMonth()+"01")
                .andTxDateLessThanOrEqualTo(vo.getTxMonth()+"31");

        Pageable pageable = vo.getPageable();
        List<Dailybill> list = dailybillRepository.selectByPage(example, pageable);

        PageableRespDTO<Dailybill> pageableRespDTO = new PageableRespDTO<>();
        pageableRespDTO.setResults(list);

        int count = dailybillRepository.countByExample(example);

        //总数目
        pageableRespDTO.setPageNumber(pageable.getPageNumber());
        pageableRespDTO.setPageSize(pageable.getPageSize());

        pageableRespDTO.setCount((long) count);
        pageableRespDTO.setTotalPage(getTotalPage(count, pageable.getPageSize()));

        return prepareResp(pageableRespDTO);
    }

}
