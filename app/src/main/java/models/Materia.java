package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Materia {

    private int materiaid;
    private String materianome;
    private String materiameta;
    private int formulaid;
    private int usuarioid;

    public String getMaterianome() {
        return materianome;
    }

    public void setMaterianome(String materianome) {
        this.materianome = materianome;
    }

    public String getMateriameta() {
        return materiameta;
    }

    public void setMateriameta(String materiameta) {
        this.materiameta = materiameta;
    }

    public int getMateriaid() {
        return materiaid;
    }

    public void setMateriaid(int materiaid) {
        this.materiaid = materiaid;
    }

    public int getFormulaid() {
        return formulaid;
    }

    public void setFormulaid(int formulaid) {
        this.formulaid = formulaid;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public static String parseJson(Materia materia) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("materianome", materia.getMaterianome());
            jsonObject.put("materiameta", materia.getMateriameta());
            jsonObject.put("materiaid", materia.getMateriaid());
            jsonObject.put("formulaid", materia.getFormulaid());
            jsonObject.put("usuarioid", materia.getUsuarioid());
            return jsonObject.toString();
        } catch (Exception ex) {
            return "";
        }
    }

    public static ArrayList<Materia> parseObject(String json) {
        ArrayList<Materia> materias = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Materia materia = new Materia();
                JSONObject obj = array.getJSONObject(i);
                materia.setMaterianome(obj.getString("materianome"));
                materia.setMateriameta(obj.getString("materiameta"));
                materia.setMateriaid(obj.getInt("materiaid"));
                materia.setFormulaid(obj.getInt("formulaid"));
                materia.setUsuarioid(obj.getInt("usuarioid"));
                materias.add(materia);
            }
            return materias;
        } catch (Exception ex) {
            return materias;
        }
    }

    public static Materia parseOneObject(String json) {
        try {
            Materia materia = new Materia();
            JSONObject obj = new JSONObject(json);
            materia.setMaterianome(obj.getString("materianome"));
            materia.setMateriameta(obj.getString("materiameta"));
            materia.setMateriaid(obj.getInt("materiaid"));
            materia.setFormulaid(obj.getInt("formulaid"));
            materia.setUsuarioid(obj.getInt("usuarioid"));
            return materia;
        } catch (Exception ex) {
            return null;
        }
    }

    public Materia() {
    }

    public Materia(int materiaid, String materianome, String materiameta, int formulaid, int usuarioid) {
        materiaid = materiaid;
        materianome = materianome;
        materiameta = materiameta;
        formulaid = formulaid;
        usuarioid =usuarioid;
    }
}
