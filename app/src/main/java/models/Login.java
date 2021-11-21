package models;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Login {

    private String usuario;
    private String senha;
    private int usuarioid;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public static String parseJson(Login login) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("usuario", login.getUsuario());
            jsonObject.put("senha", login.getSenha());
            jsonObject.put("usuarioid", login.getUsuarioid());
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
                login.setUsuario(obj.getString("usuario"));
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
            login.setUsuario(obj.getString("usuario"));
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
