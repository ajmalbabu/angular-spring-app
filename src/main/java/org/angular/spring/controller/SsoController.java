package org.angular.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/sso")
public class SsoController {
	
    @RequestMapping("/fetchSsoAuthCookie")
    public @ResponseBody String returnSsoAuthCookie(ModelMap modelMap) {
        return "H4TR56TYUI";
    }
}
