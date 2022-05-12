package com.digicamp.controllers;

import com.digicamp.entity.EmailRequest;
import com.digicamp.entity.EmailResponse;
import com.digicamp.entity.OTP;
import com.digicamp.service.EmailAuthenticationService;
import com.digicamp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/OTP")
public class EmailAuthenticationController {
    private static final Logger logger = LogManager.getLogger(EmailAuthenticationController.class);

    @Autowired
    private EmailAuthenticationService emailService;
    @Autowired
    private UserService userService;
    private Map<Double, Integer> idToOtp = new HashMap<>();
    private int min = 100000;
    private int max = 999999;
    @GetMapping("/email/{id}/{email}")
    public String getOTP(@PathVariable double id,@PathVariable String email)
    {
        logger.info("getOTP called!");
        return sendOtpToEmail(id, email);
    }

    @GetMapping("/mobile/{id}/{mobile}")
    public String getOTPByMobile(@PathVariable double id,@PathVariable String mobile)
    {
        logger.info("getOTPByMobile called!");
        String email = userService.getEmailByMobile(mobile);
        if(email==null){
            return "No email is linked from this number! Please register the email.";
        }
        return sendOtpToEmail(id, email);
    }

    @PostMapping("")
    public int verifyOTP(@RequestBody OTP body){
        logger.info("verifyOTP called!");
//        System.out.println(body.getOtp()+" "+body.getId());
        if(idToOtp.containsKey(body.getId())){
//            System.out.println(idToOtp.get(body.getId())+" "+body.getOtp());
            if((int)idToOtp.get(body.getId())==(int)body.getOtp()){
                idToOtp.remove(body.getId());
                return 0;//"Correct OTP"
            }else{
                return 1;//"Incorrect OTP!";
            }
        }else{
            return 2;//"ID not exist";
        }
    }

    public String sendOtpToEmail(double id, String email){
        int otp = (int)Math.floor(Math.random()*(max-min+1)+min);
        idToOtp.put(id, otp);
        
        String name = Character.toUpperCase(email.split(".")[0].charAt(0)) + email.split(".")[0].substring(1).toLowerCase();
        String message= "Welcome " + name + "to DigiCamp.\n Your OTP is: " + otp + "\n Please don't share this OTP with anyone. \n Thanks and Regards \n Team DigiCamp \n IIITB" ;
        EmailRequest request = new EmailRequest(email, "IIITB DigiCamp OTP", message);
        
        boolean result=this.emailService.sendEmail(request.getMessage(), request.getSubject(), request.getTo());
        return "";
    }
}

