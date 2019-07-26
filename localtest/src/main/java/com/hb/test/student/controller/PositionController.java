package com.hb.test.student.controller;

import com.hb.test.student.model.Position;
import com.hb.test.student.service.BaseService;
import com.hb.test.student.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Controller
@RequestMapping("/position")
public class PositionController<T extends Position, K extends Integer> extends BaseController<T, K> {

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

    @Override
    public Object emptyBean() {
        return new Position();
    }
}
