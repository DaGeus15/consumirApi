/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.APIs;

import Controllers.Parsers.Request.RequestParser;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author garci
 */
public abstract class API<T> {
    protected String URL;
    protected HttpRequest request;
    protected HttpResponse<String> response;
    protected HttpClient client;
    public abstract void GET() throws Exception;
    public abstract void GET(RequestParser<T> req) throws Exception;
    public abstract void POST(RequestParser<T> req) throws Exception;
    public abstract void PUT(RequestParser<T> req) throws Exception;
    public abstract void DELETE(RequestParser<T> req) throws Exception;
    public abstract String fetchRawData();
}
