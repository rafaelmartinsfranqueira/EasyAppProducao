package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Nota {

    private String notanome1;
    private String notavalor1;
    private String notanome2;
    private String notavalor2;
    private String notanome3;
    private String notavalor3;
    private String notanome4;
    private String notavalor4;
    private String notamedia;
    private String notamediacalculada;
    private int materiaid;
    private int notaid;
    private int usuarioid;

    public String getNotanome1() {
        return notanome1;
    }

    public void setNotanome1(String notanome1) {
        this.notanome1 = notanome1;
    }

    public String getNotavalor1() {
        return notavalor1;
    }

    public void setNotavalor1(String notavalor1) {
        this.notavalor1 = notavalor1;
    }

    public String getNotanome2() {
        return notanome2;
    }

    public void setNotanome2(String notanome2) {
        this.notanome2 = notanome2;
    }

    public String getNotavalor2() {
        return notavalor2;
    }

    public void setNotavalor2(String notavalor2) {
        this.notavalor2 = notavalor2;
    }

    public String getNotanome3() {
        return notanome3;
    }

    public void setNotanome3(String notanome3) {
        this.notanome3 = notanome3;
    }

    public String getNotavalor3() {
        return notavalor3;
    }

    public void setNotavalor3(String notavalor3) {
        this.notavalor3 = notavalor3;
    }

    public String getNotanome4() {
        return notanome4;
    }

    public void setNotanome4(String notanome4) {
        this.notanome4 = notanome4;
    }

    public String getNotavalor4() {
        return notavalor4;
    }

    public void setNotavalor4(String notavalor4) {
        this.notavalor4 = notavalor4;
    }

    public String getNotamedia() {
        return notamedia;
    }

    public void setNotamedia(String notamedia) {
        this.notamedia = notamedia;
    }

    public String getNotamediacalculada() {
        return notamediacalculada;
    }

    public void setNotamediacalculada(String notamediacalculada) {
        this.notamediacalculada = notamediacalculada;
    }

    public int getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(int materiaid) {
        this.materiaid = materiaid;
    }

    public int getNotaid() {
        return notaid;
    }

    public void setNotaid(int notaid) {
        this.notaid = notaid;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public static String parseJson(Nota nota) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("notanome1", nota.getNotanome1());
            jsonObject.put("notavalor1", nota.getNotavalor1());
            jsonObject.put("notanome2", nota.getNotanome2());
            jsonObject.put("notavalor2", nota.getNotavalor2());
            jsonObject.put("notanome3", nota.getNotanome3());
            jsonObject.put("notavalor3", nota.getNotavalor3());
            jsonObject.put("notanome4", nota.getNotanome4());
            jsonObject.put("notavalor4", nota.getNotavalor4());
            jsonObject.put("notamedia", nota.getNotamedia());
            jsonObject.put("notamediacalculada", nota.getNotamediacalculada());
            jsonObject.put("materiaid", nota.getMateriaid());
            jsonObject.put("notaid", nota.getNotaid());
            jsonObject.put("usuarioid", nota.getUsuarioid());
            return jsonObject.toString();
        } catch (Exception ex) {
            return "";
        }
    }

    public static ArrayList<Nota> parseObject(String json) {
        ArrayList<Nota> notas = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Nota nota = new Nota();
                JSONObject obj = array.getJSONObject(i);
                nota.setNotanome1(obj.getString("notanome1"));
                nota.setNotavalor1(obj.getString("notavalor1"));
                nota.setNotanome2(obj.getString("notanome2"));
                nota.setNotavalor2(obj.getString("notavalor2"));
                nota.setNotanome3(obj.getString("notanome3"));
                nota.setNotavalor3(obj.getString("notavalor3"));
                nota.setNotanome4(obj.getString("notanome4"));
                nota.setNotavalor4(obj.getString("notavalor4"));
                nota.setNotamedia(obj.getString("notamedia"));
                nota.setNotamediacalculada(obj.getString("notamediacalculada"));
                nota.setMateriaid(obj.getInt("materiaid"));
                nota.setNotaid(obj.getInt("notaid"));
                nota.setUsuarioid(obj.getInt("usuarioid"));
                notas.add(nota);
            }
            return notas;
        } catch (Exception ex) {
            return notas;
        }
    }

    public static Nota parseOneObject(String json) {
        try {
            Nota nota = new Nota();
            JSONObject obj = new JSONObject(json);
            nota.setNotanome1(obj.getString("notanome1"));
            nota.setNotavalor1(obj.getString("notavalor1"));
            nota.setNotanome2(obj.getString("notanome2"));
            nota.setNotavalor2(obj.getString("notavalor2"));
            nota.setNotanome3(obj.getString("notanome3"));
            nota.setNotavalor3(obj.getString("notavalor3"));
            nota.setNotanome4(obj.getString("notanome4"));
            nota.setNotavalor4(obj.getString("notavalor4"));
            nota.setNotamedia(obj.getString("notamedia"));
            nota.setNotamediacalculada(obj.getString("notamediacalculada"));
            nota.setMateriaid(obj.getInt("materiaid"));
            nota.setNotaid(obj.getInt("notaid"));
            nota.setUsuarioid(obj.getInt("usuarioid"));
            return nota;
        } catch (Exception ex) {
            return null;
        }
    }

    public Nota() {
    }

    public Nota(int notaid, int usuarioid, String notanome1, String notavalor1, String notanome2, String notavalor2, String notanome3, String notavalor3, String notanome4, String notavalor4, String notamedia, String notamediacalculada, int materiaid) {
        notaid = notaid;
        usuarioid = usuarioid;
        notanome1 = notanome1;
        notavalor1 = notavalor1;
        notanome2 = notanome2;
        notavalor2 = notavalor2;
        notanome3 = notanome3;
        notavalor3 = notavalor3;
        notanome4 = notanome4;
        notavalor4 = notavalor4;
        notamedia = notamedia;
        notamediacalculada = notamediacalculada;
        materiaid = materiaid;
    }
}
