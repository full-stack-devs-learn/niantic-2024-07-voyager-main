package com.niantic.models;

import org.springframework.http.HttpStatus;

public class Error
{
    private int status;
    private String error;
    private String message;

    public Error(HttpStatus status)
    {
        this.status = status.value();
        this.error = status.getReasonPhrase();
    }

    public Error()
    {
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
