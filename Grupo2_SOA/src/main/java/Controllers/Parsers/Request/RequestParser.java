/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controllers.Parsers.Request;

/**
 *
 * @author garci
 */
//Envía información
public interface RequestParser<T> {
    public void setObject(T object);
    public void setParams(T params, String option);
    public String parseObject();
    public String parseParams();
}
