package org.angular.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/facilities")
public class FacilitiesController {

    @RequestMapping("/layout")
    public String getMemberPartialPage(ModelMap modelMap) {
        return "facilities/layout";
    }
    
    @RequestMapping("facilities.json")
    public @ResponseBody String getMemberList() {
    	System.out.println("reached here.");
        return "[{\"name\": \"Moroni\", \"allowance\": 505050505050505050,  \"paid\": true},\n" +
                "{\"name\": \"Tiancum\", \"allowance\": 53,  \"paid\": false},\n" +
                "{\"name\": \"Jacob\", \"allowance\": 27,  \"paid\": false},\n" +
                "{\"name\": \"Nephi\", \"allowance\": 29,  \"paid\": false},\n" +
                "{\"name\": \"Enos\", \"allowance\": 34,  \"paid\": false},\n" +
                "{\"name\": \"Ether\", \"allowance\": 42,  \"paid\": false},\n" +
                "{\"name\": \"Alma\", \"allowance\": 43,  \"paid\": true},\n" +
                "{\"name\": \"Jared\", \"allowance\": 21,  \"paid\": true},\n" +
                "{\"name\": \"Moroni\", \"allowance\": 50,  \"paid\": true},\n" +
                "{\"name\": \"Tiancum\", \"allowance\": 53,  \"paid\": false},\n" +
                "{\"name\": \"Jacob\", \"allowance\": 27,  \"paid\": false},\n" +
                "{\"name\": \"Nephi\", \"allowance\": 29,  \"paid\": false},\n" +
                "{\"name\": \"Enos\", \"allowance\": 34,  \"paid\": false},\n" +
                "{\"name\": \"Ether\", \"allowance\": 42,  \"paid\": false},\n" +
                "{\"name\": \"Alma\", \"allowance\": 43,  \"paid\": true},\n" +
                "{\"name\": \"Jared\", \"allowance\": 21,  \"paid\": true},\n" +
                "{\"name\": \"Moroni\", \"allowance\": 50,  \"paid\": true},\n" +
                "{\"name\": \"Tiancum\", \"allowance\": 53,  \"paid\": false},\n" +
                "{\"name\": \"Jacob\", \"allowance\": 27,  \"paid\": false},\n" +
                "{\"name\": \"Nephi\", \"allowance\": 29,  \"paid\": false},\n" +
                "{\"name\": \"Enos\", \"allowance\": 34,  \"paid\": false},\n" +
                "{\"name\": \"Ether\", \"allowance\": 42,  \"paid\": false},\n" +
                "{\"name\": \"Alma\", \"allowance\": 43,  \"paid\": true},\n" +
                "{\"name\": \"Jared\", \"allowance\": 21,  \"paid\": true},\n" +
                "{\"name\": \"Moroni\", \"allowance\": 50,  \"paid\": true},\n" +
                "{\"name\": \"Tiancum\", \"allowance\": 53,  \"paid\": false},\n" +
                "{\"name\": \"Jacob\", \"allowance\": 27,  \"paid\": false},\n" +
                "{\"name\": \"Nephi\", \"allowance\": 29,  \"paid\": false},\n" +
                "{\"name\": \"Enos\", \"allowance\": 34,  \"paid\": false},\n" +
                "{\"name\": \"Ether\", \"allowance\": 42,  \"paid\": false},\n" +
                "{\"name\": \"Alma\", \"allowance\": 43,  \"paid\": true},\n" +
                "{\"name\": \"Jared\", \"allowance\": 21,  \"paid\": true},\n" +
                "{\"name\": \"Moroni\", \"allowance\": 50,  \"paid\": true},\n" +
                "{\"name\": \"Tiancum\", \"allowance\": 53,  \"paid\": false}]";
    }    
}
