package com.digicamp.controllers;

import com.digicamp.entity.EmailRequest;
import com.digicamp.entity.EmailResponse;
import com.digicamp.entity.OTP;
import com.digicamp.service.EmailAuthenticationService;
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
    @Autowired
    private EmailAuthenticationService emailService;
//    private Random rand = new Random();
    private Map<Double, Integer> idToOtp = new HashMap<>();

    //
//    public String welcome()
//    {
//        return "hello this is my email api";
//    }

    @GetMapping("/{id}/{email}")
    public String getOTP(@PathVariable double id,@PathVariable String email)
    {
        int min = 100000;
        int max = 999999;
        int otp = (int)Math.floor(Math.random()*(max-min+1)+min);

        idToOtp.put(id, otp);
        EmailRequest request = new EmailRequest(email, "OTP", ""+otp);
        boolean result=this.emailService.sendEmail(request.getMessage(), request.getSubject(), request.getTo());
        if(result)
        {
            System.out.println(request);
//            return ResponseEntity.ok(new EmailResponse("Email sent successfully."));
        }
        else
        {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email not sent..."));
        }

        return "";
    }

    @PostMapping("")
    public int verifyOTP(@RequestBody OTP body){
        System.out.println();
        if(idToOtp.containsKey(body.getId())){
            System.out.println(idToOtp.get(body.getId())+" "+body.getOtp());
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
}
