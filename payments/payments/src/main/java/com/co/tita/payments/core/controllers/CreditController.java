package com.co.tita.payments.core.controllers;

import com.co.tita.payments.core.dtos.CreditDto;
import com.co.tita.payments.core.reports.BanksUsersReport;
import com.co.tita.payments.core.reports.CreditDetailReport;
import com.co.tita.payments.core.reports.CreditReport;
import com.co.tita.payments.core.reports.ResponseReport;
import com.co.tita.payments.core.service.credits.CreditService;
import com.co.tita.payments.core.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping("/create")
    public ResponseEntity<ResponseReport> addCredit(@RequestBody CreditDto creditDto){
        ResponseReport responseReport = new ResponseReport<CreditReport>();

        if(null == creditDto){
            responseReport.setMessage("The dto can't be null");
            return new ResponseEntity<>(responseReport,null,HttpStatus.BAD_REQUEST);
        }
        try {
            Long creditId = creditService.saveCredit(creditDto);
            CreditReport creditReport = creditService.getById(creditId);
            responseReport.setMessage("Sucess");
            responseReport.setEntity(creditReport);
            return new ResponseEntity<>(responseReport, null, HttpStatus.CREATED);
        }catch (ParseException pse) {
            responseReport.setMessage("The date: "+ creditDto.getCreditDate()+ " is incorrect");
            return new ResponseEntity<>(responseReport, null, HttpStatus.CREATED);

        }
    }

    @GetMapping("/get.all")
    public ResponseEntity<ResponseReport> getAllCreditsByBankAndUserId(@RequestParam(value = "bankid") Long bankId,@RequestParam(value = "userid") Long userId){
        ResponseReport responseReport = new ResponseReport<>();

        if(null == bankId){
            responseReport.setMessage("The bankid can't be null");
            return new ResponseEntity<>(responseReport,null,HttpStatus.BAD_REQUEST);
        }
        if(null == userId){
            responseReport.setMessage("The userid can't be null");
            return new ResponseEntity<>(responseReport,null,HttpStatus.BAD_REQUEST);
        }


        List<CreditReport> creditReports = creditService.findAllByBankIdAndUser(bankId,userId);
        if(creditReports.isEmpty()){
            responseReport.setMessage("No data found");
            responseReport.setEntity(creditReports);
            return new ResponseEntity<>(responseReport,null,HttpStatus.OK);
        }

        responseReport.setEntity(creditReports);
        responseReport.setMessage("Sucess");
        return new ResponseEntity<>(responseReport,null,HttpStatus.OK);
    }

    @GetMapping("/get.users.all")
    public ResponseEntity<ResponseReport> getAllCreditsByUserId(@RequestParam(value = "userid") Long userId){
        ResponseReport responseReport = new ResponseReport<>();

        if(null == userId){
            responseReport.setMessage("The userid can't be null");
            return new ResponseEntity<>(responseReport,null,HttpStatus.BAD_REQUEST);
        }


        List<CreditReport> creditReports = creditService.findAllByUser(userId);
        if(creditReports.isEmpty()){
            responseReport.setMessage("No data found");
            return new ResponseEntity<>(responseReport,null,HttpStatus.BAD_REQUEST);
        }

        responseReport.setEntity(creditReports);
        responseReport.setMessage("Sucess");
        return new ResponseEntity<>(responseReport,null,HttpStatus.OK);
    }

    @GetMapping("/get.details")
    public ResponseEntity<CreditDetailReport> getAllCreditDetail(@RequestParam(value = "creditid") Long creditiD) throws ParseException {


        if(null == creditiD){
            return new ResponseEntity<>(null,null,HttpStatus.BAD_REQUEST);
        }

        CreditDetailReport creditReports = creditService.getCreditDetail(creditiD);


        return new ResponseEntity<>(creditReports,null,HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<CreditReport> getAllCreditById(@RequestParam(value = "creditid") Long creditId) throws ParseException {
        if(null == creditId){
            return new ResponseEntity<>(null,null,HttpStatus.BAD_REQUEST);
        }
        CreditReport creditReports = creditService.getById(creditId);
        return new ResponseEntity<>(creditReports,null,HttpStatus.OK);
    }

}
