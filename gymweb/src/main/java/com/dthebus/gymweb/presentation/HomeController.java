/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dthebus.gymweb.presentation;

import com.dthebus.gymweb.domain.members.FullMember;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author darren
 */
@Controller
public class HomeController {
     @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/rest",method = RequestMethod.GET)
    @ResponseBody
    public List<FullMember> getRndex(){
        List<FullMember> fullMember = new ArrayList<>();
        FullMember p1 = new FullMember.Builder("Darren")
                .build();
        FullMember p2 = new FullMember.Builder("Andre")
                .build();
        FullMember p3 = new FullMember.Builder("Rushian")
                .build();
        fullMember.add(p3);
        fullMember.add(p1);
        fullMember.add(p2);
        
        return fullMember;
    }
    
}
