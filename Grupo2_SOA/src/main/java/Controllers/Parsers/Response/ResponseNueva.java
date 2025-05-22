/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Parsers.Response;

import Controllers.APIs.API;
import Models.Estudiante;
import Models.RespuestaNueva;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author garci
 */
public class ResponseNueva implements ResponseParser<Estudiante> {

    private API<Estudiante> api;

    public ResponseNueva(API<Estudiante> api) {
        this.api = api;
    }

    @Override
    public ArrayList<Estudiante> parseResponses() {
        String body = this.api.fetchRawData();
        Gson json = new Gson();
        Type listType = new TypeToken<ArrayList<Estudiante>>() {
        }.getType();
        return json.fromJson(body, listType);
    }

    @Override
    public Estudiante parseResponse() {
        String body = this.api.fetchRawData();
        Gson json = new Gson();
        return json.fromJson(body, Estudiante.class);
    }

    @Override
    public boolean parseSuccess() throws Exception {
        String response = this.api.fetchRawData();
        RespuestaNueva respuesta = (new Gson()).fromJson(response, RespuestaNueva.class);
        return respuesta.success;
    }
}
