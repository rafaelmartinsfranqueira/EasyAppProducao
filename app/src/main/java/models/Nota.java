package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Nota {

    public String getNotanome() {
        return notanome;
    }

    public void setNotanome(String notanome) {
        this.notanome = notanome;
    }

    public String getNotavalor() {
        return notavalor;
    }

    public void setNotavalor(String notavalor) {
        this.notavalor = notavalor;
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

    private String notanome;
    private String notavalor;
    private int materiaid;
    private int notaid;

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    private int usuarioid;

    public static String parseJson(Nota nota) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("notanome", nota.getNotanome());
            jsonObject.put("notavalor", nota.getNotavalor());
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
                nota.setNotanome(obj.getString("notanome"));
                nota.setNotavalor(obj.getString("notavalor"));
                nota.setMateriaid(obj.getInt("materiaid"));
                nota.setNotaid(obj.getInt("notaid"));
                nota.setNotaid(obj.getInt("usuarioid"));
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
            nota.setNotanome(obj.getString("notanome"));
            nota.setNotavalor(obj.getString("notavalor"));
            nota.setMateriaid(obj.getInt("materiaid"));
            nota.setNotaid(obj.getInt("notaid"));
            nota.setNotaid(obj.getInt("usuarioid"));
            return nota;
        } catch (Exception ex) {
            return null;
        }
    }

    public Nota() {
    }

    public Nota(int notaid,int usuarioid, String notanome, String notavalor, int materiaid) {
        notaid = notaid;
        usuarioid = usuarioid;
        notanome = notanome;
        notavalor = notavalor;
        materiaid = materiaid;
    }
}
