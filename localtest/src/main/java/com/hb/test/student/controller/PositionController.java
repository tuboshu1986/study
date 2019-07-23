package com.hb.test.student.controller;

import com.hb.test.student.service.BaseService;
import com.hb.test.student.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/position")
public class PositionController extends BaseController {

    @Autowired
    private PositionService positionService;

    @Override
    public BaseService getService() {
        return positionService;
    }

    @Override
    public String pre() {
        return "position";
    }
}
