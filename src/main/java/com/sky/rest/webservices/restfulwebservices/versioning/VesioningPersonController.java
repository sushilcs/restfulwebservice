package com.sky.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VesioningPersonController {
    @GetMapping("v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        PersonV2 personV2 = new PersonV2(new Name("Boo", "charlie"));
        return personV2;
    }

    @GetMapping(path = "/person",params = "v1")
    public PersonV1 getFirstVersionOfPersonReqeustParam(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person",params = "v2")
    public PersonV2 getSecondVersionOfPersonRequestParam(){
        PersonV2 personV2 = new PersonV2(new Name("Boo", "charlie"));
        return personV2;
    }

    @GetMapping(path = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonReqeustParamrrRequestHeader(){
        return new PersonV1("Bob Charlie");
    }


    @GetMapping(path = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader(){
        PersonV2 personV2 = new PersonV2(new Name("Boo", "charlie"));
        return personV2;
    }

    @GetMapping(path = "/person/header",produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonReqeustParamrAcceptheader(){
        return new PersonV1("Bob Charlie");
    }


    @GetMapping(path = "/person/header",produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonRequestAcceptHeader(){
        PersonV2 personV2 = new PersonV2(new Name("Boo", "charlie"));
        return personV2;
    }
}
