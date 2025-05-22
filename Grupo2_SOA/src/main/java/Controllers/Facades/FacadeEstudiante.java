/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers.Facades;

import Controllers.APIs.API;
import Controllers.APIs.APIEstudiantes;
import Controllers.Parsers.Request.RequestEstudiante;
import Controllers.Parsers.Request.RequestParser;
import Controllers.Parsers.Response.ResponseEstudiante;
import Controllers.Parsers.Response.ResponseParser;
import Models.Estudiante;
import java.util.ArrayList;

/**
 *
 * @author garci
 */
public class FacadeEstudiante {

    private ResponseParser<Estudiante> responseParser;
    private RequestParser<Estudiante> requestParser;
    private API<Estudiante> apiRest;

    public FacadeEstudiante(String path) {
        this.apiRest = new APIEstudiantes(path);
        this.responseParser = new ResponseEstudiante(this.apiRest);
        this.requestParser = new RequestEstudiante();

    }

    public ArrayList<Estudiante> getEstudiantes() {
        try {
            this.apiRest.GET();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return new ArrayList<Estudiante>();
        }
        return this.responseParser.parseResponses();
    }

    public Estudiante getEstudianteCedula(String cedula) {
        Estudiante filtro = new Estudiante();
        filtro.cedula = cedula;
        this.requestParser.setParams(filtro, null);
        try {
            this.apiRest.GET(this.requestParser);
            ArrayList<Estudiante> encontrados = this.responseParser.parseResponses();
            if (encontrados.size() > 0) {
                return encontrados.get(0);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return null;
    }

    public boolean postEstudiante(Estudiante est) {
        boolean result = false;
        this.requestParser.setObject(est);
        try {
            this.apiRest.POST(this.requestParser);
            result = this.responseParser.parseSuccess();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return false;
        }
        return result;
    }

    public boolean deleteEstudiante(Estudiante est) {
        boolean result = false;
        this.requestParser.setParams(est, null);
        try {
            this.apiRest.DELETE(this.requestParser);
            result = this.responseParser.parseSuccess();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                System.out.println(stackTraceElement);
            }
            return false;
        }
        return result;
    }

    public boolean putEstudiante(Estudiante est) {
        boolean result = false;
        this.requestParser.setObject(est);
        this.requestParser.setParams(est, null);
        try {
            this.apiRest.PUT(this.requestParser);
            result = this.responseParser.parseSuccess();
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }
        return result;
    }

}
