package models;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Login {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    private String senha;
    private int usuarioid;

    public static String parseJson(Login login) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nome", login.getNome());
            jsonObject.put("senha", login.getSenha());
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
                login.setNome(obj.getString("nome"));
                login.setSenha(obj.getString("senha"));
                login.setUsuarioid(obj.getInt("usuarioid"));
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
            login.setNome(obj.getString("nome"));
            login.setSenha(obj.getString("senha"));
            login.setUsuarioid(obj.getInt("id"));
            return login;
        } catch (Exception ex) {
            return null;
        }
    }

    public Login() {
    }

    public Login(int usuarioid, String nome, String senha) {
        usuarioid = usuarioid;
        nome = nome;
        senha = senha;
    }
}
