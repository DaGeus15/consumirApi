/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Parsers.Response;

import java.util.ArrayList;

/**
 *
 * @author garci
 */
//Trae información
public interface ResponseParser<T> {
    public ArrayList<T> parseResponses();
    public T parseResponse();
    public boolean parseSuccess() throws Exception;
}
