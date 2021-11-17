package models;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Login {

    private String Nome;
    private String Senha;
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public static String parseJson(Login login) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Nome", login.getNome());
            jsonObject.put("Senha", login.getSenha());
            return jsonObject.toString();
        } catch (Exception ex) {
            return "";
        }
    }

    public static ArrayList<Login> parseObject(String json) {
        ArrayList<Login> logins = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Login login = new Login();
                JSONObject obj = array.getJSONObject(i);
                login.setNome(obj.getString("Nome"));
                login.setSenha(obj.getString("Senha"));
                login.setId(obj.getInt("id"));
                logins.add(login);
            }
            return logins;
        } catch (Exception ex) {
            return logins;
        }
    }

    public static Login parseOneObject(String json) {
        try {
            Login login = new Login();
            JSONObject obj = new JSONObject(json);
            login.setNome(obj.getString("Nome"));
            login.setSenha(obj.getString("Senha"));
            login.setId(obj.getInt("id"));
            return login;
        } catch (Exception ex) {
            return null;
        }
    }

    public Login() {
    }

    public Login(int id, String nome, String senha) {
        Id = id;
        Nome = nome;
        Senha = senha;
    }
}
