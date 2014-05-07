package org.angular.spring.controller;

import java.util.List;

import org.angular.spring.example.model.Member;
import org.angular.spring.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberServiceImpl membersService;

    @RequestMapping("memberlist.json")
    public @ResponseBody List<Member> getMemberList() {
    	System.out.println("member list");
        return membersService.getAllMembers();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody void addMember(@RequestBody Member member) {
        membersService.addMember(member);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody void updateMember(@RequestBody Member member) {
        membersService.updateMember(member);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeMember(@PathVariable("id") Long id) {
        membersService.deleteMemberById(id);
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllMembers() {
        membersService.deleteAll();
    }

    @RequestMapping("/layout")
    public String getMemberPartialPage(ModelMap modelMap) {
    	System.out.println("return layout");
        return "members/layout";
    }
}
