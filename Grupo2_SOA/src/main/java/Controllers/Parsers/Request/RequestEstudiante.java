/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Parsers.Request;

import Models.Estudiante;
import com.google.gson.Gson;

/**
 *
 * @author garci
 */
public class RequestEstudiante implements RequestParser<Estudiante> {

    private Gson json;
    private String body;
    private String params;

    public RequestEstudiante() {
        this.json = new Gson();
        this.body = null;
        this.params = null;
    }

    @Override
    public void setObject(Estudiante object) {
        this.body = this.json.toJson(object);
    }

    @Override
    public void setParams(Estudiante params, String option) {
        String cedula = params.cedula;
        this.params = "?cedula=" + cedula;
    }

    @Override
    public String parseObject() {
        return this.body;
    }

    @Override
    public String parseParams() {
        return this.params;
    }

}
