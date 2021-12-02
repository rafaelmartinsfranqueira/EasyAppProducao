package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Formula {

    private int formulaid;
    private String formulanome;
    private String formulanomenota1;
    private String formulanomenota2;
    private String formulanomenota3;
    private String formulanomenota4;
    private String formulapesonota1;
    private String formulapesonota2;
    private String formulapesonota3;
    private String formulapesonota4;
    private int usuarioid;

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public int getFormulaid() {
        return formulaid;
    }

    public void setFormulaid(int formulaid) {
        this.formulaid = formulaid;
    }

    public String getFormulanome() {
        return formulanome;
    }

    public void setFormulanome(String formulanome) {
        this.formulanome = formulanome;
    }

    public String getFormulanomenota1() {
        return formulanomenota1;
    }

    public void setFormulanomenota1(String formulanomenota1) {
        this.formulanomenota1 = formulanomenota1;
    }

    public String getFormulanomenota2() {
        return formulanomenota2;
    }

    public void setFormulanomenota2(String formulanomenota2) {
        this.formulanomenota2 = formulanomenota2;
    }

    public String getFormulanomenota3() {
        return formulanomenota3;
    }

    public void setFormulanomenota3(String formulanomenota3) {
        this.formulanomenota3 = formulanomenota3;
    }

    public String getFormulanomenota4() {
        return formulanomenota4;
    }

    public void setFormulanomenota4(String formulanomenota4) {
        this.formulanomenota4 = formulanomenota4;
    }

    public String getFormulapesonota1() {
        return formulapesonota1;
    }

    public void setFormulapesonota1(String formulapesonota1) {
        this.formulapesonota1 = formulapesonota1;
    }

    public String getFormulapesonota2() {
        return formulapesonota2;
    }

    public void setFormulapesonota2(String formulapesonota2) {
        this.formulapesonota2 = formulapesonota2;
    }

    public String getFormulapesonota3() {
        return formulapesonota3;
    }

    public void setFormulapesonota3(String formulapesonota3) {
        this.formulapesonota3 = formulapesonota3;
    }

    public String getFormulapesonota4() {
        return formulapesonota4;
    }

    public void setFormulapesonota4(String formulapesonota4) {
        this.formulapesonota4 = formulapesonota4;
    }

    public static String parseJson(Formula formula) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("formulaid", formula.getFormulaid());
            jsonObject.put("formulanome", formula.getFormulanome());
            jsonObject.put("formulanomenota1", formula.getFormulanomenota1());
            jsonObject.put("formulanomenota2", formula.getFormulanomenota2());
            jsonObject.put("formulanomenota3", formula.getFormulanomenota3());
            jsonObject.put("formulanomenota4", formula.getFormulanomenota4());
            jsonObject.put("formulapesonota1", formula.getFormulapesonota1());
            jsonObject.put("formulapesonota2", formula.getFormulapesonota2());
            jsonObject.put("formulapesonota3", formula.getFormulapesonota3());
            jsonObject.put("formulapesonota4", formula.getFormulapesonota4());
            jsonObject.put("usuarioid", formula.getUsuarioid());
            return jsonObject.toString();
        } catch (Exception ex) {
            return "";
        }
    }

    public static ArrayList<Formula> parseObject(String json) {
        ArrayList<Formula> formulas = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Formula formula = new Formula();
                JSONObject obj = array.getJSONObject(i);
                formula.setFormulaid(obj.getInt("formulaid"));
                formula.setFormulanome(obj.getString("formulanome"));
                formula.setFormulanomenota1(obj.getString("formulanomenota1"));
                formula.setFormulanomenota2(obj.getString("formulanomenota2"));
                formula.setFormulanomenota3(obj.getString("formulanomenota3"));
                formula.setFormulanomenota4(obj.getString("formulanomenota4"));
                formula.setFormulapesonota1(obj.getString("formulapesonota1"));
                formula.setFormulapesonota2(obj.getString("formulapesonota2"));
                formula.setFormulapesonota3(obj.getString("formulapesonota3"));
                formula.setFormulapesonota4(obj.getString("formulapesonota4"));
                formula.setUsuarioid(obj.getInt("usuarioid"));
                formulas.add(formula);
            }
            return formulas;
        } catch (Exception ex) {
            return formulas;
        }
    }

    public static Formula parseOneObject(String json) {
        try {
            Formula formula = new Formula();
            JSONObject obj = new JSONObject(json);
            formula.setFormulaid(obj.getInt("formulaid"));
            formula.setFormulanome(obj.getString("formulanome"));
            formula.setFormulanomenota1(obj.getString("formulanomenota1"));
            formula.setFormulanomenota2(obj.getString("formulanomenota2"));
            formula.setFormulanomenota3(obj.getString("formulanomenota3"));
            formula.setFormulanomenota4(obj.getString("formulanomenota4"));
            formula.setFormulapesonota1(obj.getString("formulapesonota1"));
            formula.setFormulapesonota2(obj.getString("formulapesonota2"));
            formula.setFormulapesonota3(obj.getString("formulapesonota3"));
            formula.setFormulapesonota4(obj.getString("formulapesonota4"));
            formula.setUsuarioid(obj.getInt("usuarioid"));
            return formula;
        } catch (Exception ex) {
            return null;
        }
    }

    public Formula() {
    }

    public Formula(int formulaid, int usuarioid, String formulanome, String formulanomenota1, String formulanomenota2, String formulanomenota3, String formulanomenota4, String formulapesonota1, String formulapesonota2, String formulapesonota3, String formulapesonota4) {
        this.formulaid = formulaid;
        this.formulanome = formulanome;
        this.formulanomenota1 = formulanomenota1;
        this.formulanomenota2 = formulanomenota2;
        this.formulanomenota3 = formulanomenota3;
        this.formulanomenota4 = formulanomenota4;
        this.formulapesonota1 = formulapesonota1;
        this.formulapesonota2 = formulapesonota2;
        this.formulapesonota3 = formulapesonota3;
        this.formulapesonota4 = formulapesonota4;
        this.usuarioid = usuarioid;
    }

    @Override
    public String toString() {
        return formulanome ;
    }
}
