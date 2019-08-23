package com.example.demo.modules.controllers;

import com.example.demo.integrations.internal.interfaces.commands.ICommandResult;
import com.example.demo.integrations.internal.interfaces.queries.IQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    //region Fields
    @Autowired
    private HttpServletRequest request;
    //endregion

    //region Methods
    protected String getSessionid() throws IllegalAccessException {
        var sessionId = request.getHeader("sessionId");
        if (sessionId == null)
        {
            throw new IllegalAccessException("Invalid session id");
        }

        return sessionId;
    }

    protected ResponseEntity<?> generateReturnResult(Exception ex)
    {
        return new ResponseEntity<>("An exception has occured", HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<?> generateReturnResult(ICommandResult commandResult)
    {
        var httpStatus = HttpStatus.OK;

        if (!commandResult.isSuccess())
        {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(commandResult, httpStatus);
    }

    protected ResponseEntity<?> generateReturnResult(IQueryResult queryResult)
    {
        var httpStatus = HttpStatus.OK;

        if (queryResult == null)
        {
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(queryResult, httpStatus);
    }
    //endregion
}
