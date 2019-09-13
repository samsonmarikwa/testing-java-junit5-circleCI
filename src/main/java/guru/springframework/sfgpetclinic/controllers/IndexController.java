package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.exceptions.ValueNotFoundException;

public class IndexController {

    public String index(){

        return "index";
    }

    public String oupsHandler(){
        return "notimplemented";
    }

    // if exception is not thrown, then the test oupsHandlerException() would fail.
    // comment out throw new ValueNotFoundException() and uncomment return to test this
    public String oupsHandlerException(){
        throw new ValueNotFoundException();
//        return "";
    }
}
