package com.xzy.demo.controller;

import com.xzy.demo.pojo.vo.AccountVO;
import com.xzy.demo.service.AccountService;
import com.xzy.demo.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiazhengyue
 * @since 2021-01-04
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(value = "/insert")
    public boolean insert(@RequestBody AccountVO accountVO) {
        return accountService.insert(accountVO) > 0;
    }

    @PutMapping(value = "/update")
    public boolean updateByPrimaryKey(@RequestBody AccountVO accountVO) {
        return accountService.updateByPrimaryKey(accountVO) > 0;
    }

    @PutMapping(value = "/updateSelective")
    public boolean updateByPrimaryKeySelective(@RequestBody AccountVO accountVO) {
        return accountService.updateByPrimaryKeySelective(accountVO) > 0;
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        return accountService.deleteById(id) > 0;
    }

    @GetMapping(value = "/get/{id}")
    public AccountVO findById(@PathVariable Integer id) {
        return accountService.selectById(id);
    }

    @GetMapping("/accounts")
    public Page<AccountVO> findByQuery(@RequestParam(value = "userName") String userName,
                                       @RequestParam(value = "pageNum") Integer pageNum,
                                       @RequestParam(value = "pageSize") Integer pageSize) {
        return accountService.pageQueryByUserNameLike(userName, pageNum, pageSize);

    }
}
