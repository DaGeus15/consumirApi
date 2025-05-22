/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Parsers.Response;

import Controllers.APIs.API;
import Models.Estudiante;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author garci
 */
public class ResponseEstudiante implements ResponseParser<Estudiante> {

    private API<Estudiante> api;

    public ResponseEstudiante(API<Estudiante> api) {
        this.api = api;
    }

    @Override
    public ArrayList<Estudiante> parseResponses() {
        String body = this.api.fetchRawData();
        Gson json = new Gson();
        Type listType = new TypeToken<ArrayList<Estudiante>>() {

        }.getType();
        JsonReader reader = new JsonReader(new StringReader(body));
        reader.setLenient(true);
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
        if (response.equals("1") || response.equals("true")) {
            return true;
        } else if (response.equals("0") || response.equals("false")) {
            return false;
        }
        throw new Exception("Respuesta inesperada de la API " + response);
    }

}
